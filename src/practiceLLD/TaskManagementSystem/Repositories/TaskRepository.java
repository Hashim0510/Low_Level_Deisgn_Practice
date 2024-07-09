package practiceLLD.TaskManagementSystem.Repositories;

import practiceLLD.TaskManagementSystem.Models.Task;

import java.util.concurrent.ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

public class TaskRepository {

    //using ConcurrentHashMap for data
//    HashMap<Long, Task> taskStorage;
    private ConcurrentHashMap<Long, Task> taskStorage;

    public TaskRepository() {
        this.taskStorage = new ConcurrentHashMap<>();
    }

    public Task save(Task task){

        taskStorage.put(task.getId(), task);

        return taskStorage.get(task.getId());

    }

    public Task getTaskById(Long id){

        return taskStorage.get(id);

    }

    public Task deleteTaskById(Long id){

        return taskStorage.remove(id);

    }

}
