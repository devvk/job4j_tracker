package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    /**
     * Добавление новой заявки.
     */
    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
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
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
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
        return index != -1 ? items[index] : null;
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
            items[index] = item;
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
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
        }
        return result;
    }

    /**
     * Получение списка всех заявок.
     *
     * @return Массив заявок
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    /**
     * Получение списка заявок по имени.
     *
     * @param name Имя заявки
     * @return Массив заявок, иначе массив нулевой длины
     */
    public Item[] findByName(String name) {
        Item[] result = new Item[size];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item.getName().equals(name)) {
                result[counter++] = item;
            }
        }
        return Arrays.copyOf(result, counter);
    }
}
