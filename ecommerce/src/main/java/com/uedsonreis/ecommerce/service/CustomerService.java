package com.uedsonreis.ecommerce.service;

import com.uedsonreis.ecommerce.exception.BusinessException;
import com.uedsonreis.ecommerce.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final List<Customer> customersDB = new ArrayList<>();

    public Customer getBy(String cnpjCpf) {
        if (!this.customersDB.isEmpty()) {
            Optional<Customer> optional = this.customersDB.stream().filter(c -> c.getCnpjCpf().equals(cnpjCpf)).findFirst();
            if (optional.isPresent()) return optional.get();
        }
        return null;
    }

    public void save(Customer customer) throws Exception {

        if (customer == null || customer.getCnpjCpf() == null || customer.getName() == null) {
            throw new BusinessException("Customer Object is invalid for save!");
        }
        if (customer.getAddress() == null || customer.getAddress().getPostalCode() == null || customer.getAddress().getDescription() == null || customer.getAddress().getCity() == null) {
            throw new BusinessException("Address Object is invalid for save!");
        }

        if (!this.customersDB.isEmpty()) {
            Optional<Customer> saved = this.customersDB.stream().filter(c -> c.getCnpjCpf().equals(customer.getCnpjCpf())).findFirst();
            if (saved.isPresent()) {
                Customer customerSaved = saved.get();
                customerSaved.setName(customer.getName());
                customerSaved.setAddress(customer.getAddress());
            }
        }

        this.customersDB.add(customer);
    }

    public void delete(Customer customer) throws BusinessException {
        if (customer == null || customer.getCnpjCpf() == null) {
            throw new BusinessException("Customer Object is invalid for delete!");
        }
        this.customersDB.remove(customer);
    }

}
