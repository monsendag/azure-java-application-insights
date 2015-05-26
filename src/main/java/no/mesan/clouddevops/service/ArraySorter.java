package no.mesan.clouddevops.service;

public class ArraySorter {

    public static void Sort(int[] array) {

        int value, index;

        for (int i = 0; i < array.length; i++) {

            value = array[i];
            index = i;

            while (index > 0 && array[index - 1] < value) {
                array[index] = array[index - 1];
                index --;
            }
            array[index] = value;
        }
    }
}
