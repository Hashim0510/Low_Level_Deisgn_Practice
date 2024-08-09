package practiceLLD.ATMSystem.Services;

import practiceLLD.ATMSystem.Apapters.BankAdapter;
import practiceLLD.ATMSystem.Apapters.BankAdapterDeciderFactory;
import practiceLLD.ATMSystem.Models.Card;
import practiceLLD.ATMSystem.Repositories.CashDispenserRepository;

public class ATMService {

    private CashDispenserRepository cashDispenserRepository;
    //for testing purpose use this, otherwise, use client will use factory generator to generate bankAdapter object
    private BankAdapter bankAdapter;

    public ATMService(CashDispenserRepository cashDispenserRepository) {
        this.cashDispenserRepository = cashDispenserRepository;
    }

    public void setBankAdapter(BankAdapter bankAdapter) {
        this.bankAdapter = bankAdapter;
    }

    public boolean authenticate(Card card, long pin) {
//        return BankAdapterDeciderFactory.bankDecider(card).authenticateFromBank(card, pin);
        return bankAdapter.authenticateFromBank(card, pin);
    }



}
