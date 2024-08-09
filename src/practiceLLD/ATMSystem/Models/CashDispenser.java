package practiceLLD.ATMSystem.Models;

public class CashDispenser extends BaseModel{

    private double amount;

    public CashDispenser(long id){
        super(id);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
