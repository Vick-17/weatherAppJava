package org.example;

public class WeatherData {
    // declaration des vairiables d'instance
    private double temperature;
    private double humidity;
    private double pressure;

    // constructeur de la class
    public WeatherData(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    // get retourne un objetc
    public double getTemperature() {
        return temperature;
    }

    //set mes a jour un objet
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }
}
