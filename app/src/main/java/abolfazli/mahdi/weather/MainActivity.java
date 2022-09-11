package abolfazli.mahdi.weather;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        HomeFragment fragment = new HomeFragment();
        setCurrentFragment(fragment);

        bottomNavigationView.setOnItemSelectedListener(this);


    }

    private void setCurrentFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragmentContainer, fragment).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.home) {
            setCurrentFragment(new HomeFragment());
        } else if (id == R.id.favorites) {
            setCurrentFragment(new FavoritesFragment());
        } else if (id == R.id.settings) {
            setCurrentFragment(new SettingsFragment());
        }
        return true;
    }
}
