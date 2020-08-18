package com.jason.demo.seata.account.controller;

import com.jason.demo.seata.account.service.AccountService;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    public void debit(@RequestParam String userId, @RequestParam BigDecimal orderMoney) {
        System.out.println("account XID " + RootContext.getXID());
        accountService.debit(userId, orderMoney);
    }

}
