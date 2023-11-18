package interfaces;

public class MaxSalaryWorker {
    private String NAME;
    private int SALARY;

    public String getName() {
        return NAME;
    }

    public void setName(String NAME) {
        this.NAME = NAME;
    }

    public int getSalary() {
        return SALARY;
    }

    public void setSalary(int SALARY) {
        this.SALARY = SALARY;
    }

    @Override
    public String toString() {
        return "{" + "SALARY: " + getSalary() + ", name: " + getName() + "}";
    }
}
