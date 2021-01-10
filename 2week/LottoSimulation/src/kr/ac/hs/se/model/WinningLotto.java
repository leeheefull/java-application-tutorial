package kr.ac.hs.se.model;

import kr.ac.hs.se.util.RandomGenerator;

import java.util.Set;
import java.util.TreeSet;

public class WinningLotto implements Lotto {

    private Set<Integer> basicNumbers;
    private int bonusNumber;

    public WinningLotto() {
        RandomGenerator randomGenerator = new RandomGenerator();
        this.basicNumbers = new TreeSet<>();
        this.setBasicNumbers(randomGenerator.createRandomNumbers());
        this.setBonusNumber(randomGenerator.createRandomNumber());
    }

    @Override
    public Set<Integer> getBasicNumbers() {
        return this.basicNumbers;
    }

    @Override
    public void setBasicNumbers(Set<Integer> basicNumbers) {
        this.basicNumbers = basicNumbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    @Override
    public void clear() {
        this.basicNumbers.clear();
        this.bonusNumber = 0;
    }

    @Override
    public String toString() {
        StringBuilder outputStr = new StringBuilder();
        for (int number : this.basicNumbers) {
            outputStr.append(number).append("\t");
        }
        return outputStr + "+ " + this.getBonusNumber();
    }
}
