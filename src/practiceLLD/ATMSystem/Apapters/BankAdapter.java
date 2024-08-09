package practiceLLD.ATMSystem.Apapters;

import practiceLLD.ATMSystem.Models.Card;

public interface BankAdapter {

    public boolean authenticateFromBank(Card card, long pin);


}
