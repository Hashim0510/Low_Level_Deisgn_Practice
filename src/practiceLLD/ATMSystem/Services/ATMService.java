package practiceLLD.ATMSystem.Services;

import practiceLLD.ATMSystem.Apapters.BankAdapter;
import practiceLLD.ATMSystem.Models.Card;
import practiceLLD.ATMSystem.Repositories.CashDispenserRepository;

public class ATMService {

    private CashDispenserRepository cashDispenserRepository;
    private BankAdapter bankAdapter;

    public ATMService(CashDispenserRepository cashDispenserRepository) {
        this.cashDispenserRepository = cashDispenserRepository;
    }

    public void setBankAdapter(BankAdapter bankAdapter) {
        this.bankAdapter = bankAdapter;
    }

    public boolean authenticate(Card card, long pin) {

    }



}
