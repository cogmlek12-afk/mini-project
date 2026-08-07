package patient.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import patient.common.DBConnection;
import patient.dto.Patient;

public class PatientDAO {
	
	

    // ===========================
    // 전체 조회
    // ===========================
    public String selectAll() {

        StringBuilder sb = new StringBuilder();

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM PATIENT ORDER BY PATIENT_ID";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                sb.append("환자번호 : ")
                  .append(rs.getInt("PATIENT_ID"))
                  .append("<br>");

                sb.append("이름 : ")
                  .append(rs.getString("NAME"))
                  .append("<br>");

                sb.append("나이 : ")
                  .append(rs.getInt("AGE"))
                  .append("<br>");

                sb.append("주민번호 : ")
                  .append(rs.getString("SSN"))
                  .append("<br>");

                sb.append("보호자번호 : ")
                  .append(rs.getString("P_SSN"))
                  .append("<br>");

                sb.append("성별 : ")
                  .append(rs.getString("GENDER"))
                  .append("<br>");

                sb.append("진료과 : ")
                  .append(rs.getString("DEPARTMENT"))
                  .append("<hr>");
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    // ===========================
    // 환자 등록
    // ===========================
    public int insertPatient(Patient p) {

        int result = 0;

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
                    "INSERT INTO PATIENT VALUES(?,?,?,?,?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, p.getPatientId());
            pstmt.setString(2, p.getName());
            pstmt.setInt(3, p.getAge());
            pstmt.setString(4, p.getSsn());
            pstmt.setString(5, p.getPSsn());
            pstmt.setString(6, p.getGender());
            pstmt.setString(7, p.getDepartment());

            result = pstmt.executeUpdate();

            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // ===========================
    // 환자 수정
    // ===========================
    public int updatePatient(Patient p) {

        int result = 0;

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
                    "UPDATE PATIENT "
                  + "SET NAME=?, AGE=?, SSN=?, P_SSN=?, GENDER=?, DEPARTMENT=? "
                  + "WHERE PATIENT_ID=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, p.getName());
            pstmt.setInt(2, p.getAge());
            pstmt.setString(3, p.getSsn());
            pstmt.setString(4, p.getPSsn());
            pstmt.setString(5, p.getGender());
            pstmt.setString(6, p.getDepartment());
            pstmt.setInt(7, p.getPatientId());

            result = pstmt.executeUpdate();

            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    

    // ===========================
    // 환자 삭제
    // ===========================
    public int deletePatient(int patientId) {

        int result = 0;

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
                    "DELETE FROM PATIENT WHERE PATIENT_ID=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, patientId);

            result = pstmt.executeUpdate();

            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    
 // 환자번호로 조회
    public String selectPatient(int patientId) {

        StringBuilder sb = new StringBuilder();

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM PATIENT WHERE PATIENT_ID=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, patientId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                sb.append("환자번호 : ")
                  .append(rs.getInt("PATIENT_ID"))
                  .append("<br>");

                sb.append("이름 : ")
                  .append(rs.getString("NAME"))
                  .append("<br>");

                sb.append("나이 : ")
                  .append(rs.getInt("AGE"))
                  .append("<br>");

                sb.append("주민번호 : ")
                  .append(rs.getString("SSN"))
                  .append("<br>");

                sb.append("보호자번호 : ")
                  .append(rs.getString("P_SSN"))
                  .append("<br>");

                sb.append("성별 : ")
                  .append(rs.getString("GENDER"))
                  .append("<br>");

                sb.append("진료과 : ")
                  .append(rs.getString("DEPARTMENT"));

            } else {

                sb.append("<h3 style='color:red;'>등록되지 않은 환자입니다.</h3>");

            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
    public Patient findPatient(int patientId) {

        Patient p = null;

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM PATIENT WHERE PATIENT_ID=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, patientId);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){

                p = new Patient();

                p.setPatientId(rs.getInt("PATIENT_ID"));
                p.setName(rs.getString("NAME"));
                p.setAge(rs.getInt("AGE"));
                p.setSsn(rs.getString("SSN"));
                p.setPSsn(rs.getString("P_SSN"));
                p.setGender(rs.getString("GENDER"));
                p.setDepartment(rs.getString("DEPARTMENT"));
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return p;
    }
    
 // ===========================
 // 이름으로 환자 조회
 // ===========================
 public Patient findPatient(String name) {

     Patient p = null;

     try {

         Connection conn = DBConnection.getConnection();
         String sql = "SELECT * FROM PATIENT WHERE TRIM(NAME)=?";

         PreparedStatement pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, name.trim());
         ResultSet rs = pstmt.executeQuery();


         if(rs.next()) {

             p = new Patient();

             p.setPatientId(rs.getInt("PATIENT_ID"));
             p.setName(rs.getString("NAME"));
             p.setAge(rs.getInt("AGE"));
             p.setSsn(rs.getString("SSN"));
             p.setPSsn(rs.getString("P_SSN"));
             p.setGender(rs.getString("GENDER"));
             p.setDepartment(rs.getString("DEPARTMENT"));

         }


         rs.close();
         pstmt.close();
         conn.close();


     } catch(Exception e) {

         e.printStackTrace();

     }


     return p;
 }
    
}