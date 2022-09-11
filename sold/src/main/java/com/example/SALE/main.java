package com.example.SALE;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class main {
    @Entity
    public class Main {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private String RequestReference;
        private long BusinessId;
        private int ItemId;
        private String TransactionReference;
        private String TransactionType;
        private int TransactionAmount;
        private LocalDateTime TransactionDate;
        private int Quantity;

        public String getRequestReference() {
            return RequestReference;
        }

        public void setRequestReference(String requestReference) {
            RequestReference = requestReference;
        }

        public long getBusinessId() {
            return BusinessId;
        }

        public void setBusinessId(long businessId) {
            BusinessId = businessId;
        }

        public int getItemId() {
            return ItemId;
        }

        public void setItemId(int itemId) {
            ItemId = itemId;
        }

        public String getTransactionReference() {
            return TransactionReference;
        }

        public void setTransactionReference(String transactionReference) {
            TransactionReference = transactionReference;
        }

        public String getTransactionType() {
            return TransactionType;
        }

        public void setTransactionType(String transactionType) {
            TransactionType = transactionType;
        }

        public int getTransactionAmount() {
            return TransactionAmount;
        }

        public void setTransactionAmount(int transactionAmount) {
            TransactionAmount = transactionAmount;
        }

        public LocalDateTime getTransactionDate() {
            return TransactionDate;
        }

        public void setTransactionDate(LocalDateTime transactionDate) {
            TransactionDate = transactionDate;
        }

        public int getQuantity() {
            return Quantity;
        }

        public void setQuantity(int quantity) {
            Quantity = quantity;
        }
    }
}
