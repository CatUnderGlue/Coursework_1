public class EmployeeBook {
    private final Employee[] employees;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    private boolean isEmployeeNull(Employee employee) {
        return employee == null;
    }

    public boolean isEmployeeExistsByFullname(String fullname) {
        boolean flag = false;
        for (Employee employee : employees) {
            if (!isEmployeeNull(employee) && employee.getFullName().equalsIgnoreCase(fullname)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /*
    ===================================
            Базовая сложность
    ===================================
     */
    public void printAllEmployees() {
        for (Employee employee : employees) {
            if (!isEmployeeNull(employee)) {
                System.out.println(employee);
            }
        }
    }

    public int calculateSalaryCostsPerMonth() {
        int sum = 0;
        for (Employee employee : employees) {
            if (!isEmployeeNull(employee)) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public Employee findMinSalaryPerson() {
        Employee person = employees[0];
        int min = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if (!isEmployeeNull(employee) && employee.getSalary() < min) {
                min = employee.getSalary();
                person = employee;
            }
        }
        return person;
    }

    public Employee findMaxSalaryPerson() {
        int max = 0;
        Employee person = employees[0];
        for (Employee employee : employees) {
            if (!isEmployeeNull(employee) && employee.getSalary() > max) {
                max = employee.getSalary();
                person = employee;
            }
        }
        return person;
    }

    public double calculateAverageSalary() {
        int salarySum = calculateSalaryCostsPerMonth();
        int count = 0;
        for (Employee employee : employees) {
            if (!isEmployeeNull(employee)) {
                count++;
            }
        }
        return (double) salarySum / count;
    }

    public void printAllFullname() {
        for (Employee employee : employees) {
            if (!isEmployeeNull(employee)) {
                System.out.println(employee.getFullName());
            }
        }
    }

    /*
    ======================================
            Повышенная сложность
    ======================================
     */

    public void indexSalary(int percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                int salary = employee.getSalary();
                salary += (salary / 100) * percent;
                employee.setSalary(salary);
            }
        }
    }

    public Employee findMinSalaryPersonByDep(int department) {
        Employee person = employees[0];
        int min = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if (!isEmployeeNull(employee) && employee.getSalary() < min && employee.getDepartment() == department) {
                min = employee.getSalary();
                person = employee;
            }
        }
        return person;
    }

    public Employee findMaxSalaryPersonByDep(int department) {
        Employee person = employees[0];
        int max = 0;
        for (Employee employee : employees) {
            if (!isEmployeeNull(employee) && employee.getSalary() > max && employee.getDepartment() == department) {
                max = employee.getSalary();
                person = employee;
            }
        }
        return person;
    }

    public int calculateSalaryCostsPerMonthByDep(int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (!isEmployeeNull(employee) && employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public double calculateAverageSalaryByDep(int department) {
        // Я не стал использовать выше созданную функцию, т.к. всё равно прохожу циклом по массиву,
        // чтобы подсчитать кол-во работников.
        int employeesCount = 0;
        int salarySum = 0;
        for (Employee employee : employees) {
            if (!isEmployeeNull(employee) && employee.getDepartment() == department) {
                salarySum += employee.getSalary();
                employeesCount += 1;
            }
        }
        return (double) salarySum / employeesCount;
    }

    public void indexSalaryByDep(int percent, int department) {
        for (Employee employee : employees) {
            if (!isEmployeeNull(employee) && employee.getDepartment() == department) {
                int salary = employee.getSalary();
                salary += (salary / 100) * percent;
                employee.setSalary(salary);
            }
        }
    }

    public void printAllEmployeesByDep(int department) {
        for (Employee employee : employees) {
            if (!isEmployeeNull(employee) && employee.getDepartment() == department) {
                System.out.printf("id: %d FullName: %s Salary: %d%n", employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }

    public void printAllEmployeesWithSalaryLessThan(int nSalary) {
        for (Employee employee : employees) {
            if (!isEmployeeNull(employee) && employee.getSalary() < nSalary) {
                System.out.printf("id: %d FullName: %s Salary: %d%n", employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }

    public void printAllEmployeesWithSalaryMoreThan(int nSalary) {
        for (Employee employee : employees) {
            if (!isEmployeeNull(employee) && employee.getSalary() >= nSalary) {
                System.out.printf("id: %d FullName: %s Salary: %d%n", employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }

        /*
    =========================================
            Максимальная сложность
    =========================================
     */

    public void addEmployee(String fullname, int department, int salary) {
        Employee newEmployee = new Employee(fullname, department, salary);
        int count = 0;
        for (Employee employee : employees) {
            if (isEmployeeNull(employee)){
                count++;
            }
        }
        if (count == 0){
            throw new RuntimeException("Нет свободных мест");
        }
        for (int i = 0; i < employees.length; i++) {
            if (isEmployeeNull(employees[i])) {
                employees[i] = newEmployee;
                break;
            }
        }
    }

    public void removeEmployee(int id) {
        employees[id] = null;
    }

    public void removeEmployee(String fullname) {
        if (isEmployeeExistsByFullname(fullname)) {
            for (int i = 0; i < employees.length; i++) {
                if (!isEmployeeNull(employees[i]) && employees[i].getFullName().equalsIgnoreCase(fullname)) {
                    employees[i] = null;
                }
            }
        } else {
            throw new IllegalArgumentException("Указанный работник не найден");
        }
    }

    public void setEmployeeSalaryByFullname(String fullname, int salary) {
        if (isEmployeeExistsByFullname(fullname)) {
            for (Employee employee : employees) {
                if (!isEmployeeNull(employee) && employee.getFullName().equalsIgnoreCase(fullname)) {
                    employee.setSalary(salary);
                }
            }
        } else {
            throw new IllegalArgumentException("Указанный работник не найден");
        }
    }

    public void setEmployeeDepartmentByFullname(String fullname, int department) {
        if (isEmployeeExistsByFullname(fullname)) {
            for (Employee employee : employees) {
                if (!isEmployeeNull(employee) && employee.getFullName().equalsIgnoreCase(fullname)) {
                    employee.setDepartment(department);
                }
            }
        } else {
            throw new IllegalArgumentException("Указанный работник не найден");
        }
    }

    public void printAllEmployeesSortByDep() {
        String separator = "=================";
        System.out.println(separator);
        for (int i = 1; i <= 5; i++) {
            System.out.println("Отдел №" + i);
            for (Employee employee : employees) {
                if (!isEmployeeNull(employee)) {
                    if (employee.getDepartment() == i) {
                        System.out.println(employee.getFullName());
                    }
                }
            }
            System.out.println(separator);
        }
    }
}
