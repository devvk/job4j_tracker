package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;

public class Profiles {

    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::address)
                .sorted(Comparator.comparing(Address::city))
                .distinct()
                .toList();
    }

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::address)
                .toList();
    }
}