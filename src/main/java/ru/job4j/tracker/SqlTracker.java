package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
    }

    /**
     * Инициализирует соединение с БД.
     */
    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader()
                .getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException("Cannot initialize database connection", e);
        }
    }

    /**
     * Закрывает соединение с БД.
     *
     * @throws SQLException если возникла ошибка при закрытии соединения
     */
    @Override
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    /**
     * Добавляет новый элемент.
     *
     * @param item элемент, который нужно добавить
     * @return добавленный элемент с присвоенным id
     */
    @Override
    public Item add(Item item) {
        String sql = "INSERT INTO items (name, created) VALUES(?, ?)";
        try (PreparedStatement statement =
                     connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add item", e);
        }
        return item;
    }

    /**
     * Заменяет элемент по id на новый.
     *
     * @param id   идентификатор заменяемого элемента
     * @param item новый элемент
     * @return true, если элемент был успешно заменён, иначе false
     */
    @Override
    public boolean replace(int id, Item item) {
        boolean result;
        String sql = "UPDATE items SET name = ?, created = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            result = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to replace item", e);
        }
        return result;
    }

    /**
     * Удаляет элемент по id.
     *
     * @param id идентификатор элемента
     */
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM items WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete item", e);
        }
    }

    /**
     * Возвращает список всех элементов.
     *
     * @return список всех элементов
     */
    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM items";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(createItem(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find all items", e);
        }
        return items;
    }

    /**
     * Находит элементы по имени.
     *
     * @param key имя для поиска
     * @return список найденных элементов
     */
    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM items WHERE name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(createItem(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find items by name", e);
        }
        return items;
    }

    /**
     * Находит элемент по id.
     *
     * @param id идентификатор элемента
     * @return найденный элемент или null, если элемент не найден
     */
    @Override
    public Item findById(int id) {
        Item item = null;
        String sql = "SELECT * FROM items WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    item = createItem(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    /**
     * Создаёт объект Item из результата запроса.
     *
     * @param rs результат SQL-запроса
     * @return объект Item
     * @throws SQLException если возникла ошибка при чтении данных
     */
    private Item createItem(ResultSet rs) throws SQLException {
        return new Item(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getTimestamp("created").toLocalDateTime()
        );
    }
}
