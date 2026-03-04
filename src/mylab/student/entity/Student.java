package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student extends Object {  // Object 라는 자바 기본 내장 패키지를 따름
	private String studentId;
	private String name;
	private String major;
	private int grade;
	
	
	// 기본 생성자
	public Student() {
		
	}
	
	// 생성자 오버로딩
	public Student(String studentId, String name) {
		setStudentId(studentId);
		setName(name);
	}
	
	// 세터
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public void setName(String name) {
        this.name = name;
    }
	
	public void setMajor(String major) {
        this.major = major;
    }
	
	// StudentTest에서 try/catch 예외처리 하도록 위임
	public void setGrade(int grade) throws InvalidGradeException {
		if(grade < 1 || grade > 4) {
			// Exception을 강제로 발생시킴
			throw new InvalidGradeException("학년은 1~4 사이여야 합니다.", grade);
		}
		this.grade = grade;
	}
	
	// 게터
	public String getStudentId() {
		return studentId;
	}
	
	public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getGrade() {
        return grade;
    }
    
    /* @Override 어노테이션 (Student.java)
     * 부모(Object) 클래스의 메서드 재정의를 컴파일러에게 명시.
     * 메서드명 오타 방지 및 코드 가독성 향상 목적.
     */
    // 메서드 재정의 오버라이딩
    @Override
    public String toString() {
        return "Student [학번 =" + studentId + ", 이름 =" + name + ", 전공 =" + major + ", 학년 =" + grade + "]";
    }
}
