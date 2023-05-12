package com.cmile.meetmate.service;

import com.cmile.meetmate.entity.PaymentHistory;
import org.springframework.http.ResponseEntity;

public interface PaymentHistoryService {
    ResponseEntity<Object> findAll();

    ResponseEntity<Object> findById(Long phId);

    ResponseEntity<Object> save(PaymentHistory paymentHistory);

    ResponseEntity<Object> update(PaymentHistory paymentHistory);

    ResponseEntity<Object> delete(Long phId);
}
