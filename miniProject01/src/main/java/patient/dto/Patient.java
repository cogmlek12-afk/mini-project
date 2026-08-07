package patient.dto;

public class Patient {

    private int patientId;
    private String name;
    private int age;
    private String ssn;
    private String pSsn;
    private String gender;
    private String department;

    // 기본 생성자
    public Patient() {
    }

    // 전체 생성자
    public Patient(int patientId, String name, int age, String ssn, String pSsn, String gender, String department) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.ssn = ssn;
        this.pSsn = pSsn;
        this.gender = gender;
        this.department = department;
    }

    // Getter
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSsn() {
        return ssn;
    }

    public String getPSsn() {
        return pSsn;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    // Setter
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setPSsn(String pSsn) {
        this.pSsn = pSsn;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Patient [patientId=" + patientId +
                ", name=" + name +
                ", age=" + age +
                ", ssn=" + ssn +
                ", pSsn=" + pSsn +
                ", gender=" + gender +
                ", department=" + department + "]";
    }

		
	}
