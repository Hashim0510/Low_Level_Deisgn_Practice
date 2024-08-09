package practiceLLD.ATMSystem.Apapters;

import practiceLLD.ATMSystem.Models.Card;

public class YesBankAdapter implements BankAdapter{
    @Override
    public boolean authenticateFromBank(Card card, long pin) {
        return false;
    }

    @Override
    public void addAccount(Account account, CardForBank cardForBank) {

    }
}
