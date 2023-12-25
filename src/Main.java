public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee("Огурцова Лариса Ивановна", 2, 110000);
        employeeBook.addEmployee("Викторова Анна Сергеевнв", 1, 85000);
        employeeBook.addEmployee("Сергеева Лариса Алексанровна", 1, 63000);
        employeeBook.addEmployee("Степанова Марина Петровна", 3, 90000);
        employeeBook.addEmployee("Вискон Мария Антоновна", 1, 83000);
        employeeBook.addEmployee("Бурн Тамара Витальевна", 3, 96000);
        employeeBook.addEmployee("Даугерт Инна Александровна", 4, 87000);
        employeeBook.addEmployee("Степаненко Ирина Федоровна", 5, 52000);
        employeeBook.addEmployee("Березкина Наталья Владимировна", 1, 85000);
        employeeBook.addEmployee("Верна Зарина Евгеньевна", 2, 98000);

        employeeBook.printAllEmployeesInfo();
        employeeBook.printAllEmployeesName();



        System.out.println("Сотрудник с минимальной зарплатой: " + employeeBook.minimalEmployeeSalary());
        System.out.println("Сотрудник с максимальной зарплатой: " + employeeBook.maximalEmployeeSalary());
        System.out.println("Затраты на зарплаты: " + employeeBook.calcSalaryCosts());
        System.out.println("Средняя зарплата составляет: " + employeeBook.calcAverageSalary());
        employeeBook.printAllEmployeesName();


        System.out.println("Сотрудник с минимальной зарплатой : " + employeeBook.getDepartmentMinSalaryEmployee(1));
        System.out.println("Сотрудник с максимальной зарплатой : " + employeeBook.getDepartmentMaxSalaryEmployee(2));
        System.out.println("Сумма затрат на зарплату по отделу: " + employeeBook.getCostDepartmentSalary(4));
        employeeBook.printIncreaseDepartmentSalary(1, 10);
        employeeBook.printDepartmentEmployeesNames(1);
        employeeBook.printIsSalaryBigger(30000);
        employeeBook.changeEmployeeSalary("Огурцова Лариса Ивановна", 39000);
        employeeBook.printEachDepartmentEpmloyees();
        employeeBook.printAverageSalaryPerDepartment();
        employeeBook.removeEmployeeId(1);

    }
}
