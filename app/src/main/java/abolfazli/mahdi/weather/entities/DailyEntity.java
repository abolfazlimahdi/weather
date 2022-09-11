package abolfazli.mahdi.weather.entities;

public class DailyEntity {
   private String day;
   private double maxTemp;
   private double minTemp;
   private String iconName;

    public DailyEntity(String day, double maxTemp, double minTemp, String iconName) {
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.iconName = iconName;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    @Override
    public String toString() {
        return "day: " + day + " maxTemp: " + maxTemp + " minTemp: " + minTemp +  " iconName: " + iconName;
    }
}
