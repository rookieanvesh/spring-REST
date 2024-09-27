package com.anvesh.example;

public record OrderRecord(
        String customerName,
        String productName,
        int quantity
) {
}
