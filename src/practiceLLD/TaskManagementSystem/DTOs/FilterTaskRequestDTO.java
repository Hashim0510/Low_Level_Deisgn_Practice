package practiceLLD.TaskManagementSystem.DTOs;

import practiceLLD.TaskManagementSystem.Models.TaskPriority;
import practiceLLD.TaskManagementSystem.Models.TaskStatus;
import practiceLLD.TaskManagementSystem.Models.User;

import java.util.Date;

public class FilterTaskRequestDTO {

    private User user;
    private TaskPriority priority;
    private Date dueDate;
    private TaskStatus taskStatus;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
}
