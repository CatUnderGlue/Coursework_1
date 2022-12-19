public class Main {
    public static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        initialiseEmployees();
        // ===========================================
        // =========== Базовая сложность ===========
        // ===========================================
        System.out.println("Базовая сложность");
        System.out.println();

        // Вывод всех работников
        System.out.println("Вывод всех работников");
        printAllEmployees();
        System.out.println();

        // Подсчёт суммы зарплат
        System.out.println("Подсчёт суммы зарплат");
        System.out.println(calculateSalaryCostsPerMonth());
        System.out.println();

        // Поиск минимальной зарплаты
        System.out.println("Поиск минимальной зарплаты");
        Employee minSalaryPerson = findMinSalaryPerson();
        System.out.println("id: " + minSalaryPerson.getId() + " " + minSalaryPerson.getFullName() + " " + "Salary: " + minSalaryPerson.getSalary());
        System.out.println();

        // Поиск максимальной зарплаты
        System.out.println("Поиск максимальной зарплаты");
        Employee maxSalaryPerson = findMaxSalaryPerson();
        System.out.println("id: " + maxSalaryPerson.getId() + " " + maxSalaryPerson.getFullName() + " " + "Salary: " + maxSalaryPerson.getSalary());
        System.out.println();

        // Подсчёт средней зарплаты
        System.out.println("Подсчёт средней зарплаты");
        System.out.println(calculateAverageSalary());
        System.out.println();

        // Печать всех ФИО сотрудников
        System.out.println("Печать всех ФИО сотрудников");
        printAllFullname();
        System.out.println();

        // ===============================================
        // =========== Повышенная сложность ===========
        // ===============================================
        System.out.println("Повышенная сложность");
        System.out.println();

        // Индексация зарплат
        System.out.println("Индексация зарплат");
        System.out.println("До: " + employees[0].getSalary());
        indexSalary(10);
        System.out.println("После: " + employees[0].getSalary());
        System.out.println();

        // Поиск минимальной зарплаты по отделу
        System.out.println("Поиск минимальной зарплаты по отделу");
        Employee minSalaryPersonByDep = findMinSalaryPersonByDep(2);
        System.out.println("id: " + minSalaryPersonByDep.getId() + " " + minSalaryPersonByDep.getFullName() + " " + "Salary: " + minSalaryPersonByDep.getSalary());
        System.out.println();

        // Поиск максимальной зарплаты по отделу
        System.out.println("Поиск максимальной зарплаты по отделу");
        Employee maxSalaryPersonByDep = findMaxSalaryPersonByDep(2);
        System.out.println("id: " + maxSalaryPersonByDep.getId() + " " + maxSalaryPersonByDep.getFullName() + " " + "Salary: " + maxSalaryPersonByDep.getSalary());
        System.out.println();

        // Подсчёт суммы зарплат по отделу
        System.out.println("Подсчёт суммы зарплат по отделу");
        System.out.println(calculateSalaryCostsPerMonthByDep(2));
        System.out.println();

        // Подсчёт средней зарплаты по отделу
        System.out.println("Подсчёт средней зарплаты по отделу");
        System.out.println(calculateAverageSalaryByDep(2));
        System.out.println();

        // Индексация зарплат по отделу
        System.out.println("Индексация зарплат по отделу");
        System.out.println("До: " + employees[6].getSalary());
        indexSalaryByDep(10, 2);
        System.out.println("После: " + employees[6].getSalary());
        System.out.println();

        // Вывод всех работников по отделу
        System.out.println("Вывод всех работников по отделу");
        printAllEmployeesByDep(2);
        System.out.println();

        // Вывод всех работников, чья зарплата меньше n
        System.out.println("Вывод всех работников, чья зарплата меньше n");
        printAllEmployeesWithSalaryLessThan(20_000);
        System.out.println();

        // Вывод всех работников, чья зарплата больше n
        System.out.println("Вывод всех работников, чья зарплата больше n");
        printAllEmployeesWithSalaryMoreThan(20_000);
        System.out.println();
    }

    public static void initialiseEmployees() {
        employees[0] = new Employee("Овчинников Михаил Кириллович", 1, 30_000);
        employees[1] = new Employee("Исаева Валерия Степановна", 1, 35_000);
        employees[2] = new Employee("Завьялов Пётр Артёмович", 2, 39_000);
        employees[3] = new Employee("Филиппова Маргарита Родионовна", 3, 45_000);
        employees[4] = new Employee("Колесникова Ульяна Егоровна", 5, 75_000);
        employees[5] = new Employee("Демин Роман Романович", 4, 25_000);
        employees[6] = new Employee("Артамонова Алия Данииловна", 2, 35_000);
        employees[7] = new Employee("Лебедев Евгений Андреевич", 1, 15_000);
        employees[8] = new Employee("Зубов Марк Ярославович", 3, 55_000);
        employees[9] = new Employee("Вдовина Анастасия Андреевна", 4, 15_000);
    }

    /*
    ===================================
            Базовая сложность
    ===================================
     */
    public static void printAllEmployees() {
        for (Employee employee : employees) {
            System.out.printf("id: %d FullName: %s Department: %d Salary: %d%n", employee.getId(), employee.getFullName(), employee.getDepartment(), employee.getSalary());
        }
    }

    public static int calculateSalaryCostsPerMonth() {
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public static Employee findMinSalaryPerson() {
        Employee person = employees[0];
        int min = findMaxSalaryPerson().getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() < min) {
                min = employee.getSalary();
                person = employee;
            }
        }
        return person;
    }

    public static Employee findMaxSalaryPerson() {
        int max = 0;
        Employee person = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > max) {
                max = employee.getSalary();
                person = employee;
            }
        }
        return person;
    }

    public static double calculateAverageSalary() {
        int salarySum = calculateSalaryCostsPerMonth();
        return (double) salarySum / employees.length;
    }

    public static void printAllFullname() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    /*
    ======================================
            Повышенная сложность
    ======================================
     */

    public static void indexSalary(int percent) {
        for (Employee employee : employees) {
            int salary = employee.getSalary();
            salary += (salary / 100) * percent;
            employee.setSalary(salary);
        }
    }

    public static Employee findMinSalaryPersonByDep(int department) {
        Employee person = employees[0];
        int min = findMaxSalaryPersonByDep(department).getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() < min && employee.getDepartment() == department) {
                min = employee.getSalary();
                person = employee;
            }
        }
        return person;
    }

    public static Employee findMaxSalaryPersonByDep(int department) {
        Employee person = employees[0];
        int max = 0;
        for (Employee employee : employees) {
            if (employee.getSalary() > max && employee.getDepartment() == department) {
                max = employee.getSalary();
                person = employee;
            }
        }
        return person;
    }

    public static int calculateSalaryCostsPerMonthByDep(int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public static double calculateAverageSalaryByDep(int department) {
        // Я не стал использовать выше созданную функцию, т.к. всё равно прохожу циклом по массиву,
        // чтобы подсчитать кол-во работников.
        int employeesCount = 0;
        int salarySum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                salarySum += employee.getSalary();
                employeesCount += 1;
            }
        }
        return (double) salarySum / employeesCount;
    }

    public static void indexSalaryByDep(int percent, int department) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                int salary = employee.getSalary();
                salary += (salary / 100) * percent;
                employee.setSalary(salary);
            }
        }
    }

    public static void printAllEmployeesByDep(int department) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department){
                System.out.printf("id: %d FullName: %s Salary: %d%n", employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }

    public static void printAllEmployeesWithSalaryLessThan(int nSalary){
        for (Employee employee : employees){
            if (employee.getSalary() < nSalary){
                System.out.printf("id: %d FullName: %s Salary: %d%n", employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }

    public static void printAllEmployeesWithSalaryMoreThan(int nSalary){
        for (Employee employee : employees){
            if (employee.getSalary() >= nSalary){
                System.out.printf("id: %d FullName: %s Salary: %d%n", employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }

}