package final_project_oop;

import java.util.Random;

public class Company {

    private final Random random;
    private final String nameCompany;
    private final double maxSalary;
    private final Publisher jobAgency;

    public Company(String nameCompany, double maxSalary, Publisher jobAgency) {
        this.nameCompany = nameCompany;
        this.maxSalary = maxSalary;
        this.jobAgency = jobAgency;
        random = new Random();
    }

    public void newVacancy(){
        JobType[] jobTypes = JobType.values();
        JobType randomJobType = jobTypes[random.nextInt(jobTypes.length)];

        double salary = random.nextDouble(3000, maxSalary);
        Vacancy newVacancy = new Vacancy(salary, nameCompany, randomJobType);
        jobAgency.sendOffer(newVacancy);

    }

}
