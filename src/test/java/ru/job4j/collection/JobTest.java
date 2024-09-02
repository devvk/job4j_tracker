package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorAscByName() {
        Comparator<Job> cmpAscByName = new JobAscByName();
        int result = cmpAscByName.compare(
                new Job("B", 0),
                new Job("A", 1)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> cmpDescByName = new JobDescByName();
        int result = cmpDescByName.compare(
                new Job("B", 0),
                new Job("A", 1)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorAscByPriority() {
        Comparator<Job> cmpAscByPriority = new JobAscByPriority();
        int result = cmpAscByPriority.compare(
                new Job("A", 0),
                new Job("B", 1)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> cmpDescByPriority = new JobDescByPriority();
        int result = cmpDescByPriority.compare(
                new Job("A", 0),
                new Job("B", 1)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscByNameAndAscByPriority() {
        Comparator<Job> cmpAscByNameAndAscByPriority =
                new JobAscByName().thenComparing(new JobAscByPriority());
        int result = cmpAscByNameAndAscByPriority.compare(
                new Job("A", 0),
                new Job("A", 1)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorAscByNameAndDescByPriority() {
        Comparator<Job> ascByNameAndDescByPriority =
                new JobAscByName().thenComparing(new JobDescByPriority());
        int result = ascByNameAndDescByPriority.compare(
                new Job("A", 0),
                new Job("A", 1)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenComparatorDescByNameAndAscByPriority() {
        Comparator<Job> descByNameAndAscByPriority =
                new JobDescByName().thenComparing(new JobAscByPriority());
        int result = descByNameAndAscByPriority.compare(
                new Job("A", 0),
                new Job("B", 0)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenComparatorDescByNameAndDescByPriority() {
        Comparator<Job> cmpNamePriority =
                new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
}