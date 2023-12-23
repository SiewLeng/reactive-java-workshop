package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise4 {
    // Use ReactiveSources.intNumberMono()

    // Print the value from intNumberMono when it emits
    // TODO: Write code here
    public void function1 () {
        System.out.println("Print the value from intNumberMono when it emits");
        ReactiveSources.intNumberMono()
        .subscribe(System.out::println);
    }
    
    
    // Get the value from the Mono into an integer variable
    // TODO: Write code here
    public void function2 () {
        System.out.println("Get the value from the Mono into an integer variable");
        Integer num = ReactiveSources.intNumberMono().block();
        System.out.println(num);
    }

    public static void main(String[] args) throws IOException {

        new Exercise4().function2();
        System.out.println("Press a key to end");
        System.in.read();
    }

}
