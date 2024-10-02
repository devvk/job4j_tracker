package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image1", 100),
                new Attachment("image2", 32),
                new Attachment("image3", 13)
        );
        Comparator<Attachment> comparatorSize = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return Integer.compare(o1.size(), o2.size());
            }
        };
        attachments.sort(comparatorSize);
        System.out.println(attachments);
        Comparator<Attachment> comparatorName = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.name().compareTo(o2.name());
            }
        };
        attachments.sort(comparatorName);
        System.out.println(attachments);
    }
}
