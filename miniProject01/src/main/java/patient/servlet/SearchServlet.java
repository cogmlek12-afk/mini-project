package patient.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import patient.dao.PatientDAO;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        int patientId = Integer.parseInt(request.getParameter("patientId"));

        PatientDAO dao = new PatientDAO();

        String result = dao.selectPatient(patientId);

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>조회 결과</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h2>조회 결과</h2>");
        out.println(result);

        out.println("<br><br>");
        out.println("<a href='search.jsp'>다시 조회</a>");
        out.println("<br>");
        out.println("<a href='index.jsp'>메인으로</a>");

        out.println("</body>");
        out.println("</html>");
    }
}