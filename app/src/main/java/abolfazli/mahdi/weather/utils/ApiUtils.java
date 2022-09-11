package abolfazli.mahdi.weather.utils;

public class ApiUtils {
    private static final String API_KEY = "YOUR_API_KEY";
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";

    public enum Units {
        METRIC("metric"), IMPERIAL("imperial"), KELVIN("");

        private String unit;

        Units(String unit) {
            this.unit = unit;
        }

        public String getUnit() {
            return unit;
        }
    }

    public enum ApiEndpoint {
        CURRENT("weather?"), THREE_HOUR("forecast?");
        private final String endpoint;

        ApiEndpoint(String endpoint) {
            this.endpoint = endpoint;
        }

        public String getEndpoint() {
            return endpoint;
        }
    }

    public static String getUrlByLatLong(ApiEndpoint apiEndpoint, Units units, double lat, double lon) {
        // String currentWeatherUrl = "https://api.openweathermap.org/data/2.5/weather?appid=YOUR_API_KEY&lat=51.5072&lon=-0.1276&units=metric";
        // String hourlyUrl = "https://api.openweathermap.org/data/2.5/forecast?appid=YOUR_API_KEY&lat=51.5072&lon=-0.1276&units=metric";
        String apiKeyQuery = "appid=" + API_KEY;
        String latLongQuery = "lat=" + lat + "&lon=" + lon;
        String unitsQuery = "units=" + units.getUnit();

        return BASE_URL + apiEndpoint.getEndpoint() + apiKeyQuery + "&" + latLongQuery + "&" + unitsQuery;

    }


}
