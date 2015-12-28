package ru.samples.itis.rxpractice.tasks;

import android.support.annotation.NonNull;

import java.math.BigInteger;

import rx.Observable;

/**
 * @author Artur Vasilov
 */
public class RxJavaTask2 {

    /**
     * TODO : implement this method
     *
     * Take the range of integers [1..100000] and apply next functions:
     * 1) Multiply all elements by 2
     * 2) Remove 40 000 elements from start and 40 000 elements from end
     * 3) Remove all values which is not divided by 3
     * 4) Transform the left sequence of integers into sequence of BigInteger objects
     * 5) Multiply all values into single BigInteger object
     * 6) Cache the result
     *
     * @return observable with cached result of single BigInteger object
     */
    @NonNull
    public static Observable<BigInteger> task2Observable() {
        return Observable.range(1, 100000)
                .map(integer -> integer*2)
                .skip(40000)
                .skipLast(40000)
                .filter(integer1 -> integer1%3 == 0)
                .map(integer2 -> String.valueOf(integer2))
                .map(s -> new BigInteger(s))
                .reduce((bigInteger, bigInteger2) -> bigInteger.multiply(bigInteger2));
    }

}