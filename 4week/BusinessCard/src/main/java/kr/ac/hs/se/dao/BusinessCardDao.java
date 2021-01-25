package kr.ac.hs.se.dao;

import kr.ac.hs.se.dto.BusinessCard;
import kr.ac.hs.se.util.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessCardDao {

    private static BusinessCardDao businessCardDao;

    public static BusinessCardDao getInstance() {
        if (businessCardDao == null) {
            businessCardDao = new BusinessCardDao();
        }
        return businessCardDao;
    }

    public void insertBusinessCard(String personName, String phoneNo, String companyName) {
        String sql = "INSERT INTO business_card(person_name, phone_no, company_name) VALUES(?, ?, ?)";

        try (
                Connection con = DBConnector.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, personName);
            ps.setString(2, phoneNo);
            ps.setString(3, companyName);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public BusinessCard selectBusinessCard(int selectedCardNo) {
        String sql = "SELECT card_no, person_name, phone_no, company_name FROM business_card WHERE card_no = ?";
        BusinessCard businessCard = null;
        ResultSet rs;

        try (
                Connection con = DBConnector.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, selectedCardNo);
            rs = ps.executeQuery();

            if (rs.next()) {
                int cardNo = rs.getInt("CARD_NO");
                String personName = rs.getString("PERSON_NAME");
                String phoneNo = rs.getString("PHONE_NO");
                String companyName = rs.getString("COMPANY_NAME");

                businessCard = new BusinessCard.BusinessCardBuilder(cardNo)
                        .setPersonName(personName)
                        .setPhoneNo(phoneNo)
                        .setCompanyName(companyName)
                        .build();
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return businessCard;
    }

    public void deleteBusiness(int cardNo) {
        String sql = "DELETE FROM business_card WHERE card_no = ?";

        try (
                Connection con = DBConnector.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, cardNo);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void updateBusinessCard(int carNo, String personName, String phoneNo, String companyName) {
        String sql = "UPDATE business_card SET person_name = ?, phone_no = ?, company_name = ? WHERE card_no = ?";

        try (
                Connection con = DBConnector.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, personName);
            ps.setString(2, phoneNo);
            ps.setString(3, companyName);
            ps.setInt(4, carNo);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public List<BusinessCard> selectBusinessCards() {
        String sql = "SELECT card_no, person_name, phone_no, company_name FROM business_card";
        List<BusinessCard> businessCardList = new ArrayList<>();
        BusinessCard businessCard;

        try (
                Connection con = DBConnector.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                int cardNo = rs.getInt("CARD_NO");
                String personName = rs.getString("PERSON_NAME");
                String phoneNo = rs.getString("PHONE_NO");
                String companyName = rs.getString("COMPANY_NAME");

                businessCard = new BusinessCard.BusinessCardBuilder(cardNo)
                        .setPersonName(personName)
                        .setPhoneNo(phoneNo)
                        .setCompanyName(companyName)
                        .build();

                businessCardList.add(businessCard);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return businessCardList;
    }
}
