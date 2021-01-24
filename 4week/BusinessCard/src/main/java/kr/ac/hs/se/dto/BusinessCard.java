package kr.ac.hs.se.dto;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusinessCard {

    private int cardNo;
    @NonNull
    private String personName;
    @NonNull
    private String phoneNo;
    @NonNull
    private String companyName;

    private static BusinessCard instance;

    public static BusinessCard getInstance(int cardNo, String personName, String phoneNo, String companyName) {
        if (instance == null) {
            instance = new BusinessCard(cardNo, personName, phoneNo, companyName);
        } else {
            instance.setCardNo(cardNo);
            instance.setPersonName(personName);
            instance.setPhoneNo(phoneNo);
            instance.setCompanyName(companyName);
        }
        return instance;
    }

    @Override
    public String toString() {
        return cardNo + "\t\t" + personName + "\t" + phoneNo + "\t\t" + companyName;
    }
}
