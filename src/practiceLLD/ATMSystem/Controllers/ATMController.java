package practiceLLD.ATMSystem.Controllers;

import practiceLLD.ATMSystem.DTOs.*;
import practiceLLD.ATMSystem.Enums.AuthenticationResponse;
import practiceLLD.ATMSystem.Services.ATMService;

public class ATMController {

    private ATMService atmService;

    public ATMController(ATMService atmService) {
        this.atmService = atmService;
    }

    public AuthenticateResponseDTO authenticate(AuthenticateRequestDTO authenticateRequestDTO){

        AuthenticateResponseDTO authenticateResponseDTO = new AuthenticateResponseDTO();
        boolean authenticateStatus = false;
        try{
            authenticateStatus = atmService.authenticate(authenticateRequestDTO.getCard(), authenticateRequestDTO.getPin());
            if(authenticateStatus){
                authenticateResponseDTO.setAuthenticationResponse(AuthenticationResponse.AUTHENTICATED);
            }
            else{
                authenticateResponseDTO.setAuthenticationResponse(AuthenticationResponse.NOT_AUTHENTICATED);
            }
            authenticateResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch(Exception e){
            authenticateResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }


        return authenticateResponseDTO;

    }

//    public BalanceEnquiryResponseDTO balanceEnquiry(BalanceEnquiryRequestDTO balanceEnquiryRequestDTO){
//
//        atmService.balanceEnquiry()
//
//    }
//
//    public WithdrawalResponseDTO withdrawal(WithdrawalRequestDTO withdrawalRequestDTO){
//
//
//    }
//
//    public WithdrawalResponseDTO deposit(WithdrawalRequestDTO depositRequestDTO){
//
//
//    }


}
