package com.utkuakgungor.ekintakipsistemi.main;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.text.Html;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.utkuakgungor.ekintakipsistemi.R;
import com.utkuakgungor.ekintakipsistemi.ayarlar.AyarlarActivity;
import com.utkuakgungor.ekintakipsistemi.hakkimizda.HakkimizdaActivity;
import com.utkuakgungor.ekintakipsistemi.tarlaekle.TarlaEkleActivity;
import com.utkuakgungor.ekintakipsistemi.utils.FirebaseAdapter;
import com.utkuakgungor.ekintakipsistemi.utils.FirebaseModel;
import com.utkuakgungor.ekintakipsistemi.utils.Function;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAdapter adapter;
    private RecyclerView recyclerView;
    private List<FirebaseModel> list;
    private DatabaseReference reference;
    private TextView cityField, currentTemperatureField,  weatherIcon;
    private Typeface weatherFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        recyclerView=findViewById(R.id.tarlaList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        list=new ArrayList<>();
        reference= FirebaseDatabase.getInstance().getReference("Tarlalar");
        adapter=new FirebaseAdapter(list,MainActivity.this);
        recyclerView.setAdapter(adapter);

        havaDurumu();

        updateList();
    }

    public void updateList(){
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                list.add(dataSnapshot.getValue(FirebaseModel.class));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void havaDurumu() {
        weatherFont = Typeface.createFromAsset(getAssets(), "fonts/weathericons-regular-webfont.ttf");
        cityField = findViewById(R.id.sehirİsmi);
        currentTemperatureField = findViewById(R.id.derece);
        weatherIcon = findViewById(R.id.ikon);
        weatherIcon.setTypeface(weatherFont);

        Function.placeIdTask asyncTask =new Function.placeIdTask((weather_city, weather_description, weather_temperature, weather_humidity, weather_pressure, weather_updatedOn, weather_iconText, sun_rise) -> {

            cityField.setText(weather_city);
            currentTemperatureField.setText(weather_temperature);
            weatherIcon.setText(Html.fromHtml(weather_iconText));

        });
        asyncTask.execute("25.180000", "89.530000"); //  asyncTask.execute("Latitude", "Longitude")
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.tavsiye_al) {

        } else if (id == R.id.haberler) {

        } else if (id == R.id.ekle) {
            Intent ekleIntent = new Intent(MainActivity.this, TarlaEkleActivity.class);
            startActivity(ekleIntent);
        } else if (id == R.id.alımsatim) {

        } else if (id == R.id.ayarlar) {
            Intent ayarlarIntent = new Intent(MainActivity.this, AyarlarActivity.class);
            startActivity(ayarlarIntent);
        } else if (id == R.id.hakkimizda) {
            Intent hakkimizdaIntent = new Intent(MainActivity.this, HakkimizdaActivity.class);
            startActivity(hakkimizdaIntent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
