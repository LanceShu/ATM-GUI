package model;

public class Money {

    //卡号
    private String emp_no;

    //余额
    private Double balance;

    public Money(){}

    public Money(String emp_no, Double balance) {
        this.emp_no = emp_no;
        this.balance = balance;
    }

    public String getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(String emp_no) {
        this.emp_no = emp_no;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
