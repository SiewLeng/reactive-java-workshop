package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise5 {

    // Use ReactiveSources.intNumberFlux() and ReactiveSources.userMono()

    // Subscribe to a flux using the error and completion hooks
    // TODO: Write code here
    public void function1() {
        ReactiveSources.intNumbersFlux()
        .subscribe(
            x -> System.out.println(x),
            err -> System.out.println(err.getMessage()),
            () -> System.out.println("Complete")
        );
    }
    
    // Subscribe to a flux using an implementation of BaseSubscriber
    // TODO: Write code here
    public void function2() {
        ReactiveSources.userFlux()
        .subscribe(new MySubscriber<>());
    }

    public static void main(String[] args) throws IOException {

        new Exercise5().function2();

        System.out.println("Press a key to end");
        System.in.read();
    }

}