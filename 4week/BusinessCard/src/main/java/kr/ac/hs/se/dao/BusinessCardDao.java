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

    public BusinessCard selectBusinessCard(int cardNo) {
        String sql = "SELECT card_no, person_name, phone_no, company_name FROM business_card WHERE card_no = ?";
        BusinessCard businessCard = null;
        ResultSet rs;

        try (
                Connection con = DBConnector.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, cardNo);
            rs = ps.executeQuery();

            if (rs.next()) {
                int cardNo_ = rs.getInt(1);
                String personName_ = rs.getString(2);
                String phoneNo_ = rs.getString(3);
                String companyName_ = rs.getString(4);

                businessCard = BusinessCard.getInstance(cardNo_, personName_, phoneNo_, companyName_);
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

        try (
                Connection con = DBConnector.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int cardNo = rs.getInt(1);
                    String personName = rs.getString(2);
                    String phoneNo = rs.getString(3);
                    String companyName = rs.getString(4);

                    businessCardList.add(BusinessCard.getInstance(cardNo, personName, phoneNo, companyName));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return businessCardList;
    }
}
