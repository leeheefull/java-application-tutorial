package kr.ac.hs.se.model;

import java.util.List;

public interface Lotto {

	public static final int SIZE = 6;
	public List<Integer> getNumbers();
	public void setNumbers();
}
