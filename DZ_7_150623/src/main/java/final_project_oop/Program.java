package final_project_oop;

public class Program {

    public static void main(String[] args) {
        JobAgency jobAgency = new JobAgency();
        Company geekBrains = new Company("GeekBrains", 70000, jobAgency);
        Company google = new Company("Google", 100000, jobAgency);
        Company yandex = new Company("Yandex", 120000, jobAgency);

        Master ivanov = new Master("Ivanov");
        Master sidorov = new Master("Sidorov");
        Student petrov = new Student("Petrov");
        Student taranov = new Student("Taranov");
        Director kochanov = new Director("Kochanov");
        Director chirikov = new Director("Chirikov");


        jobAgency.registerObserver(ivanov);
        jobAgency.registerObserver(sidorov);
        jobAgency.registerObserver(petrov);
        jobAgency.registerObserver(taranov);
        jobAgency.registerObserver(kochanov);
        jobAgency.registerObserver(chirikov);

        for (int i = 0; i < 10; i++){
            geekBrains.newVacancy();
            google.newVacancy();
            yandex.newVacancy();
            System.out.println();
        }

    }

}
