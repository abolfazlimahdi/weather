package abolfazli.mahdi.weather.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import abolfazli.mahdi.weather.R;
import abolfazli.mahdi.weather.entities.FavoriteEntity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoritesVH> {

    private List<FavoriteEntity> items;

    public FavoritesAdapter(List<FavoriteEntity> items) {
        this.items = items;
    }

    @Override
    public FavoritesVH onCreateViewHolder(@NonNull ViewGroup parent, final int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorite, parent, false);

        return new FavoritesVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesVH viewHolder, final int position) {
        viewHolder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }





    public static class FavoritesVH extends RecyclerView.ViewHolder {

        private final TextView tvTemperature;
        private final TextView tvCity;
        private final TextView tvCountry;
        private final TextView tvHumidity;
        private final TextView tvWindSpeed;

        private final ImageView ivWeatherImage;

        public FavoritesVH(View itemView) {
            super(itemView);

            tvTemperature = itemView.findViewById(R.id.tv_temperature_favoriteItem);
            tvCity = itemView.findViewById(R.id.tv_city_favoriteItem);
            tvCountry = itemView.findViewById(R.id.tv_country_favoriteItem);
            tvHumidity = itemView.findViewById(R.id.tv_humidity_favoriteItem);
            tvWindSpeed = itemView.findViewById(R.id.tv_windSpeed_favoriteItem);
            ivWeatherImage = itemView.findViewById(R.id.iv_weatherImage_favoriteItem);
        }

        public void bind(FavoriteEntity item) {
            tvTemperature.setText(String.valueOf(item.getTemperature()));
            tvCity.setText(item.getCity());
            tvCountry.setText(item.getCountry());
            tvHumidity.setText(String.valueOf(item.getHumidity()));
            tvWindSpeed.setText(String.valueOf(item.getWindSpeed()));

        }
    }
}
