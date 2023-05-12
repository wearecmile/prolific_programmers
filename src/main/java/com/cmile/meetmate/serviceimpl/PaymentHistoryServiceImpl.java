package com.cmile.meetmate.serviceimpl;

import com.cmile.meetmate.entity.PaymentHistory;
import com.cmile.meetmate.models.JsonResponse;
import com.cmile.meetmate.repository.PaymentHistoryRepository;
import com.cmile.meetmate.service.PaymentHistoryService;
import com.cmile.meetmate.utils.constant.StringConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentHistoryServiceImpl implements PaymentHistoryService {

    @Autowired
    PaymentHistoryRepository paymentHistoryRepository;

    @Override
    public ResponseEntity<Object> findAll() {
        List<PaymentHistory> paymentHistoryList = paymentHistoryRepository.findAll();
        if (paymentHistoryList.isEmpty()) {
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_PAYMENT_HISTORY_FOUND)
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

        return ResponseEntity.status((HttpStatus.OK))
                .body(JsonResponse.builder()
                        .data(paymentHistoryList)
                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_PAYMENT_HISTORY_FETCHED)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> findById(Long phId) {
        Optional<PaymentHistory> optionalPaymentHistory = paymentHistoryRepository.findById(phId);
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
    public ResponseEntity<Object> save(PaymentHistory paymentHistory) {
        paymentHistory = paymentHistoryRepository.save(paymentHistory);
        if (paymentHistory == null) {
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_PAYMENT_HISTORY_NOT_CREATED)
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.OK))
                .body(JsonResponse.builder()
                        .data(paymentHistory)
                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_PAYMENT_HISTORY_CREATED)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> update(PaymentHistory paymentHistory) {
        Optional<PaymentHistory> optionalPaymentHistory = paymentHistoryRepository.findById(paymentHistory.getPhId());
        if (optionalPaymentHistory.isPresent()) {
            PaymentHistory updatePaymentHistory = optionalPaymentHistory.get();
            updatePaymentHistory.setPhAmount(paymentHistory.getPhAmount());
            updatePaymentHistory.setPhDate(paymentHistory.getPhDate());
            updatePaymentHistory.setPhNote(paymentHistory.getPhNote());
            updatePaymentHistory.setPhTime(paymentHistory.getPhTime());
            updatePaymentHistory.setPhUpdatedDateTime(paymentHistory.getPhUpdatedDateTime());
            paymentHistoryRepository.save(updatePaymentHistory);
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
        if (paymentHistoryRepository.findById(phId).isPresent()) {
            paymentHistoryRepository.deleteById(phId);
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
