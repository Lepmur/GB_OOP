package final_project_oop;

public class Master implements Observer {
    private final String name;
    private double salary;

    public Master(String name) {
        this.name = name;
        salary = 80000;
    }

    @Override
    public void receiveOffer(Vacancy vacancy) {
        if (vacancy.getJobType() == JobType.SENIOR) {
            if (this.salary < vacancy.getSalary()) {
                System.out.printf("Мастер %s >>> Мне нужна эта работа! [%s - %s - %.2f]\n", name, vacancy.getCompanyName(), vacancy.getJobType(), vacancy.getSalary());
                this.salary = vacancy.getSalary();
            } else System.out.printf("Мастер %s >>> У меня есть предложение получше! [%s - %s - %.2f]\n", name, vacancy.getCompanyName(), vacancy.getJobType(), vacancy.getSalary());
        } else System.out.printf("Мастер %s >>> Мне не подходит эта вакансия! [%s - %s - %.2f]\n", name, vacancy.getCompanyName(), vacancy.getJobType(), vacancy.getSalary());
    }
}
