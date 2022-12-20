public class Main {
    public static EmployeeBook employeeBook = new EmployeeBook();

    public static void main(String[] args) {
        // =========================================
        //        Максимальная сложность
        // =========================================
        initialiseEmployees();

        // ===========================================
        // =========== Базовая сложность ===========
        // ===========================================
        System.out.println("Базовая сложность");
        System.out.println();

        // Вывод всех работников
        System.out.println("Вывод всех работников");
        employeeBook.printAllEmployees();
        System.out.println();

        // Подсчёт суммы зарплат
        System.out.println("Подсчёт суммы зарплат");
        System.out.println(employeeBook.calculateSalaryCostsPerMonth());
        System.out.println();

        // Поиск минимальной зарплаты
        System.out.println("Поиск минимальной зарплаты");
        System.out.println(employeeBook.findMinSalaryPerson());
        System.out.println();

        // Поиск максимальной зарплаты
        System.out.println("Поиск максимальной зарплаты");
        System.out.println(employeeBook.findMaxSalaryPerson());
        System.out.println();

        // Подсчёт средней зарплаты
        System.out.println("Подсчёт средней зарплаты");
        System.out.println(employeeBook.calculateAverageSalary());
        System.out.println();

        // Печать всех ФИО сотрудников
        System.out.println("Печать всех ФИО сотрудников");
        employeeBook.printAllFullname();
        System.out.println();

        // ===============================================
        // =========== Повышенная сложность ===========
        // ===============================================
        System.out.println("Повышенная сложность");
        System.out.println();

        // Индексация зарплат
        System.out.println("Индексация зарплат");
        employeeBook.indexSalary(10);
        System.out.println();

        // Поиск минимальной зарплаты по отделу
        System.out.println("Поиск минимальной зарплаты по отделу");
        System.out.println(employeeBook.findMinSalaryPersonByDep(2));
        System.out.println();

        // Поиск максимальной зарплаты по отделу
        System.out.println("Поиск максимальной зарплаты по отделу");
        System.out.println(employeeBook.findMaxSalaryPersonByDep(2));
        System.out.println();

        // Подсчёт суммы зарплат по отделу
        System.out.println("Подсчёт суммы зарплат по отделу");
        System.out.println(employeeBook.calculateSalaryCostsPerMonthByDep(2));
        System.out.println();

        // Подсчёт средней зарплаты по отделу
        System.out.println("Подсчёт средней зарплаты по отделу");
        System.out.println(employeeBook.calculateAverageSalaryByDep(2));
        System.out.println();

        // Индексация зарплат по отделу
        System.out.println("Индексация зарплат по отделу");
        employeeBook.indexSalaryByDep(10, 2);
        System.out.println();

        // Вывод всех работников по отделу
        System.out.println("Вывод всех работников по отделу");
        employeeBook.printAllEmployeesByDep(2);
        System.out.println();

        // Вывод всех работников, чья зарплата меньше n
        System.out.println("Вывод всех работников, чья зарплата меньше n");
        employeeBook.printAllEmployeesWithSalaryLessThan(20_000);
        System.out.println();

        // Вывод всех работников, чья зарплата больше n
        System.out.println("Вывод всех работников, чья зарплата больше n");
        employeeBook.printAllEmployeesWithSalaryMoreThan(20_000);
        System.out.println();

        // =========================================
        //        Максимальная сложность
        // =========================================

        System.out.println("Максимальная сложность");
        System.out.println();

        // Удаление сотрудника
        System.out.println("Удаление сотрудника");
        employeeBook.removeEmployee(0);
        System.out.println();

        // Изменение зарплаты сотрудника по ФИО
        System.out.println("Изменение зарплаты сотрудника по ФИО");
        employeeBook.setEmployeeSalaryByFullname("Исаева Валерия Степановна", 100_000);
        System.out.println();

        // Изменение отдела сотрудника по ФИО
        System.out.println("Изменение отдела сотрудника по ФИО");
        employeeBook.setEmployeeDepartmentByFullname("Исаева Валерия Степановна", 2);
        System.out.println();

        // Вывод всех сотрудников отсортированный по отделам
        System.out.println("Вывод всех сотрудников отсортированный по отделам");
        employeeBook.printAllEmployeesSortByDep();

    }

    public static void initialiseEmployees(){
        employeeBook.addEmployee("Исаева Валерия Степановна", 1, 35_000);
        employeeBook.addEmployee("Завьялов Пётр Артёмович", 2, 39_000);
        employeeBook.addEmployee("Филиппова Маргарита Родионовна", 3, 45_000);
        employeeBook.addEmployee("Колесникова Ульяна Егоровна", 5, 75_000);
        employeeBook.addEmployee("Демин Роман Романович", 4, 25_000);
        employeeBook.addEmployee("Артамонова Алия Данииловна", 2, 35_000);
        employeeBook.addEmployee("Лебедев Евгений Андреевич", 1, 15_000);
        employeeBook.addEmployee("Зубов Марк Ярославович", 3, 55_000);
        employeeBook.addEmployee("Вдовина Анастасия Андреевна", 4, 15_000);
        employeeBook.addEmployee("Овчинников Михаил Кириллович", 1, 30_000);
    }

}