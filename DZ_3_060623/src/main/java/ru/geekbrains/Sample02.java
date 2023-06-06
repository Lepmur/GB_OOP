package ru.geekbrains;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Sample02 {

    private static final Random random = new Random();

    static Object generateEmployee(){
        String[] maleNames = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] maleSurnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };

        String[] femaleNames = new String[] { "Анна", "Мария", "Екатерина", "София", "Александра", "Виктория", "Елена", "Алиса", "Ксения", "Дарья" };
        String[] femaleSurnames = new String[] { "Иванова", "Смирнова", "Кузнецова", "Попова", "Васильева", "Петрова", "Соколова", "Михайлова", "Фёдорова", "Лебедева" };

        Employee.Gender gender = random.nextBoolean() ? Employee.Gender.Man : Employee.Gender.Women;
        String name = gender == Employee.Gender.Man ? maleNames[random.nextInt(10)] : femaleNames[random.nextInt(10)];
        String surname = gender == Employee.Gender.Man ? maleSurnames[random.nextInt(10)] : femaleSurnames[random.nextInt(10)];

        if (random.nextBoolean())
            return new Worker(name, surname, gender, random.nextInt(18, 55),
                    random.nextInt(800, 1000) * random.nextInt(30, 50));
        else
            return new Freelancer(name, surname, gender, random.nextInt(18, 55),
                    random.nextInt(10, 20) * random.nextInt(20, 30));
    }

    public static void main(String[] args) {

        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++)
            employees[i] = (Employee)generateEmployee();

        Arrays.sort(employees);
        System.out.print("\n*** Сортировка по умолчанию (по фамилии) ***\n\n");
        System.out.printf("%-15s %-15s %-10s %-10s %-10s\n","Фамилия", "Имя", "Пол", "Возраст", "Зарплата");
        System.out.println("-----------------------------------------------------------");
        for (Employee employee : employees)
            System.out.println(employee);

        Arrays.sort(employees, new NameComparator());
        System.out.print("\n*** Сортировка по имени ***\n\n");
        System.out.printf("%-15s %-15s %-10s %-10s %-10s\n","Фамилия", "Имя", "Пол", "Возраст", "Зарплата");
        System.out.println("-----------------------------------------------------------");
        for (Employee employee : employees)
            System.out.println(employee);

        Arrays.sort(employees, new GenderComparator());
        System.out.print("\n*** Сортировка по полу ***\n\n");
        System.out.printf("%-15s %-15s %-10s %-10s %-10s\n","Фамилия", "Имя", "Пол", "Возраст", "Зарплата");
        System.out.println("-----------------------------------------------------------");
        for (Employee employee : employees)
            System.out.println(employee);

        Arrays.sort(employees, new AgeComparator());
        System.out.print("\n*** Сортировка по возрасту ***\n\n");
        System.out.printf("%-15s %-15s %-10s %-10s %-10s\n","Фамилия", "Имя", "Пол", "Возраст", "Зарплата");
        System.out.println("-----------------------------------------------------------");
        for (Employee employee : employees)
            System.out.println(employee);

        Arrays.sort(employees, new SalaryComparator());
        System.out.print("\n*** Сортировка по зарплате ***\n\n");
        System.out.printf("%-15s %-15s %-10s %-10s %-10s\n","Фамилия", "Имя", "Пол", "Возраст", "Зарплата");
        System.out.println("-----------------------------------------------------------");
        for (Employee employee : employees)
            System.out.println(employee);
    }
}

abstract class Employee implements Comparable<Employee>{

    protected String name;
    protected String surName;
    protected Gender gender;
    protected Integer age;
    protected double salary;

    public Employee(String name, String surName, Gender gender, Integer age, double salary) {
        this.name = name;
        this.surName = surName;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
    }

    public int compareTo(Employee o) {
        int result = this.surName.compareTo(o.surName);
        if (result == 0) {
            result = Double.compare(this.calculateSalary(), o.calculateSalary());
        }
        return result;
    }

    public enum Gender {
        Man,
        Women
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s; %s; %s лет; З/п: %.2f", name, surName, gender, age, salary);
    }
}

class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        int res = o1.name.compareTo(o2.name);
        if (res == 0){
            res = Double.compare( o2.calculateSalary(), o1.calculateSalary());
        }
        return res;
    }
}

class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.calculateSalary(), o2.calculateSalary());
    }
}

class AgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.age, o2.age);
    }
}

class GenderComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.gender.compareTo(o2.gender);
    }
}

class Worker extends Employee{

    public Worker(String name, String surName, Gender gender, Integer age, double salary) {
        super(name, surName, gender, age, salary);
    }

    @Override
    public double calculateSalary() {
        return salary ;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %-10s %-10s %.2f",surName, name, gender, age, calculateSalary());
    }
}

class Freelancer extends Employee{

    public Freelancer(String name, String surName, Gender gender, Integer age, double salary) {
        super(name, surName, gender, age, salary);
    }

    @Override
    public double calculateSalary() {
        return 20 * 5 * salary;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %-10s %-10s %.2f",surName, name, gender, age, calculateSalary());
    }
}
