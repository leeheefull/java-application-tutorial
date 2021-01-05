package kr.ac.hs.se.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

	private boolean isRaffle;
	private List<Integer> basicNumbers;
	private int bonusNumber;

	public Lotto() {
	}

	public Lotto(boolean isRaffle) {
		this.basicNumbers = new ArrayList<>(6);
		this.isRaffle = isRaffle;
		setNumbers();
		if (this.isRaffle) {
			setBonusNumber();
		}
	}

	public boolean isRaffle() {
		return isRaffle;
	}

	public void setRaffle(boolean isRaffle) {
		this.isRaffle = isRaffle;
	}

	public List<Integer> getNumbers() {
		return basicNumbers;
	}

	public void setNumbers() {
		for (int i = 0; i < 6; i++) {
			int tmp = (int) (Math.random() * 42) + 1;
			if (!basicNumbers.contains(tmp)) {
				this.basicNumbers.add(tmp);
			} else {
				i--;
			}
		}
		Collections.sort(basicNumbers);
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	public void setBonusNumber() {
		int tmp = (int) (Math.random() * 42) + 1;
		while (basicNumbers.contains(tmp)) {
			tmp = (int) (Math.random() * 42) + 1;
		}
		this.bonusNumber = tmp;
	}

	@Override
	public String toString() {
		String outputStr = "";
		for (int number : basicNumbers) {
			outputStr += number + " ";
		}
		if (this.isRaffle) {
			outputStr += "+ " + bonusNumber;
		}
		return outputStr;
	}
}
