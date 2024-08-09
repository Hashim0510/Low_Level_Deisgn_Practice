package practiceLLD.ATMSystem.Models;

public class BaseModel {

    private long id;

    public BaseModel(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
