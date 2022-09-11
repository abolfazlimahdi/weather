package abolfazli.mahdi.weather.utils;

public class NumberUtils {

    public static String decorateTemperature(double temperature) {
        int roundTemperature = (int) Math.round(temperature);
        return roundTemperature + " " + '\u2103';
    }

    public static String decorateWindSpeed(double windSpeed) {
        int roundWindSpeed = (int) Math.round(windSpeed * 3.6);
        return roundWindSpeed + " km/h";
    }
}
