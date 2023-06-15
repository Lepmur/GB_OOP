package ru.geekbrains.lesson7.adapter;

import java.time.LocalDateTime;

public class AdapterST500Info implements MeteoSensorSimple {

    private SensorTemperature sensorTemperature;

    public AdapterST500Info(SensorTemperature sensorTemperature){
        this.sensorTemperature = sensorTemperature;
    }


    @Override
    public int getId() {
        return sensorTemperature.identifier();
    }

    @Override
    public double getTemperature() {
        return sensorTemperature.temperature();
    }

    /*@Override
    public double getHumidity() {
        throw new RuntimeException("Not implemented.");
    }

    @Override
    public double getPressure() {
        throw new RuntimeException("Not implemented.");
    }

    @Override
    public LocalDateTime getDateTime() {
        throw new RuntimeException("Not implemented.");
    }*/
}
