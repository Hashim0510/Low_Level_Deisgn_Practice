package practiceLLD.TaskManagementSystem.Models;
import java.util.Date;

public class Subtask extends BaseModel{

    private String title;
    private String description;
    private Task task;
    private TaskStatus status;
    private TaskPriority priority;
    private Date duedate;
    private String feedback;

    public Subtask(long id, String title, String description, Task task, TaskStatus status, TaskPriority priority, Date duedate, String feedback) {
        super(id);
        this.title = title;
        this.description = description;
        this.task = task;
        this.status = status;
        this.priority = priority;
        this.duedate = duedate;
        this.feedback = feedback;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
