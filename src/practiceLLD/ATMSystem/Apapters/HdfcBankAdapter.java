package practiceLLD.ATMSystem.Apapters;

import practiceLLD.ATMSystem.Models.Card;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class HdfcBankAdapter implements BankAdapter{

    //storing based  cards with their card number as key
    Map<String, Account> hdfcBankAccountHolders;

    public HdfcBankAdapter() {

        this.hdfcBankAccountHolders = new ConcurrentHashMap<>();

    }


    @Override
    public boolean authenticateFromBank(Card card, long pin) {

        //convert Card object to HdfcBankCard object
        for(Account account : hdfcBankAccountHolders.values()){

            if(account.getCardForBank().getCardNumber().equals(card.getCardNumber()) &&
                    account.getCardForBank().getPin() == pin){

                return true;

            }
        }

        return false;
    }
    @Override
    public void addAccount(Account account, CardForBank card){

        hdfcBankAccountHolders.put(card.getCardNumber(), account);
    }



}

