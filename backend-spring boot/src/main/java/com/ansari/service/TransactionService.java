package com.ansari.service;

import com.ansari.model.Order;
import com.ansari.model.Seller;
import com.ansari.model.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction createTransaction(Order order);
    List<Transaction> getTransactionBySeller(Seller seller);
    List<Transaction>getAllTransactions();
}
