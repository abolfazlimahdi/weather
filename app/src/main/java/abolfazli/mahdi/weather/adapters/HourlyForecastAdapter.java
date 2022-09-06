package abolfazli.mahdi.weather.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import abolfazli.mahdi.weather.R;
import abolfazli.mahdi.weather.entities.HourlyEntity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HourlyForecastAdapter extends RecyclerView.Adapter<HourlyForecastAdapter.TodayHourlyVH> {

    private List<HourlyEntity> items;

    public HourlyForecastAdapter(List<HourlyEntity> items) {
        this.items = items;
    }

    @Override
    public TodayHourlyVH onCreateViewHolder(@NonNull ViewGroup parent, final int position) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_hourly_forecast, parent, false);
        return new TodayHourlyVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodayHourlyVH viewHolder, final int position) {
        viewHolder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class TodayHourlyVH extends RecyclerView.ViewHolder {

        private final TextView tvHour;
        private final TextView tvTemperature;
        private final ImageView ivWeatherImage;

        public TodayHourlyVH(@NonNull View itemView) {
            super(itemView);
            tvHour = itemView.findViewById(R.id.tv_hour_hourlyForecastItem);
            tvTemperature = itemView.findViewById(R.id.tv_temperature_hourlyForecastItem);
            ivWeatherImage = itemView.findViewById(R.id.iv_weatherImage_hourlyForecastItem);
        }

        public void bind(HourlyEntity item) {
            tvHour.setText(item.getHour());
            tvTemperature.setText(String.valueOf(item.getTemperature()));


        }
    }
}
