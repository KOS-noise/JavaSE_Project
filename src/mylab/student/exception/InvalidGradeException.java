package mylab.student.exception;

public class InvalidGradeException extends Exception {
	/* extends Exception (InvalidGradeException.java)
     * 자바의 기본 Exception 클래스 기능을 상속받기 위함.
     * try-catch, throw를 사용할 수 있는 '사용자 정의 예외'를 만들기 위한 필수 조건.
     */
	private int invalidGrade;
	
	public InvalidGradeException(String errMessage, int invalidGrade) {
		super(errMessage);
		this.invalidGrade = invalidGrade;
	}
	
	public int getInvalidGrade() {
		return invalidGrade;
	}

}
