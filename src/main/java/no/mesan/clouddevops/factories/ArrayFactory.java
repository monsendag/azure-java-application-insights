package no.mesan.clouddevops.factories;

import java.util.Random;

public class ArrayFactory {

    public static int[] Create(final int size, final int seed) {
        Random r = new Random(seed);

        int array[] = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt();
        }

        return array;
    }
}
