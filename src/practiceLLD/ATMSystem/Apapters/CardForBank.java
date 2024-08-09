package practiceLLD.ATMSystem.Apapters;

import practiceLLD.ATMSystem.Enums.CardType;

public class CardForBank {

    private long id;
    private CardType cardType;
    private String cardNumber;
    private long pin;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPin() {
        return pin;
    }

    public void setPin(long pin) {
        this.pin = pin;
    }
}
