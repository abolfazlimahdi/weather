package abolfazli.mahdi.weather;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import abolfazli.mahdi.weather.adapters.DailyForecastAdapter;
import abolfazli.mahdi.weather.adapters.HourlyForecastAdapter;
import abolfazli.mahdi.weather.entities.DailyEntity;
import abolfazli.mahdi.weather.entities.HourlyEntity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {

    private List<HourlyEntity> hourlyEntityList = new ArrayList<>();
    private List<DailyEntity> dailyEntityList = new ArrayList<>();
    private RecyclerView rvHourly;
    private RecyclerView rvDaily;

    private View view3ConditionIncludedLayout;
    private TextView tvWindSpeed;
    private TextView tvHumidity;
    private TextView tvPressure;
    private TextView tvMorning;
    private TextView tvEvening;


    public HomeFragment() {
        super(R.layout.fragment_home);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView(view);
        initDataset();
        rvHourly = view.findViewById(R.id.rv_hourly_homeFragment);

        rvHourly.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        HourlyForecastAdapter hourlyAdapter = new HourlyForecastAdapter(hourlyEntityList);
        rvHourly.setAdapter(hourlyAdapter);

        rvDaily = view.findViewById(R.id.rv_daily_homeFragment);
        rvDaily.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        DailyForecastAdapter dailyAdapter = new DailyForecastAdapter(dailyEntityList);
        rvDaily.setAdapter(dailyAdapter);
    }

    private void initView(View view) {
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
    }


    private void initDataset() {
        Random random = new Random();
        int min = 15;
        int max = 35;

        for (int i = 1; i < 11; i++) {
            hourlyEntityList.add(new HourlyEntity(i + "AM", random.nextInt(max - min) + min + 1, ""));
        }

        int dailyMin = 15;
        int dailyAverage = 25;
        int dailyMax = 35;


        String[] days = {"Tue", "Wed", "Thur", "Fri", "Sat", "Fri"};
        for (int i = 0; i < 6; i++) {
            dailyEntityList.add(new DailyEntity(
                    days[i],
                    random.nextInt(dailyMax - dailyAverage) + dailyAverage + 1,
                    random.nextInt(dailyAverage - dailyMin) + dailyMin + 1,
                    ""
            ));
        }


    }

}
