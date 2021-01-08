package kr.ac.hs.se.model;

import java.util.Set;
import java.util.TreeSet;

public class WinningLotto implements Lotto {

    private final Set<Integer> basicNumbers;
    private int bonusNumber;

    public WinningLotto() {
        this.basicNumbers = new TreeSet<>();
        this.setBasicNumbers();
        this.setBonusNumber();
    }

    @Override
    public void clear() {
        this.basicNumbers.clear();
        this.bonusNumber = 0;
    }

    @Override
    public Set<Integer> getBasicNumbers() {
        return this.basicNumbers;
    }

    @Override
    public void setBasicNumbers() {
        while (this.basicNumbers.size() < SIZE) {
            int tmp = (int) (Math.random() * 42) + 1;
            this.basicNumbers.add(tmp);
        }
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public void setBonusNumber() {
        int tmp = (int) (Math.random() * 42) + 1;
        while (this.basicNumbers.contains(tmp)) {
            tmp = (int) (Math.random() * 42) + 1;
        }
        this.bonusNumber = tmp;
    }

    @Override
    public String toString() {
        StringBuilder outputStr = new StringBuilder();
        for (int number : basicNumbers) {
            outputStr.append(number).append("\t");
        }
        return outputStr + "+ " + this.bonusNumber;
    }
}
