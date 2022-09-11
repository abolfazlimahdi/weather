package abolfazli.mahdi.weather;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import abolfazli.mahdi.weather.adapters.FavoritesAdapter;
import abolfazli.mahdi.weather.entities.FavoriteEntity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FavoritesFragment extends Fragment {

    private List<FavoriteEntity> favoriteEntities = new ArrayList<>();

    private RecyclerView favoritesRV;

    public FavoritesFragment() {
        super(R.layout.fragment_favorites);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initDataset();

        favoritesRV = view.findViewById(R.id.rv_favorites_favoritesFragment);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        favoritesRV.setLayoutManager(layoutManager);
        FavoritesAdapter favoritesAdapter = new FavoritesAdapter(favoriteEntities);
        favoritesRV.setAdapter(favoritesAdapter);


    }

    private void initDataset() {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            favoriteEntities.add(new FavoriteEntity(
                    random.nextInt(30) + 10,
                    "city " + i,
                    "country " + i * 2,
                    random.nextInt(30),
                    random.nextInt(30)
            ));
        }
    }
}
