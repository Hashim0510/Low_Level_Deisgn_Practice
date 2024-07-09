package ParkingLot.DTOs;

import ParkingLot.Models.Ticket;

public class GenerateTicketResponseDTO extends ResponseDTO {

    private Ticket ticket;


    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
