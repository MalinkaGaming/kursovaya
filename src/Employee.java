public class Employee {
    private static int counter = 0;
    private String fullname;
    private int department;
    private int salary;
    private int id;

    public Employee(String fullname, int department, int salary) {
        this.fullname = fullname;
        this.department = department;
        this.salary = salary;
        this.id = ++counter;
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Отдел должен быть от 1 до 5");
        }
    }
    public String getFullname() {
        return fullname;
    }
    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id: " + getId() + " ФИО сотрудника: " + getFullname() + " Отдел: " + department + " Зарплата: " + getSalary();
    }

}