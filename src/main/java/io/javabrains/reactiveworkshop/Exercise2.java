package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        // TODO: Write code here
        System.out.println("Print all numbers in the ReactiveSources.intNumbersFlux stream");
        ReactiveSources.intNumbersFlux().doOnNext(System.out::println).subscribe();

        // Print all users in the ReactiveSources.userFlux stream
        // TODO: Write code here
        System.out.println("Print all users in the ReactiveSources.userFlux stream");
        ReactiveSources.userFlux()
        .map(user -> user.toString())
        .doOnNext(System.out::println)
        .subscribe();

        System.out.println("Press a key to end");
        System.in.read();
    }

}
