package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private final Map<String, Citizen> citizens = new HashMap<>();

    /**
     * Метод добавляет пользователей в Map.
     *
     * @param citizen Пользователь, которого необходимо добавить.
     * @return true, если пользователя еще нет в HashMap или false если есть.
     */
    public boolean add(Citizen citizen) {
        boolean result = false;
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            result = true;
        }
        return result;
    }

    /**
     * Метод возвращает пользователя по номеру паспорта.
     *
     * @param passport Номер паспорта пользователя.
     * @return Пользователь с указанным номером паспорта, либо null, если не найден.
     */
    public Citizen get(String passport) {
        return citizens.get(passport);
    }
}
