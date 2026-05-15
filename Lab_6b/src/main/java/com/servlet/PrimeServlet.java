package com.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/PrimeServlet")
public class PrimeServlet extends HttpServlet {
public void doPost(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{
response.setContentType("text/html");
PrintWriter out=response.getWriter();
String input=request.getParameter("num");
try{
int num=Integer.parseInt(input);
if(num<=1){
out.println("<h3>"+num+" is NOT a Prime Number</h3>");
}
else{
boolean isPrime=true;
for(int i=2;i<=num/2;i++){
if(num%i==0){
isPrime=false;
break;
}
}
if(isPrime)
out.println("<h3>"+num+" is a Prime Number</h3>");
else
out.println("<h3>"+num+" is NOT a Prime Number</h3>");
}
}catch(NumberFormatException e){
response.sendError(HttpServletResponse.SC_BAD_REQUEST,"Invalid Number Entered!");
}
}
}