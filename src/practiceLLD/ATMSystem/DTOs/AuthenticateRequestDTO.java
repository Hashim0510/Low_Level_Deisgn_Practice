package practiceLLD.ATMSystem.DTOs;

import practiceLLD.ATMSystem.Models.Card;

public class AuthenticateRequestDTO {

    private Card card;
    private long pin;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public long getPin() {
        return pin;
    }

    public void setPin(long pin) {
        this.pin = pin;
    }
}
