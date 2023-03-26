package com.team.strategy;

import java.util.Arrays;

/**
 * design-patterns
 *
 * @author zhangbc
 * @version v1.0.0
 * @date 9/18/22 1:35 AM
 **/
public class Main {
    public static void main(String[] args) {
        // int[] array = {9, 2, 3, 5, 7, 1, 4};
        // Sorter.sort(array);
        // System.out.println(Arrays.toString(array));

        Cat[] cats = {new Cat(3, 3),
                new Cat(5, 5),
                new Cat(1, 1)};
        // Sorter.sort(cats);
        CatWeightComparator weightComparator = new CatWeightComparator();
        Sorter<Cat> catSorter = new Sorter<>();
        catSorter.sort(cats, weightComparator);
        System.out.println(Arrays.toString(cats));

        CatHeightComparator heightComparator = new CatHeightComparator();
        catSorter.sort(cats, heightComparator);
        System.out.println(Arrays.toString(cats));

        Dog[] dogs = {new Dog(1),
                new Dog(5),
                new Dog(3)};
        // Sorter.sort(dogs);
        DogComparator dogComparator = new DogComparator();
        Sorter<Dog> dogSorter = new Sorter<>();
        dogSorter.sort(dogs, dogComparator);
        System.out.println(Arrays.toString(dogs));
    }
}
