package com.uedsonreis.ecommerce.service;

import com.uedsonreis.ecommerce.exception.BusinessException;
import com.uedsonreis.ecommerce.model.Customer;
import com.uedsonreis.ecommerce.model.Dispatch;
import com.uedsonreis.ecommerce.api.dto.DispatchOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DispatchService {

    @Autowired
    private CustomerService customerService;

    private final List<Dispatch> dispatchesDB = new ArrayList<>();

    public Dispatch create(DispatchOrder dispatchOrder) throws Exception {

        Customer customer = this.customerService.getBy(dispatchOrder.getRecipient());
        if (customer == null) throw new BusinessException("Cliente não encontrado(a)!");

        int nextId = 1;

        if (!this.dispatchesDB.isEmpty()) {
            Dispatch last = this.dispatchesDB.getLast();
            if (last != null) {
                nextId = last.getId() + 1;
            }
        }

        Dispatch dispatch = Dispatch.builder()
                .id(nextId)
                .productName(dispatchOrder.getProductName())
                .productType(dispatchOrder.getProductType())
                .responsible(customer.getName())
                .address(customer.getAddress())
                .build();

        this.dispatchesDB.add(dispatch);

        return dispatch;
    }

}
