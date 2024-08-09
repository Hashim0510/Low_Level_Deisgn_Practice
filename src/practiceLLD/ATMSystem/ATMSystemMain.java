package practiceLLD.ATMSystem;

import practiceLLD.ATMSystem.Apapters.*;
import practiceLLD.ATMSystem.Controllers.ATMController;
import practiceLLD.ATMSystem.DTOs.AuthenticateRequestDTO;
import practiceLLD.ATMSystem.DTOs.AuthenticateResponseDTO;
import practiceLLD.ATMSystem.Enums.BankName;
import practiceLLD.ATMSystem.Enums.CardType;
import practiceLLD.ATMSystem.Models.Card;
import practiceLLD.ATMSystem.Models.CashDispenser;
import practiceLLD.ATMSystem.Repositories.CashDispenserRepository;
import practiceLLD.ATMSystem.Services.ATMService;

import java.lang.reflect.AccessFlag;

public class ATMSystemMain {

    public static void main(String[] args) {

        //testing authentication
        CashDispenser cashDispenser = new CashDispenser(1);
        CashDispenserRepository cashDispenserRepository = new CashDispenserRepository();
        cashDispenserRepository.add(cashDispenser);
        ATMService atmService = new ATMService(cashDispenserRepository);
        ATMController atmController = new ATMController(atmService);

        Card card  = new Card(1, BankName.HDFC, CardType.DEBIT, "123");
        CardForBank cardForBank = new CardForBank(1, CardType.DEBIT, "123", 1234);
        Account account = new Account(1, "Hashim", cardForBank, AccountType.SAVINGS);
        BankAdapter bankAdapter = new HdfcBankAdapter();
        bankAdapter.addAccount(account, cardForBank);
        AuthenticateRequestDTO authenticateRequestDTO = new AuthenticateRequestDTO();
        authenticateRequestDTO.setCard(card);
        authenticateRequestDTO.setPin(1234);
        atmService.setBankAdapter(bankAdapter);
        AuthenticateResponseDTO authenticateResponseDTO = atmController.authenticate(authenticateRequestDTO);
        System.out.println(authenticateResponseDTO.getAuthenticationResponse());


    }
}
