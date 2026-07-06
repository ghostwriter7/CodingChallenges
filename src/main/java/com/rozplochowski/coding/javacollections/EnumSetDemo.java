package com.rozplochowski.coding.javacollections;

import java.util.EnumSet;

public class EnumSetDemo {

    void main() {
        EnumSet<Animal> set = EnumSet.allOf(Animal.class);
        EnumSet.range(Animal.DOG, Animal.WOLF);
        EnumSet.complementOf(EnumSet.of(Animal.DOG, Animal.HORSE));
    }

    enum Animal {BIRD, CAT, DOG, HORSE, WOLF, BEAR}
}
