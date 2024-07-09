package practiceLLD.TaskManagementSystem.Models;

public class BaseModel {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BaseModel(long id) {
        this.id = id;
    }
}
