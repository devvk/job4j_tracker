package ru.job4j.pojo;

public class Shop {

    /**
     * Метод возвращает индекс первой пустой ящейки массива.
     *
     * @param products Массив с объектами типа Product
     * @return Номер первой пустой ячейки, иначе -1
     */
    public static int indexOfNull(Product[] products) {
        int result = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                result = i;
                break;
            }
        }
        return result;
    }
}
