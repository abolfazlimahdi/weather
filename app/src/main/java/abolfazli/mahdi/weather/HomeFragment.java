package abolfazli.mahdi.weather;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import abolfazli.mahdi.weather.adapters.DailyForecastAdapter;
import abolfazli.mahdi.weather.adapters.ThreeHourForecastAdapter;
import abolfazli.mahdi.weather.entities.CurrentWeatherEntity;
import abolfazli.mahdi.weather.entities.DailyEntity;
import abolfazli.mahdi.weather.entities.ThreeHourEntity;
import abolfazli.mahdi.weather.utils.ApiUtils;
import abolfazli.mahdi.weather.utils.DateUtils;
import abolfazli.mahdi.weather.utils.NumberUtils;
import abolfazli.mahdi.weather.utils.ViewUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {

    private RecyclerView rvThreeHour;
    private RecyclerView rvDaily;
    private ThreeHourForecastAdapter threeHourForecastAdapter;
    private DailyForecastAdapter dailyAdapter;

    private View view3ConditionIncludedLayout;
    private TextView tvWindSpeed;
    private TextView tvHumidity;
    private TextView tvPressure;
    private TextView tvMorning;
    private TextView tvEvening;
    private ImageView ivWeatherImage;

    private TextView tvCityName;
    private TextView tvTemperature;
    private TextView tvCondition;

    public HomeFragment() {
        super(R.layout.fragment_home);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView(view);
        initValues();
        rvThreeHour = view.findViewById(R.id.rv_threeHour_homeFragment);


        rvThreeHour.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));


        rvDaily = view.findViewById(R.id.rv_daily_homeFragment);
        rvDaily.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

    }

    private void initView(View view) {
        ivWeatherImage = view.findViewById(R.id.iv_weatherImage_homeFragment);
        view3ConditionIncludedLayout = view.findViewById(R.id.layout_3condition_HomeFragment);
        tvWindSpeed = view3ConditionIncludedLayout.findViewById(R.id.tv_windSpeed_3conditionLayout);
        tvHumidity = view3ConditionIncludedLayout.findViewById(R.id.tv_humidity_3conditionLayout);
        tvPressure = view3ConditionIncludedLayout.findViewById(R.id.tv_pressure_3conditionLayout);
        tvMorning = view.findViewById(R.id.tv_morning_homeFragment);
        tvEvening = view.findViewById(R.id.tv_evening_homeFragment);

        tvWindSpeed.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_wind, 0, 0, 0);
        tvHumidity.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_droplet, 0, 0, 0);
        tvPressure.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_circle, 0, 0, 0);

        tvMorning.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_sun, 0, 0, 0);
        tvEvening.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_moon, 0, 0, 0);

        tvCityName = view.findViewById(R.id.tv_cityName_homeFragment);
        tvTemperature = view.findViewById(R.id.tv_currentTemperature_homeFragment);
        tvCondition = view.findViewById(R.id.tv_condition_homeFragment);
    }


    private void initValues() {
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String currentWeatherUrl = ApiUtils.getUrlByLatLong(ApiUtils.ApiEndpoint.CURRENT, ApiUtils.Units.METRIC, 51.5072, -0.127);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, currentWeatherUrl, null,
                        this::parseCurrentWeatherJson,
                        error -> {
                            Log.e("Current", error.toString());
                        });
        queue.add(jsonObjectRequest);

        String threeHourUrl = ApiUtils.getUrlByLatLong(ApiUtils.ApiEndpoint.THREE_HOUR, ApiUtils.Units.METRIC, 51.5072, -0.127);
        JsonObjectRequest threeHourObjectRequest = new JsonObjectRequest(Request.Method.GET, threeHourUrl, null,
                this::parseThreeHourWeatherJson,
                error -> {
                    Log.e("Hourly", error.toString());
                }
        );
        queue.add(threeHourObjectRequest);
    }

    private void parseCurrentWeatherJson(JSONObject response) {

        try {
            JSONArray weatherArray = response.getJSONArray("weather");
            JSONObject weatherObj = weatherArray.getJSONObject(0);
            JSONObject mainObj = response.getJSONObject("main");

            String cityName = response.getString("name");
            double temperature = mainObj.getDouble("temp");
            String condition = weatherObj.getString("main");
            int humidity = mainObj.getInt("humidity");
            int pressure = mainObj.getInt("pressure");
            double windSpeed = response.getJSONObject("wind").getDouble("speed");
            String image = weatherObj.getString("icon");
            CurrentWeatherEntity weatherEntity = new CurrentWeatherEntity(cityName,
                    temperature,
                    condition,
                    humidity,
                    pressure,
                    windSpeed,
                    image);

            setupCurrentWeatherViews(weatherEntity);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void setupCurrentWeatherViews(CurrentWeatherEntity weather) {
        tvCityName.setText(weather.getCityName());
        tvCondition.setText(weather.getGeneralCondition());
        tvTemperature.setText(NumberUtils.decorateTemperature(weather.getTemperature()));
        tvPressure.setText(String.valueOf(weather.getPressure()));
        tvHumidity.setText(String.valueOf(weather.getHumidity()));
        tvWindSpeed.setText(NumberUtils.decorateWindSpeed(weather.getWindSpeed()));

        ViewUtils.loadWeatherIcons(ivWeatherImage, weather.getImage(), ViewUtils.IconSize.MEDIUM);
    }

    @SuppressLint("NotifyDataSetChanged")
    private void parseThreeHourWeatherJson(JSONObject response) {
        ThreeHourEntity threeHourEntity;

        List<ThreeHourEntity> totalThreeHourEntities = new ArrayList<>();
        try {
            JSONArray hourlyArray = response.getJSONArray("list");
            int count = response.getInt("cnt");
            JSONObject threeHourObject;
            JSONObject mainObject;
            JSONObject weatherObject;

            for (int i = 0; i < count; i++) {
                threeHourEntity = new ThreeHourEntity();
                threeHourObject = hourlyArray.getJSONObject(i);

                String timestampResponse = threeHourObject.getString("dt");
                long timestampLong = Long.parseLong(timestampResponse);
                threeHourEntity.setTimestamp(timestampLong);
                threeHourEntity.setHour(DateUtils.calculateHourFromTimestamp(timestampLong));
                threeHourEntity.setWeekDay(DateUtils.calculateWeekdayFromTimestamp(timestampLong));

                mainObject = threeHourObject.getJSONObject("main");
                threeHourEntity.setTemperature(mainObject.getDouble("temp"));

                weatherObject = threeHourObject.getJSONArray("weather").getJSONObject(0);
                threeHourEntity.setIconName(weatherObject.getString("icon"));

                totalThreeHourEntities.add(threeHourEntity);
            }

            convertThreeHourToDaily(totalThreeHourEntities);
            List<ThreeHourEntity> threeHourEntityList = new ArrayList<>(totalThreeHourEntities.subList(0, 8));
            threeHourForecastAdapter = new ThreeHourForecastAdapter(threeHourEntityList);
            rvThreeHour.setAdapter(threeHourForecastAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }



    private void convertThreeHourToDaily(List<ThreeHourEntity> threeHourEntityList) {
        List<DailyEntity> dailyEntityList = new ArrayList<>();
        double minTemp = Double.MAX_VALUE, maxTemp = Double.MIN_VALUE;
        String weekDay = threeHourEntityList.get(0).getWeekDay();

        ThreeHourEntity threeHourEntity;
        for (int i = 0; i < threeHourEntityList.size(); i++) {
            threeHourEntity = threeHourEntityList.get(i);
            if (weekDay.equals(threeHourEntity.getWeekDay())) {
                if (threeHourEntity.getTemperature() < minTemp) {
                    minTemp = threeHourEntity.getTemperature();
                }
                if (threeHourEntity.getTemperature() > maxTemp) {
                    maxTemp = threeHourEntity.getTemperature();
                }
            } else {
                dailyEntityList.add(new DailyEntity(weekDay, maxTemp, minTemp, threeHourEntity.getIconName()));
                minTemp = Double.MAX_VALUE;
                maxTemp = Double.MIN_VALUE;
            }
            weekDay = threeHourEntityList.get(i).getWeekDay();
        }

        dailyAdapter = new DailyForecastAdapter(dailyEntityList);
        rvDaily.setAdapter(dailyAdapter);
    }



}
