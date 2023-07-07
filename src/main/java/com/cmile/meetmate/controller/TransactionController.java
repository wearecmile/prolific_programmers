package com.cmile.meetmate.controller;

import com.cmile.meetmate.entity.Transaction;
import com.cmile.meetmate.service.TransactionService;
import com.cmile.meetmate.utils.constant.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiConstants.REQUEST_MAPPING_KEY_TRANSACTION)
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Transaction transaction) {
        return transactionService.save(transaction);
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return transactionService.findAll();
    }

    @GetMapping(value = ApiConstants.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return transactionService.findById(id);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Transaction transaction) {
        return transactionService.update(transaction);
    }

    @DeleteMapping(ApiConstants.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return transactionService.delete(id);
    }
}
