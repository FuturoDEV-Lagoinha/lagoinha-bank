package entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Account {
    private UUID accountIdentifier;
    private LocalDateTime creationDate;
    private String agency;
    private String number;
    private UUID customerId;
    private BigDecimal balance;
    private Pix pix;

    private static final String DEFAULT_AGENCY = "1";

    public Account() { }

    public Account(UUID customerId) {
        this.creationDate = LocalDateTime.now();
        this.agency = DEFAULT_AGENCY;
        this.customerId = customerId;
        this.balance = BigDecimal.ZERO;
    }

    public Pix getPix() {
        return pix;
    }

    public void setPix(Pix pix) {
        this.pix = pix;
    }

    public void idGenerator() { this.accountIdentifier = UUID.randomUUID(); }
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

    public String getNumber() {
        return number;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void generateAccountNumber(List<Account> accounts) {
        List<String> existsAccountNumber = filterExistsAccountNumbers(accounts);
        String [] numbers = generateRandom();
        String numberSelected = null;

        if(accounts.isEmpty()) {
            this.number = numbers[0];
        } else {
            for(int i = 0;i < 3;i++){
                if(!existsAccountNumber.contains(numbers[i])){
                    numberSelected = numbers[i];
                    break;
                }
            }
            this.number = numberSelected;
        }
    }

    private String[] generateRandom() {
        Double randomNumber = Math.random();
        String stringRandomNumber = randomNumber.toString();
        String [] numbers = stringRandomNumber.split("\\.");
        return numbers[1].split("(?<=\\G.....)");
    }

    private List<String> filterExistsAccountNumbers(List<Account> accounts) {
        List<String> existsAccountNumber = new ArrayList<>();
        accounts.forEach(account -> {
            existsAccountNumber.add(account.getNumber());
        });
        return existsAccountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountIdentifier=" + accountIdentifier +
                ", creationDate=" + creationDate +
                ", agency='" + agency + '\'' +
                ", number='" + number + '\'' +
                ", customerId=" + customerId +
                ", balance=" + balance +
                ", pix=" + pix +
                '}';
    }
}
