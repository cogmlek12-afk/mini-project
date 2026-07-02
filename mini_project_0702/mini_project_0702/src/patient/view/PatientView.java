package patient.view;

import java.util.Scanner;

import patient.controller.PatientController;
import patient.model.Patient;

public class PatientView {

    private Scanner sc = new Scanner(System.in);
    private PatientController pc = new PatientController();

    public void mainMenu1() {
        while (true) {
            System.out.println("\n_____ 📁 환자 관리 프로그램 📁 _____");
            System.out.println("");
            System.out.println("        1. 📄 환자 등록");
            System.out.println("        2. 🔍 환자 조회");
            System.out.println("        3. ✏️ 환자 수정");
            System.out.println("        4. 🗑️ 환자 삭제");
            System.out.println("        5. 📄 파일 저장");
            System.out.println("        0. 🔘 종료 🔘");
            System.out.println("");
            System.out.print(" 👉 👉 👉 메뉴 선택 : ");

            int menu = readInt();
        

            switch (menu) {
                case 1: insertPatient(); break;
                case 2: searchPatient(); break;
                case 3: updatePatient(); break;
                case 4: deletePatient(); break;
                case 5: pc.fileSave(); System.out.println("파일 저장 완료!"); break;
                case 6: pc.fileLoad(); System.out.println("파일 불러오기 완료!"); break;
                case 0: System.out.println("프로그램 종료"); return;
                default: System.out.println("잘못된 입력입니다.");
            }
        }
    }
    
    private int readInt() {
		// MismatchException.. 예외가 발생하지 않은 경우, 반복문 종료
		int menu = -1;
				
		while(!sc.hasNextInt()) {
			System.out.print(" ⚠️ 잘못 입력하셨습니다. 올바른 숫자를 입력하세요 : ");
			sc.next();
			
		}
			menu = sc.nextInt();
			sc.nextLine();
				
		
		return menu;

	}


    // 환자 등록
 // 환자 등록
    private void insertPatient() {
        System.out.print("이름 : ");
        String name = sc.nextLine();

        System.out.print("나이 : ");
        int age = readIntInput();

        System.out.print("환자번호 : ");
        int ssn = readIntInput();

        System.out.print("보호자번호 : ");
        int p_ssn = readIntInput();

        System.out.print("성별(M/F) : ");
        char gender = sc.nextLine().charAt(0);

        System.out.print("진료과 : ");
        String department = sc.nextLine();

        pc.addPatient(new Patient(name, age, ssn, p_ssn, gender, department));
        System.out.println("등록 완료!");
    }

    // 숫자 입력 유틸 메서드
    private int readIntInput() {
        while (true) {
            String input = sc.nextLine();
            try {
                return Integer.parseInt(input); // 숫자로 변환
            } catch (NumberFormatException e) {
                System.out.print("⚠ 잘못된 입력입니다. 숫자만 입력해주세요: ");
            }
        }
    }

    // 환자 조회
    private void searchPatient() {
        System.out.print("조회할 환자번호 : ");
        String input = sc.nextLine(); // 문자열로 입력받기

        try {
            int ssn = Integer.parseInt(input); // 숫자로 변환 시도
            Patient p = pc.findPatient(ssn);

            if (p == null) {
                System.out.println("⚠ 등록되지 않은 환자번호입니다. 다시 확인해주세요.");
            } else {
                System.out.println("이름: " + p.getName() + ", 나이: " + p.getAge() +
                                   ", 성별: " + p.getGender() + ", 진료과: " + p.getDepartment());
            }
        } catch (NumberFormatException e) {
            System.out.println("⚠ 잘못된 입력입니다. 환자번호는 숫자만 입력해주세요.");
        }
    }

    // 환자 수정
 // 환자 수정
    private void updatePatient() {
        System.out.print("수정할 환자번호 : ");
        String input = sc.nextLine(); // 문자열로 입력받기

        try {
            int ssn = Integer.parseInt(input); // 숫자로 변환 시도
            Patient p = pc.findPatient(ssn);

            if (p == null) {
                System.out.println("⚠ 잘못 입력하셨습니다. 등록되지 않은 환자번호입니다.");
                return;
            }

            System.out.print("변경할 진료과 : ");
            String department = sc.nextLine();

            if (pc.updateDepartment(ssn, department)) {
                System.out.println("✏️ 수정 완료!");
            } else {
                System.out.println("수정 실패!");
            }
        } catch (NumberFormatException e) {
            System.out.println("⚠ 잘못된 입력입니다. 환자번호는 숫자만 입력해주세요.");
        }
    }


 // 환자 삭제
    private void deletePatient() {
        System.out.print("삭제할 환자번호 : ");
        String input = sc.nextLine(); // 문자열로 입력받기

        try {
            int ssn = Integer.parseInt(input); // 숫자로 변환 시도

            if (pc.deletePatient(ssn)) {
                System.out.println("🗑️ 삭제 완료!");
            } else {
                System.out.println("⚠ 등록되지 않은 환자번호입니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("⚠ 잘못된 입력입니다. 환자번호는 숫자만 입력해주세요.");
        }
    }
}