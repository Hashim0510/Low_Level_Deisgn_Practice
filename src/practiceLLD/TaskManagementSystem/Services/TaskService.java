package practiceLLD.TaskManagementSystem.Services;

import practiceLLD.TaskManagementSystem.Exceptions.TaskNotExistException;
import practiceLLD.TaskManagementSystem.Models.Task;
import practiceLLD.TaskManagementSystem.Models.TaskPriority;
import practiceLLD.TaskManagementSystem.Models.TaskStatus;
import practiceLLD.TaskManagementSystem.Models.User;
import practiceLLD.TaskManagementSystem.Repositories.TaskRepository;
import practiceLLD.TaskManagementSystem.Repositories.UserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskService {

    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public Task createTask(Task task){

        //1. check the assignedTo and assignedBy users are available in UserRepository ?

                //to be implemented if you want

        //2. if both the users are available in respective repositories, then add Task to TaskRepository
            //we don't have to handle synchronization over Task object here, because it is new Task
        Task savedTask = taskRepository.save(task);

        //3. get the user for whom going to add
            /*
            don't need to add synchronization for user Object, because of maintaining a copyOnWriteArrayList
            for List<Task> object, therefore data consistency will be take care of by the list
            Note : decision Based on for Task addition, removal, update on concurrent situation
             */

        User user = task.getAssignedTo();

        //4. adding task to User object's List<Task>
        User userDataFromRepo = userRepository.getUser(user);
        List<Task> tasks = userDataFromRepo.getTasks();
        tasks.add(savedTask);
        return savedTask;

    }

    public Task updateTask(Task task) throws TaskNotExistException {

        //1. check the assignedTo and assignedBy users are available in UserRepository ?


        //2. if both the users are available in respective repositories, then add Task to TaskRepository
        //we don't have to handle synchronization over Task object here, because it is new Task
        Task toUpdateTask = taskRepository.getTaskById(task.getId());

        if(toUpdateTask != null){
            //lock over the Task object to prevent other operation like delete or update by other user concurrently
            synchronized(toUpdateTask){
                User previousUser = toUpdateTask.getAssignedTo();
                User currentUser = task.getAssignedTo();
                toUpdateTask.setId(task.getId());
                toUpdateTask.setStatus(task.getStatus());
                toUpdateTask.setDescription(task.getDescription());
                toUpdateTask.setFeedback(task.getFeedback());
                toUpdateTask.setPriority(task.getPriority());
                toUpdateTask.setAssignedTo(task.getAssignedTo());
                toUpdateTask.setTitle(task.getTitle());
                toUpdateTask.setDueDate(task.getDueDate());

                //updating task to user's List<Task>
                if(!previousUser.equals(currentUser)) {
                    User user = task.getAssignedTo();
                    //4. adding task to User object's List<Task>
                    User currentUserDataFromRepo = userRepository.getUser(currentUser);
                    List<Task> currentUserTasks = currentUserDataFromRepo.getTasks();
                    currentUserTasks.add(toUpdateTask);
                    //5.removing task from previousUser
                    User previousUserDataFromRepo = userRepository.getUser(previousUser);
                    List<Task> previousUserTasks = previousUserDataFromRepo.getTasks();
                    previousUserTasks.remove(toUpdateTask);

                }

            }

        }
        else{

            throw new TaskNotExistException("Task is not exists !!!");
        }

        return toUpdateTask;


    }


    public boolean deleteTask(Task task) throws TaskNotExistException {

        //1. check the assignedTo and assignedBy users are available in UserRepository ?

        //2. Removing Task from TaskRepository
        Task deletedTask = taskRepository.deleteTaskById(task.getId());

        if(deletedTask == null){
            throw new TaskNotExistException("Task is not exists !!!");
        }


        //3.removing task from previousUser
        User UserDataFromRepo = userRepository.getUser(deletedTask.getAssignedTo());
        List<Task> userTasks = UserDataFromRepo.getTasks();
        userTasks.remove(deletedTask);
        return true;

    }

    public List<Task> searchTask(String keyword, User user) {

        //GOAL IS TO search tasks based on the keyword from title and description attributes in a Task Object

        //1. check the user is valid

        //get the tasks from UserRepository
        //we don't want to think about concurrent operations and synchronization here, at a point of time what result we are getting, we just send them
        List<Task> taskList = userRepository.getTasksByUserId(user.getId());
        List<Task> searchList = new ArrayList<>();
        for(Task task : taskList){

            if(task.getTitle().contains(keyword) || task.getDescription().contains(keyword)){

                searchList.add(task);
            }
        }
        return searchList;

    }


    public List<Task> filterTask(TaskStatus taskStatus, User user, Date dueDate, TaskPriority priority) {

        //GOAL IS TO filter based on priority, user, dueDate, TaskStatus

        //1. verify the user
        //get the tasks from UserRepository
        //we don't want to think about concurrent operations and synchronization here, at a point of time what result we are getting, we just send them
        List<Task> taskList = userRepository.getTasksByUserId(user.getId());
        List<Task> filteredList = new ArrayList<>();

        for(Task task : taskList){

            if(task.getStatus().equals(taskStatus) && task.getAssignedTo().equals(user) &&
            task.getPriority().equals(priority) && task.getDueDate().before(dueDate)){

                filteredList.add(task);

            }
        }

        return filteredList;

    }
}
