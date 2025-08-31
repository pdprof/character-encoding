package pdprof.character.encoding;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DefaultServlet
 */
@WebServlet("/default")
public class DefaultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DefaultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String str = request.getParameter("str");
		out.println("***** Original str : " + str + " *****");
        str.codePoints().forEach(codePoint -> {
            System.out.printf("Character %s, Code Point(HEX:16): U+%X%n",
                  Character.toString((char)codePoint), codePoint);
            out.printf("Character %s, Code Point(HEX:16): U+%X%n",
                  Character.toString((char)codePoint), codePoint);
        });
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
