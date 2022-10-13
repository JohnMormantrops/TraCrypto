package com.example.SpringMongo.models;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class myCrypto {
    private final String crypto;

    private Double amount;


    @Override
    public String toString() {
        return "{" +
                "name='" + crypto + '\'' +
                ", amount=" + amount +
                '}';
    }
}
