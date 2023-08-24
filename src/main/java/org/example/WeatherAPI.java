package org.example;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

// declaration des variables d'instance
public class WeatherAPI {
    private String  apiKey;
    private String apiUrl;

    // constructeur de la class
    public WeatherAPI(String apiKey, String apiUrl){
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
    }

    // Méthode de recuperation des de donnée météo
    public WeatherData getWeatherData(String city) throws IOException, JSONException {
        // construction d'un url pour accéder aux données météo
        String urlString = apiUrl + "?q=" + city + "&appid=" + apiKey + "&units=metric";

        // création de l'objet URL et conexion a l'api
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.connect();

        // Vérification de la reponse de l'API
        int responseCode = conn.getResponseCode();
        if (responseCode != 200){
            throw new IOException("Échec de la récupération des données météorologiques "+ conn.getResponseMessage());
        }

        // Récupération des données de l'API
        Scanner scan = new Scanner(conn.getInputStream());
        StringBuilder response = new StringBuilder();
        while (scan.hasNextLine()) {
            response.append(scan.nextLine());
        }
        scan.close();
        conn.disconnect();

        //parsing des JSON pour obtenir les données que le veut afficher
        JSONObject jsonObject = new JSONObject(response.toString());
        double temperature = Double.parseDouble(String.valueOf(jsonObject.getJSONObject("main").getInt("temp")));
        double humidity = Double.parseDouble(String.valueOf(jsonObject.getJSONObject("main").getInt("humidity")));
        double presure = Double.parseDouble(String.valueOf(jsonObject.getJSONObject("main").getInt("pressure")));

        // Création d'un object WeatherData avec les données récupéré
        return new WeatherData(temperature, humidity, presure);
    }
}
