package ru.netology.GoodsManager.src.main.java.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.GoodsManager.src.main.java.exception.NotFoundException;
import ru.netology.GoodsManager.src.main.java.manager.Manager;
import ru.netology.GoodsManager.src.main.java.product.Book;
import ru.netology.GoodsManager.src.main.java.product.Product;
import ru.netology.GoodsManager.src.main.java.product.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @Test
    public void addTest() {
        Repository repo = new Repository();

        Book book1 = new Book(1, "Book I", 100, "Author I");
        Book book2 = new Book(2, "Book II", 125, "Author II");
        Book book3 = new Book(3, "Book III", 96, "Author II");
        Smartphone phone = new Smartphone(4,"Iphone 14 Pro",4500,"Apple");

        repo.add(book1);
        repo.add(book3);
        repo.add(phone);

        Product[] expected = {book1, book3, phone};
        Product[] actual = repo.findAll(); ;

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeByIdTest() {
        Repository repo = new Repository();

        Book book1 = new Book(1, "Book I", 100, "Author I");
        Book book2 = new Book(2, "Book II", 125, "Author II");
        Book book3 = new Book(3, "Book III", 96, "Author II");
        Smartphone phone = new Smartphone(4,"Iphone 14 Pro",4500,"Apple");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(phone);

        repo.removeById(2);

        Product[] expected = {book1, book3, phone};
        Product[] actual = repo.findAll(); ;

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void removeByIncorrectId() {
        Repository repo = new Repository();

        Book book1 = new Book(1, "Book I", 100, "Author I");
        Book book2 = new Book(2, "Book II", 125, "Author II");
        Book book3 = new Book(3, "Book III", 96, "Author II");
        Smartphone phone = new Smartphone(4,"Iphone 14 Pro",4500,"Apple");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(phone);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(8));


    }
}