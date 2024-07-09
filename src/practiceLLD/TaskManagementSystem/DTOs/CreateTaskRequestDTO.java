package practiceLLD.TaskManagementSystem.DTOs;

import practiceLLD.TaskManagementSystem.Models.Task;

public class CreateTaskRequestDTO {

    private Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
