package com.kodilla.hibernate;

import com.kodilla.hibernate.invoice.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;

import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class KodillaHibernateApplication {
    public static void main(String[] args) {
       SpringApplication.run(KodillaHibernateApplication.class, args);
    }
}
