package entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Account {
    private UUID accountIdentifier;
    private LocalDateTime creationDate;
    private String agency;
    private String number;
    private UUID customerId;
    private BigDecimal amount;

    private static final String DEFAULT_AGENCY = "1";

    public Account(Integer number, UUID customerId) {
        this.accountIdentifier = UUID.randomUUID();
        this.creationDate = LocalDateTime.now();
        this.agency = DEFAULT_AGENCY;
        this.number = number.toString();
        this.customerId = customerId;
    }

    public UUID getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(UUID accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
