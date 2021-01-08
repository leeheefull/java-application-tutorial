package kr.ac.hs.se.model;

import java.util.Set;
import java.util.TreeSet;

public class PurchasedLotto implements Lotto {

    private final Set<Integer> basicNumbers;
    private WinningResult winningResult;

    public PurchasedLotto() {
        this.basicNumbers = new TreeSet<>();
        this.setBasicNumbers();
    }

    @Override
    public void clear() {
        basicNumbers.clear();
        this.winningResult = null;
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

    public WinningResult getWinningResult() {
        return winningResult;
    }

    public void setWinningResult(WinningResult winningResult) {
        this.winningResult = winningResult;
    }

    @Override
    public String toString() {
        StringBuilder outputStr = new StringBuilder();
        for (int number : this.basicNumbers) {
            outputStr.append(number).append("\t");
        }
        return outputStr + winningResult.getResult();
    }
}