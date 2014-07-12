package org.nitin.jaiman;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dictionary
 */
@WebServlet("/Dictionary")
public class Dictionary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dictionary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String get=request.getParameter("word");
		System.out.println(get);
		OnlineDictionary od=new OnlineDictionary();
		String getresult=od.executeQuery(get);
		PrintWriter writer=response.getWriter();
		
		
		
		
		 Matcher m = Pattern.compile(
                 // Pattern.quote("<p class=\"bottom_entry\">: ")
                  Pattern.quote("<p class=\"short\">") 
                  + "(.*?)"
                          + Pattern.quote("</p>")
          ).matcher(getresult);
          while(m.find()){
              String match = m.group(1);
             String newmatch= match.replaceAll("\\<.*?>","");
           writer.append("<html><b> Short meaning: "+newmatch+"</b></html>");
          }
		
		
          
          Matcher m2 = Pattern.compile(
                  Pattern.quote("<p class=\"long\">")
                          + "(.*?)"
                          + Pattern.quote("</p>")
          ).matcher(getresult);
          
          writer.append("<br><br><br>");
          while(m2.find()){
              String match2 = m2.group(1);
              String newmatch2= match2.replaceAll("\\<.*?>","");
              writer.append("<body> Detailed meaning: "+newmatch2+"</body>");
              //here you insert 'match' into the list
          }
          
          
          
		
	}

}
