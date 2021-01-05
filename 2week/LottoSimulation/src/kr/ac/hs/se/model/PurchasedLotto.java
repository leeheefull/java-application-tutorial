package kr.ac.hs.se.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PurchasedLotto implements Lotto {

	private List<Integer> basicNumbers;

	public PurchasedLotto() {
		this.basicNumbers = new ArrayList<>();
		this.setNumbers();
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

	@Override
	public String toString() {
		String outputStr = "";
		for (int number : this.basicNumbers) {
			outputStr += number + "\t";
		}
		return outputStr;
	}
}
