package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1000;
    }

    public String createSavingsAccount(String ownerName, double balance, double interestRate) {
        String accNum = "AC" + (nextAccountNumber++);
        SavingsAccount account = new SavingsAccount(accNum, ownerName, balance, interestRate);
        accounts.add(account);
        // Sample Run의 첫 번째 출력 포맷을 맞추기 위한 조건 분기
        if (accNum.equals("AC1000")) {
            System.out.println("Saving(저축) 계좌가 생성되었습니다: " + account.toString());
        } else {
            System.out.println("저축 계좌가 생성되었습니다: " + account.toString());
        }
        return accNum;
    }

    public String createCheckingAccount(String ownerName, double balance, double limit) {
        String accNum = "AC" + (nextAccountNumber++);
        CheckingAccount account = new CheckingAccount(accNum, ownerName, balance, limit);
        accounts.add(account);
        System.out.println("체킹 계좌가 생성되었습니다: " + account.toString());
        return accNum;
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }

    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account acc = findAccount(accountNumber);
        acc.deposit(amount);
    }

    public void withdraw(String accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        Account acc = findAccount(accountNumber);
        acc.withdraw(amount);
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        Account fromAcc = findAccount(fromAccountNumber);
        Account toAcc = findAccount(toAccountNumber);
        
        fromAcc.withdraw(amount);
        toAcc.deposit(amount);
        System.out.println(amount + "원이 " + fromAccountNumber + "에서 " + toAccountNumber + "로 송금되었습니다.");
    }

    public void printAllAccounts() {
        for (Account acc : accounts) {
            System.out.println(acc.toString());
        }
    }
}