package com.cmile.meetmate.service;

import com.cmile.meetmate.entity.Transaction;
import org.springframework.http.ResponseEntity;

public interface TransactionService {

    ResponseEntity<Object> findAll();

    ResponseEntity<Object> findById(Long phId);

    ResponseEntity<Object> save(Transaction transaction);

    ResponseEntity<Object> update(Transaction transaction);

    ResponseEntity<Object> delete(Long phId);
}
