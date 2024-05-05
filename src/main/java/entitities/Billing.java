package entitities;

import java.math.BigDecimal;
import java.util.Date;

public class Billing {
    private int id;
    private int patientId;
    private BigDecimal amount;
    private Date invoiceDate;
    private boolean paid;
    // Other relevant billing data

    // Constructors, getters, and setters

    public Billing() {
    }

    public Billing(int id, int patientId, BigDecimal amount, Date invoiceDate, boolean paid) {
        this.id = id;
        this.patientId = patientId;
        this.amount = amount;
        this.invoiceDate = invoiceDate;
        this.paid = paid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
