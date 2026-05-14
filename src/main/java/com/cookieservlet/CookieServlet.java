package com.cookieservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")

public class CookieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String name = request.getParameter("userName");

        Cookie cookies[] = request.getCookies();

        int visitCount = 0;

        boolean userFound = false;

        if (cookies != null) {

            for (Cookie c : cookies) {

                if (c.getName().equals("visitCount")) {

                    visitCount = Integer.parseInt(c.getValue());
                }

                if (c.getName().equals("user")) {

                    userFound = true;
                }
            }
        }

        visitCount++;

        String encodedName = URLEncoder.encode(name, "UTF-8");

        Cookie userCookie = new Cookie("user", encodedName);

        Cookie visitCookie =
                new Cookie("visitCount",
                        String.valueOf(visitCount));

        // Cookie expiry time : 1 minute
        userCookie.setMaxAge(60);

        visitCookie.setMaxAge(60);

        response.addCookie(userCookie);

        response.addCookie(visitCookie);

        out.println("<html>");
        out.println("<body>");

        out.println("<h2>Welcome back "
                + name + " !</h2>");

        out.println("<h3>You have visited this page "
                + visitCount + " times</h3>");

        out.println("<h3>List of Cookies</h3>");

        if (cookies != null) {

            for (Cookie c : cookies) {

                out.println("Cookie Name : "
                        + c.getName());

                out.println("<br>");

                out.println("Cookie Value : "
                        + URLDecoder.decode(
                                c.getValue(),
                                "UTF-8"));

                out.println("<br><br>");
            }
        }

        out.println("<p>Cookie Expiry Time : 60 seconds</p>");

        out.println("</body>");
        out.println("</html>");
    }
}