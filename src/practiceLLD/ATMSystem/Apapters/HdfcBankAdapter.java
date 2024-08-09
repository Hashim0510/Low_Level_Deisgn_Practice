package practiceLLD.ATMSystem.Apapters;

import practiceLLD.ATMSystem.Models.Card;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HdfcBankAdapter implements BankAdapter{

    //storing based  cards with their card number as key
    Map<String, Account> hdfcBankAccountHolders;


        this.hdfcBankAccountHolders = new ConcurrentHashMap<>();

    }

    @Override
    public boolean authenticateFromBank(Card card, long pin) {

        //convert Card object to HdfcBankCard object



    }
}

