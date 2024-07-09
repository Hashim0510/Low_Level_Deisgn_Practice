package practiceLLD.TaskManagementSystem.Models;

import java.util.List;

public class User extends BaseModel{

    private String title;
    private String phoneNumber;
    private String email;
    private List<User> friends;
    private List<Task> tasks;

    public User(long id, String title, String phoneNumber, String email, List<User> freinds, List<Task> tasks) {
        super(id);
        this.title = title;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.friends = freinds;
        this.tasks = tasks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
