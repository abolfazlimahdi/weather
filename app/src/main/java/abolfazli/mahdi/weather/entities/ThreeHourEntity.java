package abolfazli.mahdi.weather.entities;

public class ThreeHourEntity {

    private long timestamp;
    private String hour;
    private String weekDay;
    private double temperature;
    private String iconName;

    public ThreeHourEntity() {
    }

    public ThreeHourEntity(long timestamp, String hour, String weekDay, double temperature, String iconName) {
        this.timestamp = timestamp;
        this.hour = hour;
        this.weekDay = weekDay;
        this.temperature = temperature;
        this.iconName = iconName;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
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
