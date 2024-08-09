package practiceLLD.ATMSystem.Apapters;

import practiceLLD.ATMSystem.Models.Card;

import java.util.List;

public class Account {

    private long id;
    private String name;
    private CardForBank cardForBank;
    private AccountType accountType;
    private double amount;

    public Account(long id, String name, CardForBank cardForBank, AccountType accountType) {
        this.id = id;
        this.name = name;
        this.cardForBank = cardForBank;
        this.accountType = accountType;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CardForBank getCardForBank() {
        return cardForBank;
    }

    public void setCardForBank(CardForBank cardForBank) {
        this.cardForBank = cardForBank;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
