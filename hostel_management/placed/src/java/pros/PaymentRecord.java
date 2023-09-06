package pros;

public class PaymentRecord {
    private String dateTime;
    private double amountPaid;

    public PaymentRecord(String dateTime, double amountPaid) {
        this.dateTime = dateTime;
        this.amountPaid = amountPaid;
    }

    public String getDateTime() {
        return dateTime;
    }

    public double getAmountPaid() {
        return amountPaid;
    }
}
