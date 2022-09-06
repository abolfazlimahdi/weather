package abolfazli.mahdi.weather.entities;

public class HourlyEntity {

    private String hour;
    private int temperature;
    private String imageUrl;

    public HourlyEntity(String hour, int temperature, String imageUrl) {
        this.hour = hour;
        this.temperature = temperature;
        this.imageUrl = imageUrl;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
