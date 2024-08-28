package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    /**
     * Возвращает имя последнего клиента, которому хватило товара.
     *
     * @return имя последнего клиента, которому хватило товара.
     */
    public String getLastHappyCustomer() {
        Customer customer = null;
        for (int i = 0; i < count; i++) {
            customer = queue.poll();
        }
        return customer != null ? customer.name() : null;
    }

    /**
     * Возвращает имя первого клиента, которому не хватило товара.
     *
     * @return имя первого клиента, которому не хватило товара.
     */
    public String getFirstUpsetCustomer() {
        Customer customer = null;
        for (int i = 0; i <= count; i++) {
            customer = queue.poll();
        }
        return customer != null ? customer.name() : null;
    }
}
