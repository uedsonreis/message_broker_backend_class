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

    public Customer create(Customer customer) throws Exception {
        if (!this.customersDB.isEmpty()) {
            if (this.customersDB.stream().anyMatch(c -> c.getCnpjCpf().equals(customer.getCnpjCpf()))) {
                throw new BusinessException("CNPJ/CPF já cadastrado!");
            }
        }

        this.customersDB.add(customer);

        return customer;
    }

}
