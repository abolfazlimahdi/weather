package abolfazli.mahdi.weather.entities;

public class DailyEntity {
   private String day;
   private int maxTemp;
   private int minTemp;
   private String imageUrl;

    public DailyEntity(String day, int maxTemp, int minTemp, String imageUrl) {
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.imageUrl = imageUrl;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
