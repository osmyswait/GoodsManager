package ru.netology.GoodsManager.src.main.java.repository;

import ru.netology.GoodsManager.src.main.java.exception.NotFoundException;
import ru.netology.GoodsManager.src.main.java.product.Product;

public class Repository {
    private Product[] products = new Product[0];

    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public void removeById(int idRemove) {
        if(findById(idRemove) == null) {
            throw new NotFoundException(idRemove);
        }


        Product[] tmp = new Product[products.length - 1];
        int indexToCopy = 0;
        for (Product product : products) {
            if (product.getId() != idRemove) {
                tmp[indexToCopy] = product;
                indexToCopy++;
            }
        }
        products = tmp;
    }
    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
