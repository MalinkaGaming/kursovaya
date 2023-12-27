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
        System.out.println();
        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i] != null && employeesArr[i].getFullname().equals(fullName)) {
                employeesArr[i] = null;
                break;
            }
        }
    }

    public void removeEmployeeId(int id) {
        System.out.println();
        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i] != null && employeesArr[i].getId() == id) {
                for (int j = i; j < employeesArr.length - 1; j++) {
                    employeesArr[j] = employeesArr[j + 1];
                }
                employeesArr[employeesArr.length - 1] = null;
                break;
            }
        }
    }

    public void printAllEmployeesInfo() {
        System.out.println();
        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i] != null) {
                System.out.println(employeesArr[i]);
            } else {
                System.out.println("Employee at index " + i + " is null");
            }
        }
    }


    public void printAllEmployeesName() {
        System.out.println();
        System.out.println("Имена всех сотрудников:");
        for (Employee employee : employeesArr) {
            if (employee != null) {
                System.out.println(employee.getFullname());
            }
        }
    }

    public double calcAverageSalary() {
        System.out.println();
        int sum = 0;
        int numberOfEmployees = 0;

        for (Employee employee : employeesArr) {
            if (employee != null) {
                sum += employee.getSalary();
                numberOfEmployees++;
            }
        }
        if (numberOfEmployees == 0) {
            return 0.0;
        }
        double averageSalary = (double) sum / numberOfEmployees;
        return averageSalary;
    }

    public int calcSalaryCosts() {
        System.out.println();
        int sum = 0;
        for (Employee employee : employeesArr) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public Employee minimalEmployeeSalary() {
        System.out.println();
        Employee minimalSalaryEmployeer = findFirstNonNullEmployee();
        if (minimalSalaryEmployeer == null) {
            return null;
        }

        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i] != null && employeesArr[i].getSalary() < minimalSalaryEmployeer.getSalary()) {
                minimalSalaryEmployeer = employeesArr[i];
            }
        }
        return minimalSalaryEmployeer;
    }

    public Employee maximalEmployeeSalary() {
        System.out.println();
        Employee maximalSalaryEmployeer = findFirstNonNullEmployee();
        if (maximalSalaryEmployeer == null) {
            return null;
        }

        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i] != null && employeesArr[i].getSalary() > maximalSalaryEmployeer.getSalary()) {
                maximalSalaryEmployeer = employeesArr[i];
            }
        }
        return maximalSalaryEmployeer;
    }
    private Employee findFirstNonNullEmployee() {
        System.out.println();
        for (Employee employee : employeesArr) {
            if (employee != null) {
                return employee;
            }
        }
        return null;
    }

    public void increaseSalary(int increment) {
        System.out.println();
        Employee firstNonNullEmployee = findFirstNonNullEmployee();
        if (firstNonNullEmployee == null) {
            System.out.println("Нет сотрудников для индексации зарплат.");
            return;
        }

        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i] != null) {
                int salaryIncrease = (employeesArr[i].getSalary() * increment / 100) + employeesArr[i].getSalary();
                employeesArr[i].setSalary(salaryIncrease);
                System.out.println("Зарплата " + employeesArr[i].getFullname() + " после индексации стала: " + employeesArr[i].getSalary());
            }
        }
    }

    public Employee getDepartmentMinSalaryEmployee(int department) {
        System.out.println();
        Employee minSalaryEmployee = findFirstNonNullEmployee();
        if (minSalaryEmployee == null) {
            System.out.println("Нет сотрудников в отделе.");
            return null;
        }

        for (Employee employee : employeesArr) {
            if (employee != null && employee.getDepartment() == department && employee.getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }

        return minSalaryEmployee;
    }

    public Employee getDepartmentMaxSalaryEmployee(int department) {
        System.out.println();
        Employee maxSalaryEmployee = null;
        int maxSalary = Integer.MIN_VALUE;

        for (Employee employee : employeesArr) {
            if (employee != null && employee.getDepartment() == department && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                maxSalaryEmployee = employee;
            }
        }

        return maxSalaryEmployee;
    }

    public double getCostDepartmentSalary(int department) {
        System.out.println();
        int sum = 0;
        for (Employee employee : employeesArr) {
            if (employee != null && employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public void printIncreaseDepartmentSalary(int department, int increment) {
        System.out.println();
        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i] != null && employeesArr[i].getDepartment() == department) {
                int salaryIncrease = (int) (employeesArr[i].getSalary() * (1 + increment / 100.0));
                employeesArr[i].setSalary(salaryIncrease);
                System.out.println("Зарплата сотрудника " + employeesArr[i].getFullname() + " в отделе " +
                        department + " после индексации: " + employeesArr[i].getSalary());
            }
        }
    }

    public void printDepartmentEmployeesNames(int department) {
        System.out.println();
        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i] != null && employeesArr[i].getDepartment() == department) {
                System.out.println("id: " + employeesArr[i].getId() + " ФИО: " + employeesArr[i].getFullname() + " Зарплата: " + employeesArr[i].getSalary());
            }
        }
    }

    public void printIsSalaryBelow(int number) {
        System.out.println();
        System.out.println("Сотрудники, чья зарплата ниже числа: ");
        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i] != null && employeesArr[i].getSalary() < number) {
                System.out.println(employeesArr[i].getId() + " " + employeesArr[i].getFullname() + " " + employeesArr[i].getSalary());
            }
        }
    }

    public void printIsSalaryBigger(int number) {
        System.out.println();
        System.out.println("Сотрудники, чья зарплата выше или равна числу: ");
        for (Employee employee : employeesArr) {
            if (employee != null && employee.getSalary() >= number) {
                System.out.println(employee.getId() + " " + employee.getFullname() + " " + employee.getSalary());
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
        System.out.println();
        for (int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i] != null && employeesArr[i].getFullname().equals(fullName)) {
                employeesArr[i].setSalary(newSalary);
                System.out.println("Зарплата сотрудника " + fullName + " изменена на: " + newSalary);
                break;
            }
        }
    }

    public void printAverageSalaryPerDepartment() {
        for (int department = 1; department <= 5; department++) {
            double averageSalary = calcAverageSalaryByDepartment(department);
            System.out.println("Средняя зарплата в отделе " + department + ": " + averageSalary);
        }
    }

    public double calcAverageSalaryByDepartment(int department) {
        int sum = 0;
        int numberOfEmployees = 0;

        for (Employee employee : employeesArr) {
            if (employee != null && employee.getDepartment() == department) {
                sum += employee.getSalary();
                numberOfEmployees++;
            }
        }

        if (numberOfEmployees == 0) {
            return 0.0;
        }

        return (double) sum / numberOfEmployees;
    }

    public void printEachDepartmentEpmloyees() {
        for (int department = 1; department <= 5; department++) {
            System.out.println("Сотрудники " + department + " отдела: ");
            printDepartmentEmployeesNames(department);
            System.out.println();
        }
    }
}