package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

public class MySubscriber<T> extends BaseSubscriber<T> {
    
     public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Start subscription");
        request(1);
    }

    public void hookOnNext(T value) {
        System.out.println(value.toString() + "receieved");
        request(1);
    }

    public void hookOnComplete() {
        System.out.println("Completed");
    }
}
