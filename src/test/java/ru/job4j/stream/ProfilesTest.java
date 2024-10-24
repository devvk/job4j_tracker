package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ProfilesTest {

    @Test
    public void whenTestMethodCollectSortWithoutDuplicate() {
        Address first = new Address("City1", "Street1", 1, 1);
        Address second = new Address("City2", "Street2", 2, 2);
        Address third = new Address("City3", "Street3", 3, 3);
        Address fourth = new Address("City1", "Street1", 1, 1);
        Address fifth = new Address("City2", "Street2", 2, 2);
        Address seventh = new Address("City3", "Street3", 3, 3);
        List<Profile> profiles = List.of(
                new Profile(second),
                new Profile(fourth),
                new Profile(fifth),
                new Profile(first),
                new Profile(seventh),
                new Profile(third)
        );
        List<Address> result = Profiles.collectSortWithoutDuplicate(profiles);
        List<Address> expected = List.of(first, second, third);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenTestMethodCollect() {
        Address first = new Address("City1", "Street1", 1, 1);
        Address second = new Address("City2", "Street2", 2, 2);
        Address third = new Address("City3", "Street3", 3, 3);
        List<Profile> profiles = List.of(
                new Profile(first),
                new Profile(second),
                new Profile(third)
        );
        List<Address> result = Profiles.collect(profiles);
        List<Address> expected = List.of(first, second, third);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenEqualAddressesThenTrue() {
        Address address1 = new Address("CityA", "StreetA", 10, 5);
        Address address2 = new Address("CityA", "StreetA", 10, 5);
        assertEquals(address1, address2);
        assertEquals(address2, address1);
    }

    @Test
    public void whenDifferentAddressesThenFalse() {
        Address address1 = new Address("CityA", "StreetA", 10, 5);
        Address address2 = new Address("CityB", "StreetB", 11, 6);
        assertNotEquals(address1, address2);
        assertNotEquals(address2, address1);
    }
}
