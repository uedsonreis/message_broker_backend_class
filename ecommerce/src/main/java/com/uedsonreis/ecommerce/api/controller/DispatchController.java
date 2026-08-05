package com.uedsonreis.ecommerce.api.controller;

import com.uedsonreis.ecommerce.model.Dispatch;
import com.uedsonreis.ecommerce.model.DispatchOrder;
import com.uedsonreis.ecommerce.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dispatch")
public class DispatchController {

    @Autowired
    private DispatchService service;

    @PostMapping
    public Dispatch store(@RequestBody DispatchOrder dispatchOrder) throws Exception {
        return this.service.create(dispatchOrder);
    }

}
