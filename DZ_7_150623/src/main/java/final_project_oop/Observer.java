package final_project_oop;

/**
 * Интерфейс наблюдателя (соискателя, человек в поисках работы)
 */
public interface Observer {

    void receiveOffer(Vacancy vacancy);

}
