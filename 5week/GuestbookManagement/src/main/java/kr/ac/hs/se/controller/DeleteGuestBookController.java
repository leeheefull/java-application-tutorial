package kr.ac.hs.se.controller;

import kr.ac.hs.se.container.Container;
import kr.ac.hs.se.service.GuestbookService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteGuestBookController extends HttpServlet {

    private final GuestbookService guestbookService = Container.guestbookService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int no = Integer.parseInt(request.getParameter("no"));
        guestbookService.deleteGuestbook(no);

        response.sendRedirect("guestbook");
    }
}
