package io.javabrains.reactiveworkshop;

import java.io.IOException;
import reactor.core.publisher.Flux;

public class Exercise8 {
    
    // Use ReactiveSources.intNumbersFluxWithException()

    // Print values from intNumbersFluxWithException and continue on errors
    // TODO: Write code here
    public void function1() {
        System.out.println("Print values from intNumbersFluxWithException and continue on errors");
        ReactiveSources.intNumbersFluxWithException()
        .doOnError(err -> System.out.println("An error has happended"))
        .subscribe(
            System.out::println,
            err -> System.out.println(err.getMessage())
        );
    }

    // Print values from intNumbersFluxWithException and when errors
    // happen, replace with a fallback sequence of -1 and -2
    // TODO: Write code here
    public void function2() {
        System.out.println("Print values from intNumbersFluxWithException and when errors happen, \n replace with a fallback sequence of -1 and -2");
        ReactiveSources.intNumbersFluxWithException()
        // .onErrorContinue((e, item) -> System.out.println(e.getMessage() + " " + item))
        .onErrorResume(err -> Flux.just(-1, -2))
        .subscribe(
            System.out::println,
            err -> System.out.println(err.getMessage())
        );
    }

    public static void main(String[] args) throws IOException {

        new Exercise8().function1();
        System.out.println("Press a key to end");
        System.in.read();
    }

}
