package kr.ac.hs.se.controller;

import kr.ac.hs.se.service.GuestbookService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteGuestBookController extends HttpServlet {

    private final GuestbookService guestbookService = GuestbookService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int no = Integer.parseInt(request.getParameter("no"));
        guestbookService.deleteGuestbook(no);

        response.sendRedirect("guestbook");
    }
}
