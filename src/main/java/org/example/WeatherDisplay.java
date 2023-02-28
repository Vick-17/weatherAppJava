package org.example;

public class WeatherDisplay {
    private WeatherData weatherData;

    // Méthode pour afficher la météo actuelle
    public void displayCurentWeather() {
        System.out.println("temperature " + weatherData.getTemperature() + "°c");
        System.out.println("humidity " + weatherData.getHumidity() + "%");
        System.out.println("pressure " + weatherData.getPressure() + "hPa");
    }
/*    public void displayShortTermForecast(){

    }

    public void displayLongTermForecast() {

    }
    public void displayMaps() {

    }*/

    // Setter pour la propriété weatherData
    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }
}
