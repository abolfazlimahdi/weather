package abolfazli.mahdi.weather.entities;

public class ThreeHourEntity {

    private String hour;
    private double temperature;
    private String iconName;

    public ThreeHourEntity() {
    }

    public ThreeHourEntity(String hour, double temperature, String iconName) {
        this.hour = hour;
        this.temperature = temperature;
        this.iconName = iconName;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public double getTemperature() {

        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }


    @Override
    public String toString() {
        return this.hour + " " + this.temperature + " " + this.iconName;
    }
}
