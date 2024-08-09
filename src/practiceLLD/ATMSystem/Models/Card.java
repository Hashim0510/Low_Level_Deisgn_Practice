package practiceLLD.ATMSystem.Models;

import practiceLLD.ATMSystem.Enums.BankName;
import practiceLLD.ATMSystem.Enums.CardType;

public class Card extends BaseModel{

    private BankName bankName;
    private CardType cardType;
    private String cardNumber;

    public Card(long id, BankName bankName, CardType cardType, String cardNumber) {
        super(id);
        this.bankName = bankName;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
    }

    public BankName getBankName() {
        return bankName;
    }

    public void setBankName(BankName bankName) {
        this.bankName = bankName;
    }

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
}
