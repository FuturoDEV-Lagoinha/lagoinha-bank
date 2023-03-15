package entity;

import java.util.List;
import java.util.UUID;

public class Customer {
    private UUID uuid;
    private String name;
    private String documentNumber;
    private String email;
    private Address address;
    private List<Phone> phoneList;

    public Customer(String name, String documentNumber, String email, Address address, List<Phone> phoneList) {
        this.name = name;
        this.documentNumber = documentNumber;
        this.email = email;
        this.address = address;
        this.phoneList = phoneList;
    }

    public void generateId() {
        this.uuid = UUID.randomUUID();
    }
    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", phoneList=" + phoneList +
                '}';
    }
}
