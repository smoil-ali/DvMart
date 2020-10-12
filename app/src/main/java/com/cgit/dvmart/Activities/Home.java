package com.cgit.dvmart.Activities;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.cgit.dvmart.Fragments.AccountFragment;
import com.cgit.dvmart.Fragments.CartFragment;
import com.cgit.dvmart.Fragments.Categories;
import com.cgit.dvmart.Fragments.HomeFragment;
import com.cgit.dvmart.Fragments.Menu;
import com.cgit.dvmart.Fragments.ProfileFragment;
import com.cgit.dvmart.Fragments.ShopFragment;
import com.cgit.dvmart.Listeners.RightSheetCloseListener;
import com.cgit.dvmart.R;
import com.cgit.dvmart.Utility.CONSTANTS;
import com.cgit.dvmart.databinding.ActivityHomeBinding;
import com.cgit.dvmart.databinding.ContentMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Home extends AppCompatActivity implements TabLayout.OnTabSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener,
RightSheetCloseListener{

    public static String user=null;
    final String TAG = Home.class.getSimpleName();
    ActivityHomeBinding binding;
    Fragment fragment;
    ProfileFragment profileFragment = new ProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.leftDrawerMenu.tabLayout.addOnTabSelectedListener(this);
        binding.container.bottomNavigation.setOnNavigationItemSelectedListener(this);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(binding.leftDrawerMenu.hostFragment.getId(),new Menu()).commit();

            getSupportFragmentManager().beginTransaction()
                    .replace(binding.container.fragmetContainer.getId(),new HomeFragment()).commit();

            profileFragment.setListener(this);
            getSupportFragmentManager().beginTransaction()
                    .replace(binding.rightDrawerMenu.rightContainer.getId(),profileFragment).commit();

        }

        binding.container.ivNavMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleLeftDrawer();
            }
        });

    }

    private void toggleLeftDrawer() {
        binding.drawerLayout.openDrawer(GravityCompat.START);
    }

    private void toggleRightDrawer() {
        binding.drawerLayout.openDrawer(GravityCompat.END);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        switch (binding.leftDrawerMenu.tabLayout.getSelectedTabPosition()){
            case 0:
                fragment=new Menu();
                break;
            case 1:
                fragment=new Categories();
                break;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(binding.leftDrawerMenu.hostFragment.getId(),fragment).commit();
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                fragment=new HomeFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(binding.container.fragmetContainer.getId(),fragment).commit();

                break;
            case R.id.shop:
                fragment=new ShopFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(binding.container.fragmetContainer.getId(),fragment).commit();

                break;
            case R.id.cart:
                fragment=new CartFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(binding.container.fragmetContainer.getId(),fragment).commit();

                break;
            case R.id.profile:
                if (user==null){
                    toggleRightDrawer();
                }else{
                    fragment=new AccountFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(binding.container.fragmetContainer.getId(),fragment).commit();
                }

                break;
        }

        return true;
    }

    @Override
    public void OnClose() {
        closeRightSheet();
    }

    private void closeRightSheet(){
        binding.drawerLayout.closeDrawer(GravityCompat.END);
    }
}