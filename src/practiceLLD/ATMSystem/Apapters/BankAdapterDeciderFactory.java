package practiceLLD.ATMSystem.Apapters;

import practiceLLD.ATMSystem.Enums.BankName;
import practiceLLD.ATMSystem.Models.Card;

public class BankAdapterDeciderFactory {

    public static BankAdapter bankDecider(Card card){

        if(card.getBankName().equals(BankName.HDFC)){

            return new HdfcBankAdapter();
        }
        else if(card.getBankName().equals(BankName.YES)){

            return new YesBankAdapter();
        }
        return null;
    }
}
