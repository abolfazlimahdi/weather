package abolfazli.mahdi.weather.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import abolfazli.mahdi.weather.R;
import abolfazli.mahdi.weather.entities.DailyEntity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DailyForecastAdapter extends RecyclerView.Adapter<DailyForecastAdapter.DailyForecastVH> {

    private List<DailyEntity> items;

    public DailyForecastAdapter(List<DailyEntity> items) {
        this.items = items;
    }

    @Override
    public DailyForecastVH onCreateViewHolder(@NonNull ViewGroup parent, final int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_daily_forecast, parent, false);
        return new DailyForecastVH(view);
    }


    @Override
    public void onBindViewHolder(@NonNull DailyForecastVH viewHolder, final int position) {
        viewHolder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    public static class DailyForecastVH extends RecyclerView.ViewHolder {

        private final TextView tvDay;
        private final TextView tvMaxTemp;
        private final TextView tvMinTemp;
        private final ImageView ivWeatherImage;

        public DailyForecastVH(View itemView) {
            super(itemView);
            tvDay = itemView.findViewById(R.id.tv_day_dailyForecastItem);
            tvMaxTemp = itemView.findViewById(R.id.tv_maxTemperature_dailyForecastItem);
            tvMinTemp = itemView.findViewById(R.id.tv_minTemperature_dailyForecastItem);
            ivWeatherImage = itemView.findViewById(R.id.iv_weatherImage_dailyForecastItem);

        }

        public void bind(DailyEntity item) {
            tvDay.setText(item.getDay());
            tvMaxTemp.setText(String.valueOf(item.getMaxTemp()));
            tvMinTemp.setText(String.valueOf(item.getMinTemp()));
        }

    }
}
