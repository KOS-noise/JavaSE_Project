package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.entity.Account;
import mylab.bank.entity.SavingsAccount;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== 계좌 생성 ===");
        bank.createSavingsAccount("홍길동", 10000.0, 3.0);
        bank.createCheckingAccount("김철수", 20000.0, 5000.0);
        bank.createSavingsAccount("이영희", 30000.0, 2.0);

        System.out.println("\n=== 모든 계좌 목록 ===");
        bank.printAllAccounts();
        System.out.println("===================");

        try {
            System.out.println("\n=== 입금/출금 테스트 ===");
            bank.deposit("AC1000", 5000.0);
            bank.withdraw("AC1001", 3000.0);

            System.out.println("\n=== 이자 적용 테스트 ===");
            Account acc = bank.findAccount("AC1000");
            if (acc instanceof SavingsAccount) {
                ((SavingsAccount) acc).applyInterest();
            }

            System.out.println("\n=== 계좌 이체 테스트 ===");
            bank.transfer("AC1002", "AC1001", 5000.0);

            System.out.println("\n=== 모든 계좌 목록 ===");
            bank.printAllAccounts();
            System.out.println("===================");

        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // 예외 발생 테스트 분리 (각각 개별 try-catch로 독립적 테스트 진행)
        try {
            bank.withdraw("AC1001", 6000.0); // 출금 한도 초과
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        
        try {
            bank.withdraw("AC1001", 6000.0); // 출금 한도 초과 (Sample Run 출력 횟수 맞춤)
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999"); // 없는 계좌 검색
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}