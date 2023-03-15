package dao;

import entity.Account;
import entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class MokedDataBase {
    private List<Account> accountTable = new ArrayList<>();
    private List<Customer> customerTable = new ArrayList<>();

    public List<Account> getAccountTable() {
        return accountTable;
    }

    public void setAccountTable(List<Account> accountTable) {
        this.accountTable = accountTable;
    }

    public List<Customer> getCustomerTable() {
        return customerTable;
    }

    public void setCustomerTable(List<Customer> customerTable) {
        this.customerTable = customerTable;
    }
}
