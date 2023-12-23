package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise2 {

    // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

    // Print all numbers in the ReactiveSources.intNumbersFlux stream
    // TODO: Write code here
    public void function1() {
        System.out.println("Print all numbers in the ReactiveSources.intNumbersFlux stream");
        ReactiveSources.intNumbersFlux().subscribe(System.out::println);
    }

    // Print all users in the ReactiveSources.userFlux stream
    // TODO: Write code here
    public void function2() {
        System.out.println("Print all users in the ReactiveSources.userFlux stream");
        ReactiveSources.userFlux()
        .map(user -> user.toString())
        .doOnNext(System.out::println)
        .subscribe();
    }

    public static void main(String[] args) throws IOException {

        new Exercise2().function2();
        System.out.println("Press a key to end");
        System.in.read();
    }

}
