package edu.hw3.Task6;

import java.util.PriorityQueue;
import java.util.Queue;

public class MyStockMarket implements StockMarket {
    private Queue<Stock> stocks = new PriorityQueue<>();

    @Override
    public void add(Stock stock) {
        stocks.offer(stock);
    }

    @Override
    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stocks.peek();
    }

    public Queue<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Queue<Stock> stocks) {
        this.stocks = stocks;
    }
}
