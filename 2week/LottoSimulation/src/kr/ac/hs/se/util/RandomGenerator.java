package kr.ac.hs.se.util;

import java.util.Set;
import java.util.TreeSet;

public class RandomGenerator {

    private final Set<Integer> randomNumbers;

    public RandomGenerator() {
        randomNumbers = new TreeSet<>();
    }

    public Set<Integer> createRandomNumbers() {
        while (randomNumbers.size() < 6) {
            int tmp = (int) (Math.random() * 42) + 1;
            randomNumbers.add(tmp);
        }
        return randomNumbers;
    }

    public int createRandomNumber() {
        int tmp = (int) (Math.random() * 42) + 1;
        while (randomNumbers.contains(tmp)) {
            tmp = (int) (Math.random() * 42) + 1;
        }
        return tmp;
    }
}