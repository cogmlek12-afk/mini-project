package patient.controller;

import java.io.*;
import java.util.ArrayList;
import patient.model.Patient;

public class PatientController {

    private ArrayList<Patient> patients = new ArrayList<>();
    private static final String FILE_NAME = "patients.txt";

    // 환자 등록
    public void addPatient(Patient p) {
        patients.add(p);
    }

    // 환자 조회
    public Patient findPatient(int ssn) {
        for (Patient p : patients) {
            if (p.getSsn() == ssn) {
                return p;
            }
        }
        return null;
    }

    // 환자 수정
    public boolean updateDepartment(int ssn, String department) {
        Patient p = findPatient(ssn);
        if (p != null) {
            p.setDepartment(department);
            return true;
        }
        return false;
    }

    // 환자 삭제
    public boolean deletePatient(int ssn) {
        Patient p = findPatient(ssn);
        if (p != null) {
            patients.remove(p);
            return true;
        }
        return false;
    }

    // 파일 저장
    public int fileSave() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("patients.txt"))) {
            for (Patient p : patients) {
            	String data = p.getName() + "/" + p.getAge() + "/" + p.getSsn() + "/" +
                        p.getP_ssn() + "/" + p.getGender() + "/" + p.getDepartment() + "\n";

                bw.write(data);
                bw.flush();
            }
          
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // 파일 불러오기
    public void fileLoad() {
      //  patients.clear(); // 기존 리스트 초기화
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String content;
            while ((content = br.readLine()) != null) {
                String[] datas = content.split("/");
                if (datas.length == 6) {
                    Patient p = new Patient(
                        datas[0],                          // name
                        Integer.parseInt(datas[1]),        // age
                        Integer.parseInt(datas[2]),        // ssn
                        Integer.parseInt(datas[3]),        // p_ssn
                        datas[4].charAt(0),                // gender
                        datas[5]                           // department
                    );
                    patients.add(p);
                }
            }
          //  System.out.println("환자 정보 불러오기 완료");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 현재 환자 목록 확인용
    public ArrayList<Patient> getPatients() {
        return patients;
    }
}
