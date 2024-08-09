package practiceLLD.ATMSystem.DTOs;

import practiceLLD.ATMSystem.Enums.AuthenticationResponse;

public class AuthenticateResponseDTO {
    private AuthenticationResponse authenticationResponse;
    private ResponseStatus responseStatus;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public AuthenticationResponse getAuthenticationResponse() {
        return authenticationResponse;
    }

    public void setAuthenticationResponse(AuthenticationResponse authenticationResponse) {
        this.authenticationResponse = authenticationResponse;
    }
}
