package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //start line
        resp.setStatus(HttpServletResponse.SC_OK);

        //header
        resp.setHeader("Content-Type", "text/plain;charset=utf-8");
        resp.setHeader("Cache-Control", "no-cache, no-store, mustrevalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-header","hello");
        Cookie cookie = new Cookie("myCookie", "world");
        cookie.setMaxAge(600);
        resp.addCookie(cookie);

        //body
        resp.getWriter().write("ok");


        resp.sendRedirect("/basic/hello-form.html");
    }
}
