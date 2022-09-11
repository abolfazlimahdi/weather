package abolfazli.mahdi.weather.entities;

public class CurrentWeatherEntity {

    private String cityName;
    private double temperature;
    private String generalCondition;
    private int humidity;
    private int pressure;
    private double windSpeed;
    private String image;

    public CurrentWeatherEntity(String cityName, double temperature, String generalCondition, int humidity, int pressure, double windSpeed, String image) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.generalCondition = generalCondition;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.image = image;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getGeneralCondition() {
        return generalCondition;
    }

    public void setGeneralCondition(String generalCondition) {
        this.generalCondition = generalCondition;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
