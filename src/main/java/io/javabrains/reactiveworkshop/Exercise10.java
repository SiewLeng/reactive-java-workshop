package io.javabrains.reactiveworkshop;
import java.io.IOException;

import reactor.core.publisher.Flux;

public class Exercise10 {

    public Flux<Object> function1() {
        // error is thrown
        return ReactiveSources.intNumbersFluxWithException().map(x -> null).onErrorResume(err -> Flux.error(err));
    }

    public static void main(String[] args) throws IOException {
        // the error is handled and not thrown
        new Exercise10().function1().onErrorResume(err -> Flux.just(-1, -2)).subscribe(System.out::println);
        System.out.println("Press a key to end");
        System.in.read();
    }

}
