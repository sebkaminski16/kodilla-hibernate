package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave() {

        //arrang
        Product product1 = new Product("computer");
        Product product2 = new Product("phone");

        productDao.save(product1);
        productDao.save(product2);

        Item item1 = new Item(new BigDecimal("1499.99"), 1, new BigDecimal("1"));
        Item item2 = new Item(new BigDecimal("559.99"), 2, new BigDecimal("1"));

        item1.setProduct(product1);
        item1.setProduct(product2);
        item2.setProduct(product2);

        Invoice invoice = new Invoice("4328489233489");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        //act
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //assert
        Assertions.assertNotEquals(0, id);

        //clean
        invoiceDao.deleteById(id);
        productDao.deleteAll();
    }
}
