package practiceLLD.TaskManagementSystem.Controllers;

import practiceLLD.TaskManagementSystem.DTOs.*;
import practiceLLD.TaskManagementSystem.Exceptions.TaskNotExistException;
import practiceLLD.TaskManagementSystem.Models.Task;
import practiceLLD.TaskManagementSystem.Services.TaskService;

import java.util.List;

public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {

        this.taskService = taskService;

    }

    public CreateTaskResponseDTO createTask(CreateTaskRequestDTO createTaskRequestDTO){
        CreateTaskResponseDTO createTaskResponseDTO = new CreateTaskResponseDTO();

        try{
            Task savedTask = taskService.createTask(createTaskRequestDTO.getTask());
            createTaskResponseDTO.setTask(savedTask);
            createTaskResponseDTO.setStatus(ResponseStatus.SUCCESS);
        }
        catch(Exception e){

            createTaskResponseDTO.setStatus(ResponseStatus.FAILURE);
        }


        return createTaskResponseDTO;

    }

    public UpdateTaskResponseDTO updateTask(UpdateTaskRequestDTO updatetaskRequestDTO){

        UpdateTaskResponseDTO updatetaskResponseDTO = new UpdateTaskResponseDTO();

        try {
            Task updateTask = taskService.updateTask(updatetaskRequestDTO.getTask());
            updatetaskResponseDTO.setTask(updateTask);
            updatetaskResponseDTO.setStatus(ResponseStatus.SUCCESS);
        } catch (TaskNotExistException e) {
//            throw new RuntimeException(e);
            updatetaskResponseDTO.setStatus(ResponseStatus.FAILURE);
        }

        return updatetaskResponseDTO;

    }

    public DeleteTaskResponseDTO deleteTask(DeleteTaskRequestDTO deleteTaskRequestDTO){

        DeleteTaskResponseDTO deleteTaskResponseDTO = new DeleteTaskResponseDTO();

        boolean success = false;
        try {
            success = taskService.deleteTask(deleteTaskRequestDTO.getTask());
        } catch (TaskNotExistException e) {
            throw new RuntimeException(e);
        }

        if(success){

            deleteTaskResponseDTO.setStatus(ResponseStatus.SUCCESS);
        }
        else{

            deleteTaskResponseDTO.setStatus(ResponseStatus.FAILURE);
        }
        return deleteTaskResponseDTO;

    }

    public SearchTaskResponseDTO searchTask(SearchTaskRequestDTO searchTaskRequestDTO){

        SearchTaskResponseDTO searchTaskResponseDTO = new SearchTaskResponseDTO();

        List<Task> taskList = taskService.searchTask(searchTaskRequestDTO.getKeyword(), searchTaskRequestDTO.getUser());

        searchTaskResponseDTO.setTaskList(taskList);

        searchTaskResponseDTO.setStatus(ResponseStatus.SUCCESS);

        return searchTaskResponseDTO;

    }

    public FilterTaskResponseDTO filterTask(FilterTaskRequestDTO filterTaskRequestDTO){

        FilterTaskResponseDTO filterTaskResponseDTO = new FilterTaskResponseDTO();

        List<Task> taskList = taskService.filterTask(filterTaskRequestDTO.getTaskStatus(),
                filterTaskRequestDTO.getUser(), filterTaskRequestDTO.getDueDate(), filterTaskRequestDTO.getPriority());

        filterTaskResponseDTO.setTaskList(taskList);

        filterTaskResponseDTO.setStatus(ResponseStatus.SUCCESS);

        return filterTaskResponseDTO;

    }
}
