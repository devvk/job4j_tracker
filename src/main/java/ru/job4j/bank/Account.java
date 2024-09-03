package ru.job4j.bank;

import java.util.Objects;

/**
 * Модель банковского счета.
 *
 * @author Vitaliy Gold
 * @version 1.0
 */
public class Account {

    /**
     * Реквизиты счёта.
     */
    private String requisite;

    /**
     * Баланс счёта.
     */
    private double balance;

    /**
     * Конструктор для создания счёта с заданными реквизитами и балансом.
     *
     * @param requisite Реквизиты счёта.
     * @param balance   Баланс счёта.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Возвращает реквизиты счёта.
     *
     * @return Реквизиты счёта.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Устанавливает реквизиты счёта.
     *
     * @param requisite Новые реквизиты счёта.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Возвращает баланс счёта.
     *
     * @return Баланс счёта.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Устанавливает баланс счёта.
     *
     * @param balance Новый баланс счёта.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Проверяет объекты на равенство.
     * Счета считаются равными, если их реквизиты совпадают.
     *
     * @param o Объект для сравнения с данным счётом.
     * @return true, если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Возвращает хэш-код объекта на основе реквизитов счёта.
     *
     * @return Хэш-код объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
