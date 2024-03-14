package io.javabrains.reactiveworkshop;
import java.io.IOException;

import reactor.core.publisher.Flux;


public class Exercise10 {

    public Flux<User> getUser() {
        // error is thrown
        return ReactiveSources.userFlux()
        .map(x -> {
            if (x.getId() > 2) {
                return null;
            }
            return x;
        })
        .onErrorResume(err -> Flux.error(err));
    }

    public void function1() {
        // the error is handled and not thrown
        this.getUser()
        .map(x -> new User(x.getId(), x.getFirstName() + " edit", x.getLastName()))
        .onErrorResume(err -> {
            System.out.println("err: " + err);
            return Flux.empty();
        })
        .subscribe(System.out::println);
    }

    public void function2() {
        // the error thrown is not caught in the Catch block;
        try {
            this.getUser()
            .map(x -> new User(x.getId(), x.getFirstName() + " edit", x.getLastName()))
            .subscribe(System.out::println);
        } catch (Exception e) {
            System.out.println("An exception error occurs!");
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) throws IOException {
      
        new Exercise10().function2();
        System.out.println("Press a key to end");
        System.in.read();
    
    }

}
