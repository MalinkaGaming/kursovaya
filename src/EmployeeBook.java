public class EmployeeBook {
    public EmployeeBook() {
    }

    private Employee[] employeesArr = new Employee[10];

    public void addEmployee(String fullName, int department, int salary) {
        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i] == null) {
                employeesArr[i] = new Employee(fullName, department, salary);
                break;
            }
        }
    }

    public void removeEmployeeFullname(String fullName) {
        for (Employee employee : employeesArr) {
            if (employee != null && employee.getFullname().equals(fullName)) {
                employee = null;
                break;
            }
        }
    }

    public void removeEmployeeId(int id) {
        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i].getId() == id) {
                employeesArr[i] = null;
                break;
            }
        }
    }

    public void printAllEmployeesInfo() {
        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i] != null) {
                System.out.println(employeesArr[i]);
            }
        }
    }


    public void printAllEmployeesName() {
        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i] != null) {
                System.out.println(employeesArr[i].getFullname());
            }
        }
    }

    public double calcAverageSalary() {
        int sum = 0;
        for (Employee employee : employeesArr) {
            sum += employee.getSalary();
        }
        double averageSalary = sum / employeesArr.length;
        return averageSalary;
    }

    public int calcSalaryCosts() {
        int sum = 0;
        for (int i = 0; i < employeesArr.length; i++) {
            sum += employeesArr[i].getSalary();
        }
        return sum;
    }

    public Employee minimalEmployeeSalary() {
        Employee minimalSalaryEmployeer = employeesArr[0];
        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i] != null && employeesArr[i].getSalary() < minimalSalaryEmployeer.getSalary()) {
                minimalSalaryEmployeer = employeesArr[i];
            }
        }
        return minimalSalaryEmployeer;
    }

    public Employee maximalEmployeeSalary() {
        Employee maximalSalaryEmployeer = employeesArr[0];
        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i] != null && employeesArr[i].getSalary() > maximalSalaryEmployeer.getSalary()) {
                maximalSalaryEmployeer = employeesArr[i];
            }
        }
        return maximalSalaryEmployeer;
    }


    public void increaseSalary(int increment) {
        int i = 0;
        for (; i < employeesArr.length; i++) {
            int salaryIncrease = (employeesArr[i].getSalary() * increment / 100) + employeesArr[i].getSalary();
            employeesArr[i].setSalary(salaryIncrease);
            System.out.println("Зарплаты всех работников после индексации стали: " + employeesArr[i].getFullname() + ": " + employeesArr[i].getSalary());
        }
    }

    public Employee getDepartmentMinSalaryEmployee(int department) {

        Employee minSalaryEmployee = null;
        int minSalary = Integer.MAX_VALUE;

        for (Employee employee : employeesArr) {
            if (employee != null && employee.getDepartment() == department &&
                    employee.getSalary() < minSalary) {

                minSalary = employee.getSalary();
                minSalaryEmployee = employee;
            }
        }

        return minSalaryEmployee;
    }

    public Employee getDepartmentMaxSalaryEmployee(int department) {
        Employee maxSalaryEmployee = null;
        int maxSalary = Integer.MIN_VALUE;
        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i].getDepartment() == department && employeesArr[i].getSalary() > maxSalary) {
                maxSalary = employeesArr[i].getSalary();
                maxSalaryEmployee = employeesArr[i];
            }
        }
        return maxSalaryEmployee;
    }

    public double getCostDepartmentSalary(int department) {
        int sum = 0;
        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i].getDepartment() == department) {
                sum += employeesArr[i].getSalary();
            }
        }
        return sum;
    }

    public void printIncreaseDepartmentSalary(int department, int increment) {
        int i = 0;
        for (; i < employeesArr.length; i++) {
            int salaryIncrease = 0;
            if (employeesArr[i].getDepartment() == department) {
                salaryIncrease = (employeesArr[i].getSalary() * increment / 100) + employeesArr[i].getSalary();
                employeesArr[i].setSalary(salaryIncrease);
                System.out.println("Зарплаты в отделе после индексации стали: " + employeesArr[i].getFullname() + ": " + employeesArr[i].getSalary());
            }
        }
    }

    public void printDepartmentEmployeesNames(int department) {
        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i].getDepartment() == department) {
                System.out.println("id: " + employeesArr[i].getId() + " ФИО: " + employeesArr[i].getFullname() + " Зарплата: " + employeesArr[i].getSalary());
            }
        }
    }

    public void printIsSalaryBigger(int number) {
        System.out.println("Сотрудники, чья зарплата ниже числа: ");
        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i].getSalary() < number) {
                System.out.println(employeesArr[i].getId() + " " + employeesArr[i].getFullname() + " " + employeesArr[i].getSalary());
            }
        }
        System.out.println();
        System.out.println("Сотрудники, чья зарплата выше или равна числу: ");
        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i].getSalary() >= number) {
                System.out.println(employeesArr[i].getId() + " " + employeesArr[i].getFullname() + " " + employeesArr[i].getSalary());
            }
        }
    }

    public void changeEmployeeSalary(String fullName, int newSalary) {
        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i].getFullname().equals(fullName)) {
                employeesArr[i].setSalary(newSalary);
            }
        }
    }

    public void changeEmployeeDepartment(String fullName, int newDepartment) {
        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i].getFullname().equals(fullName)) {
                employeesArr[i].setDepartment(newDepartment);
            }
        }
    }

    public void printEachDepartmentEpmloyees() {
        System.out.println("Сотрудники 1 отдела: ");
        printDepartmentEmployeesNames(1);
        System.out.println();
        System.out.println("Сотрудники 2 отдела: ");
        printDepartmentEmployeesNames(2);
        System.out.println();
        System.out.println("Сотрудники 3 отдела: ");
        printDepartmentEmployeesNames(3);
        System.out.println();
        System.out.println("Сотрудники 4 отдела: ");
        printDepartmentEmployeesNames(4);
        System.out.println();
        System.out.println("Сотрудники 5 отдела: ");
        printDepartmentEmployeesNames(5);
    }
}