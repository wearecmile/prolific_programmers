package com.cmile.meetmate.serviceimpl;

import com.cmile.meetmate.entity.Transaction;
import com.cmile.meetmate.models.JsonResponse;
import com.cmile.meetmate.repository.TransactionRepository;
import com.cmile.meetmate.service.TransactionService;
import com.cmile.meetmate.utils.constant.StringConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public ResponseEntity<Object> findAll() {
        List<Transaction> transactionList = transactionRepository.findAll();
        if (transactionList.isEmpty()) {
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_PAYMENT_HISTORY_FOUND)
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

        return ResponseEntity.status((HttpStatus.OK))
                .body(JsonResponse.builder()
                        .data(transactionList)
                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_PAYMENT_HISTORY_FETCHED)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> findById(Long phId) {
        Optional<Transaction> optionalPaymentHistory = transactionRepository.findById(phId);
        if (optionalPaymentHistory.isPresent()) {
            return ResponseEntity.status((HttpStatus.OK))
                    .body(JsonResponse.builder()
                            .data(optionalPaymentHistory)
                            .message(StringConstants.REQUEST_SUCCESS_MESSAGE_PAYMENT_HISTORY_FETCHED)
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                .body(JsonResponse.builder()
                        .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_PAYMENT_HISTORY_FOUND)
                        .status(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> save(Transaction transaction) {
        transaction = transactionRepository.save(transaction);
        if (transaction == null) {
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_PAYMENT_HISTORY_NOT_CREATED)
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.OK))
                .body(JsonResponse.builder()
                        .data(transaction)
                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_PAYMENT_HISTORY_CREATED)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> update(Transaction transaction) {
        Optional<Transaction> optionalPaymentHistory = transactionRepository.findById(transaction.getPhId());
        if (optionalPaymentHistory.isPresent()) {
            Transaction updateTransaction = optionalPaymentHistory.get();
            updateTransaction.setPhAmount(transaction.getPhAmount());
            updateTransaction.setPhDate(transaction.getPhDate());
            updateTransaction.setPhNote(transaction.getPhNote());
            updateTransaction.setPhTime(transaction.getPhTime());
            updateTransaction.setPhUpdatedDateTime(transaction.getPhUpdatedDateTime());
            transactionRepository.save(updateTransaction);
            return ResponseEntity.status((HttpStatus.OK))
                    .body(JsonResponse.builder()
                            .data(optionalPaymentHistory)
                            .message(StringConstants.REQUEST_SUCCESS_MESSAGE_PAYMENT_HISTORY_UPDATED)
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                .body(JsonResponse.builder()
                        .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_PAYMENT_HISTORY_FOUND)
                        .status(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> delete(Long phId) {
        if (transactionRepository.findById(phId).isPresent()) {
            transactionRepository.deleteById(phId);
            return ResponseEntity.status((HttpStatus.OK))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_SUCCESS_MESSAGE_PAYMENT_HISTORY_DELETED)
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                .body(JsonResponse.builder()
                        .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_PAYMENT_HISTORY_FOUND)
                        .status(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build());
    }
}
