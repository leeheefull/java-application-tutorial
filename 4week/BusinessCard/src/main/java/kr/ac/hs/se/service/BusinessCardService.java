package kr.ac.hs.se.service;

import kr.ac.hs.se.dao.BusinessCardDao;
import kr.ac.hs.se.dto.BusinessCard;

public class BusinessCardService {

    private final BusinessCardDao businessCardDao = new BusinessCardDao();

    public void createBusinessCard(String name, String phoneNo, String companyName) {
        businessCardDao.insertBusinessCard(new BusinessCard(name, phoneNo, companyName));
    }

    public BusinessCard searchBusinessCard(String selectedName) {
        return businessCardDao.selectBusinessCard(selectedName);
    }
}
