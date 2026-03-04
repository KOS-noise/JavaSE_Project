package mylab.student.control;

import mylab.student.exception.InvalidGradeException;
import mylab.student.entity.Student;

public class StudentTest {
	public static void main(String [] args) {
		//Student 객체 생성
		Student student = new Student();
		
		student.setName("김민수");
		student.setMajor("컴퓨터공학");
		
		try {
			// 정상적인 데이터 입력
			student.setGrade(3);
			System.out.println(student.getName() + " / " + student.getMajor() + " / " + student.getGrade() + "학년");
			
			
			// 비정상적인 데이터 입력 시도 (예외 발생)
			System.out.println("5학년으로 변경");
			student.setGrade(5);
		}
		catch (InvalidGradeException e) {
			// 예외 처리문 출력
			System.out.println(e.getMessage());
		}
	}

}
