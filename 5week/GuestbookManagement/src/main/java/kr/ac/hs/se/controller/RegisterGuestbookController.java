package kr.ac.hs.se.controller;

import kr.ac.hs.se.container.Container;
import kr.ac.hs.se.service.GuestbookService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterGuestbookController extends HttpServlet {

    private final GuestbookService guestbookService = Container.guestbookService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");

        String personName = request.getParameter("personName");
        String content = request.getParameter("content");

        guestbookService.createGuestbook(personName, content);
        response.sendRedirect("guestbook");
    }
}