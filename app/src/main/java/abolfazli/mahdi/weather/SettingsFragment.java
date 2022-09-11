package abolfazli.mahdi.weather;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    private View view3ConditionIncludedLayout;
    private TextView tvHumidity;
    private TextView tvWindSpeed;
    private TextView tvPressure;

    private View viewTemperatureSettingsLayout;
    private TextView tvTemperatureUnitLabel;
    private TextView tvTemperatureUnitValue;
    private View viewWindSpeedSettingsLayout;
    private TextView tvWindSpeedUnitLabel;
    private TextView tvWindSpeedUnitValue;


    public SettingsFragment() {
        super(R.layout.fragment_settings);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView(view);
    }

    private void initView(View view) {
        view3ConditionIncludedLayout = view.findViewById(R.id.layout_3condition_settingsFragment);
        tvHumidity = view3ConditionIncludedLayout.findViewById(R.id.tv_humidity_3conditionLayout);
        tvPressure = view3ConditionIncludedLayout.findViewById(R.id.tv_pressure_3conditionLayout);
        tvWindSpeed = view3ConditionIncludedLayout.findViewById(R.id.tv_windSpeed_3conditionLayout);

        tvHumidity.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_droplet, 0, 0, 0);
        tvPressure.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_circle, 0, 0, 0);
        tvWindSpeed.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_wind, 0, 0, 0);


        viewTemperatureSettingsLayout = view.findViewById(R.id.layout_temperatureSettings_settingsFragment);
        tvTemperatureUnitLabel = viewTemperatureSettingsLayout.findViewById(R.id.tv_label_settingsLayout);
        tvTemperatureUnitValue = viewTemperatureSettingsLayout.findViewById(R.id.tv_value_settingsLayout);
        tvTemperatureUnitLabel.setText(R.string.label_temperature);
        tvTemperatureUnitValue.setText(R.string.label_temperature_Celsius);


        viewWindSpeedSettingsLayout = view.findViewById(R.id.layout_windSpeedSettings_settingsFragment);
        tvWindSpeedUnitLabel = viewWindSpeedSettingsLayout.findViewById(R.id.tv_label_settingsLayout);
        tvWindSpeedUnitValue = viewWindSpeedSettingsLayout.findViewById(R.id.tv_value_settingsLayout);
        tvWindSpeedUnitLabel.setText(R.string.label_wind_speed);
        tvWindSpeedUnitValue.setText(R.string.label_wind_speed_m_per_s);
    }
}
