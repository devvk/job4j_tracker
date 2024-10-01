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
        Comparator<Attachment> sizeComparator = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return Integer.compare(o1.getSize(), o2.getSize());
            }
        };
        attachments.sort(sizeComparator);
        System.out.println(attachments);
        Comparator<Attachment> nameComparator = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        attachments.sort(nameComparator);
        System.out.println(attachments);
    }
}
