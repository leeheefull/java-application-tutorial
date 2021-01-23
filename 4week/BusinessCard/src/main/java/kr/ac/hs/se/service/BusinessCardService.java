package kr.ac.hs.se.service;

import kr.ac.hs.se.dao.BusinessCardDao;
import kr.ac.hs.se.dto.BusinessCard;

public class BusinessCardService {

    private final BusinessCardDao businessCardDao = new BusinessCardDao();

    public void createBusinessCard(String personName, String phoneNo, String companyName) {
        businessCardDao.insertBusinessCard(personName, phoneNo, companyName);
    }

    public BusinessCard searchBusinessCard(int selectedNo) {
        return businessCardDao.selectBusinessCard(selectedNo);
    }
}
