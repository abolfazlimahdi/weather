package abolfazli.mahdi.weather.entities;

public class FavoriteEntity {

    private int temperature;
    private String city;
    private String country;
    private int windSpeed;
    private int humidity;

    public FavoriteEntity(int temperature, String city, String country, int windSpeed, int humidity) {
        this.temperature = temperature;
        this.city = city;
        this.country = country;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
    }


    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
