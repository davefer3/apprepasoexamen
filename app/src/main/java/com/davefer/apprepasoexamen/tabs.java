package com.davefer.apprepasoexamen;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mikepenz.materialdrawer.*;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class tabs extends AppCompatActivity {

    private Drawer mDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        Toolbar toolbar  = (Toolbar)findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);

        new DrawerBuilder().withActivity(this).build();
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.mipmap.ic_launcher)
                .addProfiles(
                  new ProfileDrawerItem()
                    .withName("materialDrawer")
                    .withEmail("test@test.com")
                    .withIcon(getResources().getDrawable(R.mipmap.ic_launcher_round,getTheme()))
                ).build();

        mDrawer = new DrawerBuilder()
                .withActivity(this)
                .withActionBarDrawerToggle(true) //Muestra o no el icono de hamburguesa
                .withToolbar(toolbar) //Lo asocia a nuestra toolbar
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.START) //Lo pone a la derecha (La hamburguesa sigue a la izquierda)
                .withAccountHeader(headerResult)
                .withSelectedItem(2)
                .withSliderBackgroundColor(getResources().getColor(R.color.accent)) //Color de fondo
                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withIdentifier(1)
                                .withName("Opción 1"),
                               // .withIcon(android.R.drawable.btn_star_big_on),
                        new PrimaryDrawerItem()
                                .withIdentifier(2)
                                .withName("Opción 2"),

                        new DividerDrawerItem(),
                        new SecondaryDrawerItem()
                                .withIdentifier(3)
                                .withName("Cerrar menú"),
                        new SecondaryDrawerItem()
                                .withIdentifier(4)
                                .withName("Salir App")
                )
                .withOnDrawerItemClickListener(
                        new Drawer.OnDrawerItemClickListener() {
                            @Override
                            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                                switch ((int)drawerItem.getIdentifier()) {
                                    case 1: {
                                        Toast.makeText(tabs.this, "Opción 1 pulsada", Toast.LENGTH_SHORT).show();
                                        break;
                                    }
                                    case 2: {
                                        Toast.makeText(tabs.this, "Opción 2 pulsada", Toast.LENGTH_SHORT).show();
                                        break;
                                    }
                                    case 3: break;
                                    case 4: {
                                        finish();
                                        break;
                                    }
                                }

                                mDrawer.closeDrawer();

                                return true;
                            }
                        })
                .build();

       // Bottom navigation
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_test)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(tabs.this, "BackPressed", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}