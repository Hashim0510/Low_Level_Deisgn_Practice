package practiceLLD.TaskManagementSystem.Models;
import java.util.Date;
import java.util.List;

public class Task extends BaseModel{

    private String title;
    private String description;
    private List<Subtask> substasks;
    private User assignedTo;
    private TaskStatus status;
    private Date dueDate;
    private TaskPriority priority;
    private String feedback;
    private User assignedBy;


    public Task(long id, String title, String description, List<Subtask> substasks, User assignedTo, TaskStatus status, Date dueDate, TaskPriority priority, String feedback, User assignedBy) {
        super(id);
        this.title = title;
        this.description = description;
        this.substasks = substasks;
        this.assignedTo = assignedTo;
        this.status = status;
        this.dueDate = dueDate;
        this.priority = priority;
        this.feedback = feedback;
        this.assignedBy = assignedBy;
    }

//    public Task(){
//        super();
//
//    }

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

    public List<Subtask> getSubstasks() {
        return substasks;
    }

    public void setSubstasks(List<Subtask> substasks) {
        this.substasks = substasks;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public User getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(User assignedBy) {
        this.assignedBy = assignedBy;
    }
}
