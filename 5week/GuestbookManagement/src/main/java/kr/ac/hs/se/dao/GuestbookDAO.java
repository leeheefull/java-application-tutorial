package kr.ac.hs.se.dao;

import kr.ac.hs.se.dto.Guestbook;
import kr.ac.hs.se.util.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuestbookDAO {

    private static GuestbookDAO guestbookDAO;

    private GuestbookDAO() {
    }

    public static synchronized GuestbookDAO getInstance() {
        if (guestbookDAO == null) {
            guestbookDAO = new GuestbookDAO();
        }
        return guestbookDAO;
    }


    public void insertBusinessCard(Guestbook guestbook) {
        String sql = "INSERT INTO guestbook(person_name, content) VALUES(?, ?)";

        try (
                Connection con = DBConnector.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, guestbook.getPersonName());
            ps.setString(2, guestbook.getContent());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeGuestbook(int id) {
        String sql = "DELETE FROM guestbook WHERE id = ?";

        try (
                Connection con = DBConnector.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Guestbook> selectedGuestbooks() {
        String sql = "SELECT id, person_name, content, regdate FROM guestbook";
        List<Guestbook> guestbookList = new ArrayList<>();

        try (
                Connection con = DBConnector.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String personName = rs.getString("PERSON_NAME");
                String content = rs.getString("CONTENT");
                String regdate = rs.getString("REGDATE");

                guestbookList.add(new Guestbook(id, personName, content, regdate));
            }
            return guestbookList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
