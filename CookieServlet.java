package com.cookieservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle GET (Login + Display)
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");

        // Create cookies if user enters name
        if (userName != null && !userName.isEmpty()) {

            Cookie userCookie = new Cookie("user", userName);
            userCookie.setMaxAge(60); // 1 minute
            response.addCookie(userCookie);

            Cookie countCookie = new Cookie("count", "1");
            countCookie.setMaxAge(60);
            response.addCookie(countCookie);
        }

        // Read cookies
        Cookie[] cookies = request.getCookies();
        String existingUser = null;
        int count = 0;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    existingUser = c.getValue();
                }
                if (c.getName().equals("count")) {
                    count = Integer.parseInt(c.getValue());
                }
            }
        }

        // Increase visit count if user exists
        if (existingUser != null) {
            count++;

            Cookie countCookie = new Cookie("count", String.valueOf(count));
            countCookie.setMaxAge(60);
            response.addCookie(countCookie);
        }

        // HTML Output
        out.println("<html>");
        out.println("<head><title>Cookie Example</title></head>");
        out.println("<body>");

        if (existingUser != null) {
            out.println("<h2 style='color:blue;'>Welcome back, " + existingUser + "!</h2>");
            out.println("<h2 style='color:magenta;'>You have visited this page " + count + " times!</h2>");

            out.println("<form action='CookieServlet' method='post'>");
            out.println("<input type='submit' value='Logout'>");
            out.println("</form>");
        } else {
            out.println("<h2 style='color:red;'>Welcome Guest! Please login.</h2>");
            out.println("<form action='CookieServlet' method='get'>");
            out.println("Enter your name: <input type='text' name='userName' required>");
            out.println("<input type='submit' value='Login'>");
            out.println("</form>");
        }

        out.println("</body>");
        out.println("</html>");
    }

    // Handle POST (Logout)
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Delete cookies
        Cookie userCookie = new Cookie("user", "");
        userCookie.setMaxAge(0);
        response.addCookie(userCookie);

        Cookie countCookie = new Cookie("count", "");
        countCookie.setMaxAge(0);
        response.addCookie(countCookie);

        response.sendRedirect("CookieServlet");
    }
}