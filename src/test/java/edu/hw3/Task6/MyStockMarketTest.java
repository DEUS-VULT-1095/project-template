package edu.hw3.Task6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class MyStockMarketTest {
    private MyStockMarket myStockMarket = new MyStockMarket();
    private Stock stock1;
    private Stock stock2;
    private Stock stock3;

    @BeforeEach
    void beforeEach() {
        Queue<Stock> stocks = new PriorityQueue<>();
        stock1 = new Stock("company1", 12.22d);
        stock2 = new Stock("company2", 14.22d);
        stock3 = new Stock("company3", 16.22d);
        stocks.offer(stock1);
        stocks.offer(stock2);
        stocks.offer(stock3);
        myStockMarket.setStocks(stocks);
    }

    @Test
    void testAdd_whenProvidedStock() {
        // Arrange
        Stock stock = new Stock("company4", 10.0d);
        int expectedSize = 4;

        // Act
        myStockMarket.add(stock);

        // Assert
        assertEquals(expectedSize, myStockMarket.getStocks().size(), "Incorrect size PriorityQueue");
    }

    @Test
    void remove() {
        // Arrange
        int expectedSize = 2;

        // Act
        myStockMarket.remove(stock1);

        // Assert
        assertEquals(expectedSize, myStockMarket.getStocks().size(), "Incorrect size PriorityQueue");
    }

    @Test
    void mostValuableStock() {
        // Arrange

        // Act
        Stock actualStock = myStockMarket.mostValuableStock();

        // Assert
        assertEquals(stock3, actualStock, "Return not most valuable stock");
    }
}
