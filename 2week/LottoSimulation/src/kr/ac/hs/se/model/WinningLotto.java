package kr.ac.hs.se.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningLotto implements Lotto {

	private List<Integer> basicNumbers;
	private int bonusNumber;

	public WinningLotto() {
		this.basicNumbers = new ArrayList<>();
		this.setNumbers();
		this.setBonusNumber();
	}

	@Override
	public List<Integer> getNumbers() {
		return this.basicNumbers;
	}

	@Override
	public void setNumbers() {
		for (int i = 0; i < SIZE; i++) {
			int tmp = (int) (Math.random() * 42) + 1;
			if (!this.basicNumbers.contains(tmp)) {
				this.basicNumbers.add(tmp);
			} else {
				i--;
			}
		}
		Collections.sort(this.basicNumbers);
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
		String outputStr = "";
		for (int number : basicNumbers) {
			outputStr += number + "\t";
		}
		return outputStr + "+ " + bonusNumber + "\n";
	}
}
