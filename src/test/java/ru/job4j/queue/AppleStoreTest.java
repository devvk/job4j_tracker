package ru.job4j.queue;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class AppleStoreTest {
    @Test
    void whenGetLastHappy() {
        Queue<Customer> customers = new LinkedList<>();
        customers.add(new Customer("Petr", 1000));
        customers.add(new Customer("Stas", 1500));
        customers.add(new Customer("Andrey", 850));
        customers.add(new Customer("Alexei", 900));
        customers.add(new Customer("Iryna", 1250));
        customers.add(new Customer("Elena", 750));
        customers.add(new Customer("Rail", 950));
        int count = 4;
        AppleStore appleStore = new AppleStore(customers, count);
        String customer = appleStore.getLastHappyCustomer();
        assertThat(customer).isEqualTo("Alexei");
    }

    @Test
    void whenGetLastHappyIsNull() {
        Queue<Customer> customers = new LinkedList<>();
        customers.add(new Customer("Petr", 1000));
        customers.add(new Customer("Stas", 1500));
        int count = 3;
        AppleStore appleStore = new AppleStore(customers, count);
        String customer = appleStore.getLastHappyCustomer();
        assertThat(customer).isNull();
    }

    @Test
    void whenGetFirstUpset() {
        Queue<Customer> customers = new LinkedList<>();
        customers.add(new Customer("Petr", 1000));
        customers.add(new Customer("Stas", 1500));
        customers.add(new Customer("Andrey", 850));
        customers.add(new Customer("Alexei", 900));
        customers.add(new Customer("Iryna", 1250));
        customers.add(new Customer("Elena", 750));
        customers.add(new Customer("Rail", 950));
        int count = 4;
        AppleStore appleStore = new AppleStore(customers, count);
        String customer = appleStore.getFirstUpsetCustomer();
        assertThat(customer).isEqualTo("Iryna");
    }

    @Test
    void whenGetFirstUpsetIsNull() {
        Queue<Customer> customers = new LinkedList<>();
        int count = 10;
        AppleStore appleStore = new AppleStore(customers, count);
        String customer = appleStore.getFirstUpsetCustomer();
        assertThat(customer).isNull();
    }
}
