package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HibernateRun {

    public static void main(String[] args) {

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory()) {
            var item = new Item();
            item.setName("Learn Hibernate");

            create(item, sessionFactory);
            System.out.println("created: " + item);

            item.setName("Learn Hibernate 5.");
            update(item, sessionFactory);
            System.out.println("updated: " + item);

            Item foundItem = findById(item.getId(), sessionFactory);
            System.out.println("found: " + foundItem);

            delete(foundItem.getId(), sessionFactory);

            List<Item> items = getAll(sessionFactory);
            for (Item itemElement : items) {
                System.out.println(itemElement);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static Item create(Item item, SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        }
        return item;
    }

    public static void update(Item item, SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(item);
            session.getTransaction().commit();
        }
    }

    public static void delete(Integer id, SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Item item = new Item();
            item.setId(id);
            session.delete(item);
            session.getTransaction().commit();
        }
    }

    public static List<Item> getAll(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Item> result = session.createQuery("FROM Item", Item.class).list();
            session.getTransaction().commit();
            return result;
        }
    }

    public static Item findById(Integer id, SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Item item = session.get(Item.class, id);
            session.getTransaction().commit();
            return item;
        }
    }
}
