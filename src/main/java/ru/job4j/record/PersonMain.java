package ru.job4j.record;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person("Alex", 33);
        System.out.println("Name: " + person.getName() + ", age: " + person.getAge());
        System.out.println(person);

        PersonRecord record1 = new PersonRecord("Ivan", 34);
        System.out.println("Name: " + record1.name() + ", age: " + record1.age());
        System.out.println(record1);
        PersonRecord record2 = new PersonRecord(record1.name(), record1.age());
        System.out.println(record1.equals(record2));
    }
}
