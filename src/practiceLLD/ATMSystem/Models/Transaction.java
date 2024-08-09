package practiceLLD.ATMSystem.Models;

import practiceLLD.ATMSystem.Enums.TransactionType;

import java.util.Date;

public class Transaction extends BaseModel{

    private Card card;
    private double amount;
    private Date date;
    private CashDispenser cashDispenser;
    private TransactionType transactionType;






}
