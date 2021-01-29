package kr.ac.hs.se.service;

import kr.ac.hs.se.dao.GuestbookDAO;
import kr.ac.hs.se.dto.Guestbook;

import java.util.ArrayList;
import java.util.List;

public class GuestbookService {

    private static GuestbookService guestbookService;
    private final GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();

    private GuestbookService() {
    }

    public static synchronized GuestbookService getInstance() {
        if (guestbookService == null) {
            guestbookService = new GuestbookService();
        }
        return guestbookService;
    }

    public void createGuestbook(String personName, String content) {
        Guestbook guestbook = new Guestbook(personName, content);
        guestbookDAO.insertBusinessCard(guestbook);
    }

    public List<Guestbook> getGuestbooks() {
        return new ArrayList<>(guestbookDAO.selectedGuestbooks());
    }
}
