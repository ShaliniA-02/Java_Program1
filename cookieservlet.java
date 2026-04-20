//Build a servlet program to create a cookie to get your name through text box and press submit
//button( through HTML) to display the message by greeting Welcome back your name ! , you have
//visited this page n times ( n = number of your visit ) along with the list of cookies and its setvalues and
//demonstrate the expiry of cookie also.

package com.cookieservlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class cookieservlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();

Cookie[] cookies = request.getCookies();
String user = null;
int count = 0;

// READ COOKIES
if(cookies != null){
for(Cookie c : cookies){
if(c.getName().equals("user")){
user = c.getValue();
}
if(c.getName().equals("count")){
count = Integer.parseInt(c.getValue());
}
}
}

out.println("<html><body>");

if(user != null){

// INCREMENT COUNT
count++;
Cookie countCookie = new Cookie("count", String.valueOf(count));
countCookie.setMaxAge(60);
response.addCookie(countCookie);

// OUTPUT
out.println("<h2>Welcome back " + user + "!</h2>");
out.println("<h3>You have visited this page " + count + " times</h3>");

out.println("<h3>List of Cookies</h3>");
for(Cookie c : cookies){
out.println("Name : " + c.getName() + "<br>");
out.println("Value : " + c.getValue() + "<br><br>");
}

}
else{

// FIRST TIME FORM (LIKE YOUR IMAGE)
out.println("<h1 style='color:red'>Enter your name</h1>");
out.println("<form action='CookieServlet' method='post'>");
out.println("Enter Name: <input type='text' name='userName'><br><br>");
out.println("<input type='submit' value='Submit'>");
out.println("</form>");

}

out.println("</body></html>");
}

// HANDLE FORM SUBMIT
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

String name = request.getParameter("userName");

// CREATE COOKIES
Cookie userCookie = new Cookie("user", name);
Cookie countCookie = new Cookie("count", "1");

// SET EXPIRY
userCookie.setMaxAge(60);
countCookie.setMaxAge(60);

// ADD COOKIES
response.addCookie(userCookie);
response.addCookie(countCookie);

// REDIRECT TO doGet
response.sendRedirect("CookieServlet");
}
}