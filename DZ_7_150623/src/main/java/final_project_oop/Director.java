package final_project_oop;

public class Director implements Observer {

    private final String name;
    private double salary;

    public Director(String name) {
        this.name = name;
        salary = 100000;
    }

    @Override
    public void receiveOffer(Vacancy vacancy) {
        if (vacancy.getJobType() == JobType.MANAGER) {
            if (this.salary < vacancy.getSalary()) {
                System.out.printf("Директор %s >>> Мне нужна эта работа! [%s - %s - %.2f]\n", name, vacancy.getCompanyName(), vacancy.getJobType(), vacancy.getSalary());
                this.salary = vacancy.getSalary();
            } else System.out.printf("Директор %s >>> У меня есть предложение получше! [%s - %s - %.2f]\n", name, vacancy.getCompanyName(), vacancy.getJobType(), vacancy.getSalary());
        } else System.out.printf("Директор %s >>> Мне не подходит эта вакансия! [%s - %s - %.2f]\n", name, vacancy.getCompanyName(), vacancy.getJobType(), vacancy.getSalary());
    }
}
