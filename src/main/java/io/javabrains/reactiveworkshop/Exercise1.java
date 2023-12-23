package io.javabrains.reactiveworkshop;

import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        System.out.println("Print all numbers in the intNumbersStream stream");
        Stream<Integer> nums1 = StreamSources.intNumbersStream();
        nums1.forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        System.out.println("\nPrint numbers from intNumbersStream that are less than 5");
        Stream<Integer> nums2 = StreamSources.intNumbersStream();
        nums2.filter(x -> x < 5).forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        System.out.println("\nPrint the second and third numbers in intNumbersStream that's greater than 5");
        Stream<Integer> nums3 = StreamSources.intNumbersStream();
        nums3.filter(x -> x > 5).limit(3).skip(1).forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        System.out.println("\nPrint the first number in intNumbersStream that's greater than 5");
        Stream<Integer> nums4 = StreamSources.intNumbersStream();
        System.out.println(nums4.filter(x -> x > 5).findFirst().orElse(-1));

        // Print first names of all users in userStream
        // TODO: Write code here
        System.out.println("\nPrint first names of all users in userStream");
        Stream<User> users1 = StreamSources.userStream();
        users1.forEach(x -> System.out.println(x.getFirstName()));

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        System.out.println("\nPrint first names in userStream for users that have IDs from number stream");
        StreamSources.userStream()
        .filter(user -> StreamSources.intNumbersStream().anyMatch(x -> x == user.getId()))
        .forEach(user -> System.out.println(user.getFirstName()));

        System.out.println("\nPrint first names in userStream for users that have IDs from number stream");
        StreamSources.intNumbersStream()
        .flatMap(num -> StreamSources.userStream().filter(user -> num == user.getId()))
        .forEach(user -> System.out.println(user.getFirstName()));
    }

}
