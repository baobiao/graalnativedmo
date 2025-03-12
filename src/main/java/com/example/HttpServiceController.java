package com.example;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpServiceController {
    
    private static Logger LOGGER = LoggerFactory.getLogger(HttpServiceController.class);

    /**
     * Checks if the input string is a Prime Number using the Java native isProbablePrime
     * that checks the chances of a number is a prime in a fictional inefficient way.
     * @param inputStr
     * @return True if the input is a prime number, false otherwise.
     */
    @GetMapping("/{input}")
    public String checkIfPrime5000(@PathVariable("input") String inputStr) {
        long time = System.currentTimeMillis();
        LOGGER.info("checkIfPrime5000("+inputStr+") - Start");
        BigInteger input = new BigInteger(inputStr);
        boolean ans = input.isProbablePrime(100);
        for(int i=0; i<5000; i++) { // Silly 5000 iterations.
            ans = input.isProbablePrime(100);
        }
        LOGGER.info("checkIfPrime5000("+inputStr+") - End - Elapsed["+(System.currentTimeMillis() - time)+"]");
        return String.valueOf(ans);
    }
}
