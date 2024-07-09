package practiceLLD.TaskManagementSystem;

import practiceLLD.TaskManagementSystem.Controllers.TaskController;
import practiceLLD.TaskManagementSystem.DTOs.*;
import practiceLLD.TaskManagementSystem.Exceptions.TaskNotExistException;
import practiceLLD.TaskManagementSystem.Models.*;
import practiceLLD.TaskManagementSystem.Repositories.TaskRepository;
import practiceLLD.TaskManagementSystem.Repositories.UserRepository;
import practiceLLD.TaskManagementSystem.Services.TaskService;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskManagementMain {

    public static void main(String[] args) throws TaskNotExistException {

        UserRepository userRepository = new UserRepository();
        TaskRepository taskRepository = new TaskRepository();
        TaskService taskService = new TaskService(taskRepository, userRepository);
        TaskController taskController = new TaskController(taskService);

        //1. testing ADD task
        //1.1 -->  assignedTo and assignedBy are same

        CreateTaskRequestDTO createTaskRequestDTO = new CreateTaskRequestDTO();
        User user1 = new User(1, "HASHIM", "7010434556", "hashy05012000@gmail.com", new ArrayList<>(), new CopyOnWriteArrayList<>());
        User user2 = new User(2, "DIVYA", "989379392", "hashy05012000@gmail.com", new ArrayList<>(), new CopyOnWriteArrayList<>());
        userRepository.save(user1);
        userRepository.save(user2);
        Task createTask = new Task(1, "TASK 1", "TASK 1 DESCRIPTION", new ArrayList<>(), user1, TaskStatus.IN_PROGRESS, new Date(), TaskPriority.HIGH, "TASK 1 FEEDBACK", user1);
        createTaskRequestDTO.setTask(createTask);
        CreateTaskResponseDTO createTaskResponseDTO = taskController.createTask(createTaskRequestDTO);
        System.out.println(createTaskResponseDTO.getTask().getTitle());
        System.out.println(createTask.getTitle());

        //test update
        Task updateTask = new Task(1, "TASK 1", "TASK 1 DESCRIPTION", new ArrayList<>(), user1, TaskStatus.COMPLETED, new Date(), TaskPriority.HIGH, "TASK 1 FEEDBACK", user1);
        UpdateTaskRequestDTO updateTaskRequestDTO = new UpdateTaskRequestDTO();
        updateTaskRequestDTO.setTask(updateTask);
        UpdateTaskResponseDTO updateTaskResponseDTO = taskController.updateTask(updateTaskRequestDTO);
        System.out.println(updateTaskResponseDTO.getTask().getStatus());

        //test delete
        Task createTask2 = new Task(2, "TASK 2", "TASK 2 DESCRIPTION", new ArrayList<>(), user2, TaskStatus.IN_PROGRESS, new Date(), TaskPriority.HIGH, "TASK 2 FEEDBACK", user2);
        CreateTaskRequestDTO createTaskRequestDTO2 = new CreateTaskRequestDTO();
        createTaskRequestDTO2.setTask(createTask2);
        CreateTaskResponseDTO createTaskResponseDTO2 = taskController.createTask(createTaskRequestDTO2);

//        DeleteTaskRequestDTO deleteTaskRequestDTO = new DeleteTaskRequestDTO();
//        deleteTaskRequestDTO.setTask(createTask2);
//        DeleteTaskResponseDTO deleteTaskResponseDTO = taskController.deleteTask(deleteTaskRequestDTO);
//        System.out.println(deleteTaskResponseDTO.getStatus());

        //test search
        SearchTaskRequestDTO searchTaskRequestDTO = new SearchTaskRequestDTO();
        searchTaskRequestDTO.setUser(user1);
        searchTaskRequestDTO.setKeyword("Task 1");
        SearchTaskResponseDTO searchTaskResponseDTO = taskController.searchTask(searchTaskRequestDTO);
        System.out.println(searchTaskResponseDTO.getTaskList().toString());

        //test filter
        FilterTaskRequestDTO filterTaskRequestDTO = new FilterTaskRequestDTO();
        filterTaskRequestDTO.setTaskStatus(TaskStatus.IN_PROGRESS);
        filterTaskRequestDTO.setPriority(TaskPriority.HIGH);
        filterTaskRequestDTO.setUser(user2);
        filterTaskRequestDTO.setDueDate(new Date());
        FilterTaskResponseDTO filterTaskResponseDTO = taskController.filterTask(filterTaskRequestDTO);
        System.out.println(filterTaskResponseDTO.getTaskList().toString());

        //test concurrent operations

    }
}
