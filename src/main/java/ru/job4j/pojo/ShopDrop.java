package ru.job4j.pojo;

public class ShopDrop {

    /**
     * Метод принимает индекс ячейки, которую необходимо удалить и все ячейки,
     * стоящие справа от удаляемой перемещает на одну ячейку влево.
     *
     * @param products Массив объектов типа Product
     * @param index    Индекс ячейки, которую нам необходимо удалить
     * @return Массив объектов типа Product
     */
    public static Product[] delete(Product[] products, int index) {
        for (int i = index; i < products.length - 1; i++) {
            products[i] = products[i + 1];
        }
        products[products.length - 1] = null;
        return products;
    }
}
