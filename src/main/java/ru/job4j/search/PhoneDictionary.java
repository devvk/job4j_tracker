package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        persons.add(person);
    }

    /**
     * Поиск пользователей, которые содержат key в любых полях.
     *
     * @param key Ключ для поиска.
     * @return Список найденных пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> searchInName = person -> person.getName().contains(key);
        Predicate<Person> searchInSurname = person -> person.getSurname().contains(key);
        Predicate<Person> searchInPhone = person -> person.getPhone().contains(key);
        Predicate<Person> searchInAddress = person -> person.getAddress().contains(key);
        Predicate<Person> combine = searchInName
                .or(searchInSurname)
                .or(searchInPhone)
                .or(searchInAddress);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
