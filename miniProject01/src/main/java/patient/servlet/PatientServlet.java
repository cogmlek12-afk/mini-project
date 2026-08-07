package patient.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import patient.dao.PatientDAO;

@WebServlet("/patient")
public class PatientServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        PatientDAO dao = new PatientDAO();

        String result = dao.selectAll();

        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("<meta charset='UTF-8'>");
        response.getWriter().println("<title>환자 조회</title>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");

        response.getWriter().println("<h2>환자 목록</h2>");
        response.getWriter().println(result);

        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }

}