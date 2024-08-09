package practiceLLD.ATMSystem.Models;

import practiceLLD.ATMSystem.Enums.TransactionType;

import java.util.Date;

public class Transaction extends BaseModel{

    private Card card;
    private double amount;
    private Date date;
    private CashDispenser cashDispenser;
    private TransactionType transactionType;


    public Transaction(long id){
        super(id);
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CashDispenser getCashDispenser() {
        return cashDispenser;
    }

    public void setCashDispenser(CashDispenser cashDispenser) {
        this.cashDispenser = cashDispenser;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
