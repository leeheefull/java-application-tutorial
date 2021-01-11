package kr.ac.hs.se.model;

import kr.ac.hs.se.util.RandomGenerator;

import java.util.Set;
import java.util.TreeSet;

public class PurchasedLotto implements Lotto {

    private Set<Integer> basicNumbers;
    private WinningRank winningRank;

    public PurchasedLotto() {
        this.basicNumbers = new TreeSet<>();
        this.setBasicNumbers(new RandomGenerator().createRandomNumbers());
    }

    @Override
    public Set<Integer> getBasicNumbers() {
        return this.basicNumbers;
    }

    @Override
    public void setBasicNumbers(Set<Integer> basicNumbers) {
        this.basicNumbers = basicNumbers;
    }

    public WinningRank getWinningRank() {
        return this.winningRank;
    }

    public void setWinningRank(WinningRank winningResult) {
        this.winningRank = winningResult;
    }

    @Override
    public void clear() {
        this.basicNumbers.clear();
        this.winningRank = null;
    }

    @Override
    public String toString() {
        StringBuilder outputStr = new StringBuilder();
        for (int number : this.basicNumbers) {
            outputStr.append(number).append("\t");
        }
        return outputStr + this.winningRank.getRank();
    }
}