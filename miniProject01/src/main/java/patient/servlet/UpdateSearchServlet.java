package patient.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import patient.dao.PatientDAO;
import patient.dto.Patient;


@WebServlet("/updateSearch")
public class UpdateSearchServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");


        // updateSearch.jsp에서 받은 환자번호
        String name = request.getParameter("name");

        PatientDAO dao = new PatientDAO();

        Patient patient = dao.findPatient(name);
        System.out.println("검색 이름 : " + name);
        System.out.println("검색 결과 : " + patient);

        // 조회 결과 저장
        request.setAttribute("patient", patient);


        // 수정 화면으로 이동
        request.getRequestDispatcher("update.jsp")
               .forward(request, response);

    }

}