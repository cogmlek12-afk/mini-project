package patient.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import patient.dao.PatientDAO;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int patientId =
                Integer.parseInt(request.getParameter("patientId"));

        PatientDAO dao = new PatientDAO();

        dao.deletePatient(patientId);

        response.sendRedirect("patient");
    }
}