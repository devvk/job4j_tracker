package ru.job4j.bank;

import java.util.Objects;

/**
 * Модель пользователя банка.
 *
 * @author Vitaliy Gold
 * @version 1.0
 */
public class User {

    /**
     * Номер паспорта.
     */
    private String passport;

    /**
     * Имя пользователя.
     */
    private String username;

    /**
     * Конструктор.
     *
     * @param passport номер паспорта
     * @param username имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Возвращает номер паспорта.
     *
     * @return номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Устанавливает номер паспорта.
     *
     * @param passport номер паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Возвращает имя пользователя.
     *
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Устанавливает имя пользователя.
     *
     * @param username имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Проверяет объект на равенство.
     * Пользователя считаются равными, если их
     * номера паспортов совпадают.
     *
     * @param o объект для сравнения
     * @return true, если объекты равны, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Возвращает хэш-код объекта на основе номера паспорта.
     *
     * @return хэш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
