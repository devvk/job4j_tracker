package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.query.Query;

public class HQLUsage {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            int itemId = 6;

            Query<Item> query = session.createQuery("FROM Item WHERE id = :id", Item.class);
            query.setParameter("id", itemId);
            System.out.println(query.getSingleResult());

            update(session, itemId);
            System.out.println(session.createQuery("FROM Item WHERE id = :id", Item.class)
                    .setParameter("id", itemId)
                    .getSingleResult());

            delete(session, itemId);
            System.out.println(session.createQuery("FROM Item WHERE id = :id", Item.class)
                    .setParameter("id", itemId)
                    .getSingleResult());

            Item item = new Item("Inserted item");
            insert(session, item);
            System.out.println(session.createQuery("FROM Item WHERE id = :id", Item.class)
                    .setParameter("id", itemId)
                    .getSingleResult());

            session.close();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static void update(Session session, int id) {
        try {
            session.beginTransaction();
            session.createQuery("UPDATE Item SET name = :name WHERE id = :id")
                    .setParameter("name", "New item")
                    .setParameter("id", 6)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public static void delete(Session session, int id) {
        try {
            session.beginTransaction();
            session.createQuery("DELETE FROM Item WHERE id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public static void insert(Session session, Item item) {
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
}
