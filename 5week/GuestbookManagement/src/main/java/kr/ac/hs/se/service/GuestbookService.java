package kr.ac.hs.se.service;

import kr.ac.hs.se.container.Container;
import kr.ac.hs.se.dao.GuestbookDAO;
import kr.ac.hs.se.dto.Guestbook;

import java.util.List;

public class GuestbookService {

    private final GuestbookDAO guestbookDAO = Container.guestbookDAO;

    public void createGuestbook(String personName, String content) {
        Guestbook guestbook = new Guestbook(personName, content);
        guestbookDAO.insertBusinessCard(guestbook);
    }

    public void deleteGuestbook(int id) {
        guestbookDAO.removeGuestbook(id);
    }

    public List<Guestbook> getGuestbooks() {
        return guestbookDAO.selectGuestbooks();
    }
}
