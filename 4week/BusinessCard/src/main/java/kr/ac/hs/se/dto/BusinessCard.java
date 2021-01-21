package kr.ac.hs.se.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "cardNo")
public class BusinessCard {

    private int cardNo;
    private String name;
    private String phoneNo;
    private String companyName;
}
