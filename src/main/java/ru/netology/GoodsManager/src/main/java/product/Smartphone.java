package ru.netology.GoodsManager.src.main.java.product;

public class Smartphone extends Product {
    private String maker;

    public Smartphone(int id, String name, int price, String maker) {
        super(id, name, price);
        this.maker = maker;
    }

    public String getMaker() {
        return maker;
    }
}
