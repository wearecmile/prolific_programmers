package com.cmile.meetmate.controller;

import com.cmile.meetmate.entity.PaymentHistory;
import com.cmile.meetmate.service.PaymentHistoryService;
import com.cmile.meetmate.utils.constant.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiConstants.REQUEST_MAPPING_KEY_PAYMENT_HISTORY)
public class PaymentHistoryController {
    @Autowired
    PaymentHistoryService paymentHistoryService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody PaymentHistory paymentHistory) {
        return paymentHistoryService.save(paymentHistory);
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return paymentHistoryService.findAll();
    }

    @GetMapping(value = ApiConstants.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return paymentHistoryService.findById(id);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody PaymentHistory paymentHistory) {
        return paymentHistoryService.update(paymentHistory);
    }

    @DeleteMapping(ApiConstants.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return paymentHistoryService.delete(id);
    }
}
