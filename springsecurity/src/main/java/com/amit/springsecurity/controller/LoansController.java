package com.amit.springsecurity.controller;

import com.amit.springsecurity.model.Customer;
import com.amit.springsecurity.model.Loans;
import com.amit.springsecurity.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {
    @Autowired
    private LoanRepository loanRepository;

    @PostMapping("/loans")
    public List<Loans> getLoanDetails(@RequestBody Customer customer) {
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(customer.getId());
        if (loans != null ) {
            return loans;
        }else {
            return null;
        }
    }



}
