package abolfazli.mahdi.weather.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import abolfazli.mahdi.weather.R;
import abolfazli.mahdi.weather.entities.ThreeHourEntity;
import abolfazli.mahdi.weather.utils.NumberUtils;
import abolfazli.mahdi.weather.utils.ViewUtils;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ThreeHourForecastAdapter extends RecyclerView.Adapter<ThreeHourForecastAdapter.TodayHourlyVH> {

    private List<ThreeHourEntity> items;

    public ThreeHourForecastAdapter(List<ThreeHourEntity> items) {
        this.items = items;
    }

    @Override
    public TodayHourlyVH onCreateViewHolder(@NonNull ViewGroup parent, final int position) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_three_hour_forecast, parent, false);
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
            tvHour = itemView.findViewById(R.id.tv_hour_threeHourForecastItem);
            tvTemperature = itemView.findViewById(R.id.tv_temperature_threeHourForecastItem);
            ivWeatherImage = itemView.findViewById(R.id.iv_weatherImage_threeHourForecastItem);
        }

        public void bind(ThreeHourEntity item) {
            tvHour.setText(item.getHour());
            tvTemperature.setText(NumberUtils.decorateTemperature(item.getTemperature()));
            ViewUtils.loadWeatherIcons(ivWeatherImage, item.getIconName(), ViewUtils.IconSize.SMALL);
        }

    }
}
