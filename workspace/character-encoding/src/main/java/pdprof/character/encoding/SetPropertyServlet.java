package pdprof.character.encoding;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetPropertyServlet
 */
@WebServlet("/setproperty")
public class SetPropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetPropertyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Set Property Result</title>");
        out.println("</head>");
        out.println("<body>");


        Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			if (name.equalsIgnoreCase("default_encoding")) {
				String defaultEncoding = request.getParameter("default_encoding");
				if (defaultEncoding != null) {
					if (defaultEncoding.length() == 0 || defaultEncoding.equalsIgnoreCase("null")) {  
						defaultEncoding = null;
					}
				}
				System.setProperty("default.client.encoding", defaultEncoding);
				out.println("default.client.encoding = " + System.getProperty("default.client.encoding") + "<br />");
			} else if (name.equalsIgnoreCase("encoding_override")) {
				String encodingOverride = request.getParameter("encoding_override");
				System.setProperty("client.encoding.override", encodingOverride);
				if (encodingOverride != null) {
					if (encodingOverride.length() == 0 || encodingOverride.equalsIgnoreCase("null")) {  
						encodingOverride = null;
					}
				}
				out.println("client.encoding.override = " + System.getProperty("client.encoding.override") + "<br />");
			}
		}
		out.println("Back to <a href=\"index.jsp\">index.jsp</a>");
        out.println("</body>");
        out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
