package ru.netology.GoodsManager.src.main.java.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.GoodsManager.src.main.java.product.Book;
import ru.netology.GoodsManager.src.main.java.product.Product;
import ru.netology.GoodsManager.src.main.java.product.Smartphone;
import ru.netology.GoodsManager.src.main.java.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    @Test
    public void searchTestWhenFewProductsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Book I", 100, "Author I");
        Book book2 = new Book(1, "Book II", 125, "Author II");
        Book book3 = new Book(1, "Book III", 96, "Author II");
        Smartphone phone = new Smartphone(4,"Iphone 14 Pro",4500,"Apple");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone);

        Product[] expected = {book1, book2, book3};
        Product[] actual = manager.searchBy("Book");

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void searchTestWhenProductsIsNotFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Book I", 100, "Author I");
        Book book2 = new Book(1, "Book II", 125, "Author II");
        Book book3 = new Book(1, "Book III", 96, "Author II");
        Smartphone phone = new Smartphone(4,"Iphone 14 Pro",4500,"Apple");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Bok");

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void searchTestWhenOneProductsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Book I", 100, "Author I");
        Book book2 = new Book(1, "Book II", 125, "Author II");
        Book book3 = new Book(1, "Book III", 96, "Author II");
        Smartphone phone = new Smartphone(4,"Iphone 14 Pro",4500,"Apple");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone);

        Product[] expected = {phone};
        Product[] actual = manager.searchBy("Pro");

        Assertions.assertArrayEquals(expected, actual);

    }
}