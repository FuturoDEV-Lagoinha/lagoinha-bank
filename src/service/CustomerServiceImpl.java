package service;

import entity.Customer;
import service.interfaces.CustomerService;

import java.util.List;
import java.util.UUID;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer save(List<Customer> list, Customer customer) {
        customer.generateId();
        list.add(customer);
        return customer;
    }

    @Override
    public Customer updade(List<Customer> list, Customer customer) {
        return null;
    }

    @Override
    public Void deleteById(List<Customer> list, UUID id) {
        return null;
    }
}
