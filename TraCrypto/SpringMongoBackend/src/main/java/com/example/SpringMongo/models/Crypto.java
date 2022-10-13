package com.example.SpringMongo.models;


public class Crypto {

    private final int rank;
    private final String name;

    private final String ticker;
    private final String price;

    public Crypto(int rank, String name, String ticker, String price) {
        this.rank = rank;
        this.name = name;
        this.ticker = ticker;
        this.price = price;
    }

    public int getRank(){
        return rank;
    }

    public String getName() {
        return name;
    }

    public String getTicker() {
        return ticker;
    }

    public String getPrice() {
        return price;
    }
}
