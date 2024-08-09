package practiceLLD.ATMSystem.Apapters;

import practiceLLD.ATMSystem.Enums.CardType;

public class HdfcBankCard extends CardForBank{

    public HdfcBankCard(long id, CardType cardType, String cardNumber, long pin) {
        super(id, cardType, cardNumber, pin);
    }
}
