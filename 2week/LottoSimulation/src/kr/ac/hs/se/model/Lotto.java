package kr.ac.hs.se.model;

import java.util.Set;

public interface Lotto {

    Set<Integer> getBasicNumbers();

    void setBasicNumbers(Set<Integer> basicNumbers);

    void clear();
}
