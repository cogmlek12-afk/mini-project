package patient.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import patient.dao.PatientDAO;
import patient.dto.Patient;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Patient p = new Patient();

        p.setPatientId(Integer.parseInt(request.getParameter("patientId")));
        p.setName(request.getParameter("name"));
        p.setAge(Integer.parseInt(request.getParameter("age")));
        p.setSsn(request.getParameter("ssn"));
        p.setPSsn(request.getParameter("pssn"));
        p.setGender(request.getParameter("gender"));
        p.setDepartment(request.getParameter("department"));

        PatientDAO dao = new PatientDAO();

        dao.updatePatient(p);

        response.sendRedirect("index.jsp");
    }
}