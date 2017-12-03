package model;

public class User {
    private static User instance;
    public static User getInstance(){
        if (instance == null){
            instance = new User();
        }
        return instance;
    }

    public static void setNull(){
        instance = null;
    }

    private String emp_no;
    private String emp_pass;
    private int type;
    public User(){}

    public User(String emp_no, String emp_pass) {
        this.emp_no = emp_no;
        this.emp_pass = emp_pass;
    }

    public User(String emp_no, String emp_pass, int type) {
        this.emp_no = emp_no;
        this.emp_pass = emp_pass;
        this.type = type;
    }

    public String getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(String emp_no) {
        this.emp_no = emp_no;
    }

    public String getEmp_pass() {
        return emp_pass;
    }

    public void setEmp_pass(String emp_pass) {
        this.emp_pass = emp_pass;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
