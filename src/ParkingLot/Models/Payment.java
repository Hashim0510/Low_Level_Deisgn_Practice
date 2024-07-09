package ParkingLot.Models;

import ParkingLot.Models.Enums.PaymentMode;
import ParkingLot.Models.Enums.PaymentStatus;

import java.util.Date;

public class Payment {

    private long id;
    private PaymentMode paymentMode;
    private Date Time;
    private PaymentStatus paymentStatus;
    private long amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
