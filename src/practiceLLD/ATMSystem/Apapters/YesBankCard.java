package practiceLLD.ATMSystem.Apapters;

import practiceLLD.ATMSystem.Enums.CardType;


public class YesBankCard extends CardForBank {

    public YesBankCard(long id, CardType cardType, String cardNumber, long pin) {
        super(id, cardType, cardNumber, pin);
    }
}
