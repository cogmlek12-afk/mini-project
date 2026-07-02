package patient.model;

import java.io.Serializable;

public class Patient implements Serializable {

    private String name;
    private int age;
    private int ssn;
    private int p_ssn;
    private char gender;
    private String department;

    // 생성자
    public Patient(String name, int age, int ssn, int p_ssn, char gender, String department) {
        this.name = name;
        this.age = age;
        this.ssn = ssn;
        this.p_ssn = p_ssn;
        this.gender = gender;
        this.department = department;
    }

    // Getter 메서드들
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSsn() {
        return ssn;
    }

    public int getP_ssn() {
        return p_ssn;
    }

    public char getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    // Setter 메서드
    public void setDepartment(String department) {
        this.department = department;
    }

    // toString 오버라이드
    @Override
    public String toString() {
        return "환자번호 : " + ssn +
               ", 이름 : " + name +
               ", 나이 : " + age +
               ", 성별 : " + gender +
               ", 진료과 : " + department;
    }
}
