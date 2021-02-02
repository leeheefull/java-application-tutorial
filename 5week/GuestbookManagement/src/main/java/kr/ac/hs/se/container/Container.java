package kr.ac.hs.se.container;

import kr.ac.hs.se.dao.GuestbookDAO;
import kr.ac.hs.se.service.GuestbookService;

public class Container {

    public static GuestbookDAO guestbookDAO;
    public static GuestbookService guestbookService;

    static {
        guestbookDAO = new GuestbookDAO();
        guestbookService = new GuestbookService();
    }
}
