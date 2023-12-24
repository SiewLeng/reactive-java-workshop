package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.time.Duration;

public class Exercise6 {
    
     // Use ReactiveSources.unresponsiveFlux() and ReactiveSources.unresponsiveMono()

    // Get the value from the Mono into a String variable but give up after 5 seconds
    // TODO: Write code here
    public void function1 () {
        System.out.println("Get the value from the Mono into a String variable but give up after 5 seconds");
        try {
            String result = ReactiveSources.unresponsiveMono().block(Duration.ofSeconds(5));
            System.out.println(result);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Get the value from unresponsiveFlux into a String list but give up after 5 seconds
    // Come back and do this when you've learnt about operators!
    // TODO: Write code here
    public void function2() {
    }

    public static void main(String[] args) throws IOException {
        
        new Exercise6().function1();
        System.out.println("Press a key to end");
        System.in.read();
    }

}
