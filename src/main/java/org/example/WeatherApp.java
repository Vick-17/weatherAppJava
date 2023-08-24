package org.example;

import org.json.JSONException;

import java.io.IOException;

public class WeatherApp {
    public static void main(String[] args) {
        // création d'une instance de WeatherAPI avec une clé et url d'api
        WeatherAPI weatherAPI = new WeatherAPI("88ead73c4d004f30e1fc5d64532c320f", "https://api.openweathermap.org/data/2.5/weather");
        // Création d'une instance de weatherDisplay
        WeatherDisplay weatherDisplay = new WeatherDisplay();
        try{
            // Récupération des données météo pour choisis
            WeatherData weatherData = weatherAPI.getWeatherData("Paris");
            // Mise a jour de l'objet WeatherData de WeatherDisplay avec les données météo recupérer
            weatherDisplay.setWeatherData(weatherData);
            // Affichage des météo actuelle avec WeatherDisplay
            weatherDisplay.displayCurentWeather();
        } catch (IOException e) {
            //Gestion des erreur lors de la recupération des données
            System.err.println("Pas trouver la data " + e.getMessage());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
