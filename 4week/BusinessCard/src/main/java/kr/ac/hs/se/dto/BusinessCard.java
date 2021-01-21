package kr.ac.hs.se.dto;

import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
public class BusinessCard {

    private int cardNo;
    @NonNull
    private String name;
    @NonNull
    private String phoneNo;
    @NonNull
    private String companyName;

    @Override
    public String toString() {
        return name + "\t" + phoneNo + "\t\t" + companyName;
    }
}
