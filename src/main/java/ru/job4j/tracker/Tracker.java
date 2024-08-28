package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    /**
     * Добавление новой заявки.
     */
    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    /**
     * Поиск индекса заявки по id.
     *
     * @param id Id заявки
     * @return index найденной заявки, иначе -1
     */
    private int indexOf(int id) {
        int result = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                result = i;
                break;
            }
        }
        return result;
    }

    /**
     * Поиск заявки по id.
     *
     * @param id Id заявки
     * @return Найденная заявка, иначе null
     */
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    /**
     * Изменение заявки.
     *
     * @param id   Id заявки, которую необходимо заменить
     * @param item Новая заявка
     * @return true, если заменили, иначе false
     */
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items.set(index, item);
        }
        return result;
    }

    /**
     * Удаление заявки.
     *
     * @param id Id заявки, которую необходимо удалить
     * @return true, если удалили, иначе false
     */
    public boolean delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            items.remove(index);
        }
        return result;
    }

    /**
     * Получение списка всех заявок.
     *
     * @return Список заявок
     */
    public List<Item> findAll() {
        return List.copyOf(items);
    }

    /**
     * Получение списка заявок по имени.
     *
     * @param name Имя заявки
     * @return Список заявок, иначе пустой список
     */
    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(name)) {
                result.add(item);
            }
        }
        return result;
    }
}
