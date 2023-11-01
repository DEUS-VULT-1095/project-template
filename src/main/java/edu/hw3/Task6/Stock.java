package edu.hw3.Task6;

import org.jetbrains.annotations.NotNull;

public class Stock implements Comparable<Stock> {
    private String company;
    private double price;

    public Stock(String company, double price) {
        this.company = company;
        this.price = price;
    }

    @Override
    public int compareTo(@NotNull Stock o) {
        return Double.compare(o.price, this.price);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @SuppressWarnings("OperatorWrap")
    @Override public String toString() {
        return "Stock{" +
            "company='" + company + '\'' +
            ", price=" + price +
            '}';
    }
}
