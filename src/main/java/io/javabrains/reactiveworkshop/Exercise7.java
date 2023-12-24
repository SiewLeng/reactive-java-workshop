package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise7 {

    // Print all values from intNumbersFlux that's greater than 5
    // TODO: Write code here
    public void function1() {
        System.out.println("Print all values from intNumbersFlux that's greater than 5");
        ReactiveSources.intNumbersFlux()
        .filter(x -> x > 5)
        .subscribe(
            System.out::println,
            err -> System.out.println(err.getMessage()),
            () -> System.out.println("Complete")
        );
    }

    // Print 10 times each value from intNumbersFlux that's greater than 5
    // TODO: Write code here
    public void function2() {
        System.out.println("Print 10 times each value from intNumbersFlux that's greater than 5");
        ReactiveSources.intNumbersFlux()
        .filter(x -> x > 5)
        .map(x -> x * 10)
        .subscribe(
            System.out::println,
            err -> System.out.println(err.getMessage()),
            () -> System.out.println("Complete")
        );
    }

    // Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
    // TODO: Write code here
    public void function3() {
        System.out.println("Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5");
        ReactiveSources.intNumbersFlux()
        .filter(x -> x > 5)
        .take(3)
        .map(x -> x * 10)
        .subscribe(
            System.out::println,
            err -> System.out.println(err.getMessage()),
            () -> System.out.println("Complete")
        );
    }

    // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
    // TODO: Write code here
    public void function4() {
        System.out.println("Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found");
        ReactiveSources.intNumbersFlux()
        .filter(x -> x > 20)
        .defaultIfEmpty(-1)
        .subscribe(
            System.out::println,
            err -> System.out.println(err.getMessage()),
            () -> System.out.println("Complete")
        );
    }

    // Switch ints from intNumbersFlux to the right user from userFlux
    // TODO: Write code here
    public void function5() {
        System.out.println("Switch ints from intNumbersFlux to the right user from userFlux");
        ReactiveSources.intNumbersFlux()
        .flatMap(x -> ReactiveSources.userFlux().filter(user -> user.getId() == x))
        .subscribe(
            System.out::println,
            err -> System.out.println(err.getMessage()),
            () -> System.out.println("Complete")
        );
    }

    // Print only distinct numbers from intNumbersFluxWithRepeat
    // TODO: Write code here
    public void function6() {
        System.out.println("Print only distinct numbers from intNumbersFluxWithRepeat");
        ReactiveSources.intNumbersFluxWithRepeat()
        .distinct()
        .subscribe(
            System.out::println,
            err -> System.out.println(err.getMessage()),
            () -> System.out.println("Complete")
        );
    }

    // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
    // TODO: Write code here
     public void function7() {
        System.out.println("Print from intNumbersFluxWithRepeat excluding immediately repeating numbers");
        ReactiveSources.intNumbersFluxWithRepeat()
        .distinctUntilChanged()
        .subscribe(
            System.out::println,
            err -> System.out.println(err.getMessage()),
            () -> System.out.println("Complete")
        );
    }

    public static void main(String[] args) throws IOException {

       new Exercise7().function7();
        System.out.println("Press a key to end");
        System.in.read();
    }

}
