package gov.igw.examples;

import java.io.*;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.catalina.realm.GenericPrincipal;

public class GatewayHelloWorld extends HttpServlet {

private String message;

public void init() throws ServletException
{
   // Do required initialization here
   message = "Gateway Hello World!";
}

public void doGet(HttpServletRequest request,
                 HttpServletResponse response)
         throws ServletException, IOException
{
   // Set response content type
   response.setContentType("text/html");
   
   PrintWriter out = response.getWriter();
   
   // Set the banner up
   // See the instructions on the wiki on setting up the banner
   // This could be better done with a jsp but you get the idea
   out.println("<div class=\"gateway-banner\"></div>");
   out.println("<link rel=\"stylesheet\" href=\"https://igw-us.s3-us-gov-west-1.amazonaws.com/javascripts/vendor/bower-managed/gateway-banner/gateway-banner.css\"/>");
   out.println("<script src=\"https://igw-us.s3-us-gov-west-1.amazonaws.com/gateway-banner/gateway-banner.js\"></script>");
   out.println("<script>window.Banner.init({element: '.gateway-banner',gatewayUrl: 'https://www.igw.us'});</script>");
   
   // Application logic goes here.
   out.println("<h1>" + message + "</h1>");
  
   out.println("<h2>" + "You can download the source for this example Gateway app at " + "Coming Soon!" + "</h2>");
   
   GenericPrincipal principal = (GenericPrincipal) request.getUserPrincipal();
   String roles[] = principal.getRoles();
   
   out.println("<h2>" + "Your Gateway username is " + request.getUserPrincipal().getName() + "</h2>");
   out.println("<table style=\"width:100%\">");
   
   out.println("<h2>" + "Your Gateway roles/properties are:" + "</h2>");
   
   for (String role : roles) {
	   out.println("<tr><td>" + role + "</td></tr>");
   }
   out.println("</table>");
}

public void destroy()
{
   // do nothing.
}
}