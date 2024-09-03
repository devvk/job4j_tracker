package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Сервис банка, который управляет пользователями и их счетами.
 * Позволяет добавлять и удалять пользователей, добавлять счета,
 * находить пользователей и счета,а также осуществлять переводы
 * между счетами.
 *
 * @author Vitaliy Gold
 * @version 1.0
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавить пользователя в систему.
     *
     * @param user Пользователь.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удалить пользователя из системы.
     *
     * @param passport Паспорт пользователя.
     * @return true, если пользователь был успешно удалён,
     * false, если пользователь не найден.
     */
    public boolean deleteUser(String passport) {
        return users.remove((new User(passport, ""))) != null;
    }

    /**
     * Добавить пользователю новый счёт.
     *
     * @param passport Номер паспорта.
     * @param account  Счёт.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
                users.put(user, accounts);
            }
        }
    }

    /**
     * Найти пользователя по номеру паспорта.
     *
     * @param passport Номер паспорта.
     * @return Пользователь.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Найти счёт пользователя по реквизитам.
     *
     * @param passport  Номер паспорта.
     * @param requisite Реквизиты.
     * @return Счёт пользователя, если найден, иначе null.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (accounts != null) {
                for (Account account : accounts) {
                    if (account.getRequisite().equals(requisite)) {
                        return account;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Перевести деньги с одного счёта на другой.
     *
     * @param sourcePassport       Паспорт отправителя.
     * @param sourceRequisite      Реквизиты отправителя.
     * @param destinationPassport  Паспорт получателя.
     * @param destinationRequisite Реквизиты получателя.
     * @param amount               Сумма перевода.
     * @return true, если перевод завершён, иначе false.
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null && destinationAccount != null
                && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Получить список счетов пользователя.
     *
     * @param user Пользователь.
     * @return Список счетов.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
