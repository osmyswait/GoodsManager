package ru.netology.GoodsManager.src.main.java.exception;
public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Element with id= " + id + " not found");
    }
}
