package final_project_oop;

public interface Publisher {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void sendOffer(Vacancy vacancy);

}
