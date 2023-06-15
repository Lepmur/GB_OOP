package ru.geekbrains.lesson7.adapter;

public class MeteoStore {

    boolean save(MeteoSensor meteoSensor){
        System.out.printf("Сохранение данных по метеодатчику\n[%d]; temperature - %f\n", meteoSensor.getId(), meteoSensor.getTemperature());
        return true;
    }

    boolean save(MeteoSensorSimple meteoSensor){
        System.out.printf("Сохранение данных по метеодатчику\n[%d]; temperature - %f\n", meteoSensor.getId(), meteoSensor.getTemperature());
        return true;
    }

}
