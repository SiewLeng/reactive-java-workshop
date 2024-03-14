package io.javabrains.reactiveworkshop;
import java.io.IOException;

import reactor.core.publisher.Flux;


public class Exercise10 {

    public Flux<User> function1() {
        // error is thrown
        return ReactiveSources.userFlux()
        .map(x -> {
            if (x.getId() > 0) {
                return null;
            }
            return x;
        })
        .onErrorResume(err -> Flux.error(err));
    }

    public static void main(String[] args) throws IOException {
        // the error is handled and not thrown
        new Exercise10().function1()
            .map(x -> new User(x.getId(), x.getFirstName() + " edit", x.getLastName()))
            .onErrorResume(err -> {
                System.out.println("err: " + err);
                return Flux.empty();
            })
            .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
