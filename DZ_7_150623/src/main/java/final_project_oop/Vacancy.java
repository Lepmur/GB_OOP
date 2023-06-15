package final_project_oop;

public class Vacancy {
    private double salary;
    private String companyName;
    private JobType jobType;

    public Vacancy(double salary, String companyName, JobType jobType) {
        this.salary = salary;
        this.companyName = companyName;
        this.jobType = jobType;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }
}