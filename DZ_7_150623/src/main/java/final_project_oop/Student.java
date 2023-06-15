package final_project_oop;

public class Student implements Observer {

    private final String name;
    private double salary;

    public Student(String name) {
        this.name = name;
        salary = 5000;
    }

    @Override
    public void receiveOffer(Vacancy vacancy) {
        if (vacancy.getJobType() == JobType.JUNIOR) {
            if (this.salary < vacancy.getSalary()) {
                System.out.printf("Студент %s >>> Мне нужна эта работа! [%s - %s - %.2f]\n", name, vacancy.getCompanyName(), vacancy.getJobType(), vacancy.getSalary());
                this.salary = vacancy.getSalary();
            } else System.out.printf("Студент %s >>> У меня есть предложение получше! [%s - %s - %.2f]\n", name, vacancy.getCompanyName(), vacancy.getJobType(), vacancy.getSalary());
        } else System.out.printf("Студент %s >>> Мне не подходит эта вакансия! [%s - %s - %.2f]\n", name, vacancy.getCompanyName(), vacancy.getJobType(), vacancy.getSalary());
    }
}