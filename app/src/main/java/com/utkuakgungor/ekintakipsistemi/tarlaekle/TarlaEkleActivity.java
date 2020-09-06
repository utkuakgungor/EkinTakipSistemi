package com.utkuakgungor.ekintakipsistemi.tarlaekle;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.utkuakgungor.ekintakipsistemi.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.utkuakgungor.ekintakipsistemi.utils.FirebaseModel;


public class TarlaEkleActivity extends AppCompatActivity {

    FloatingActionButton fab;
    EditText tarla_adi,ekin_turu,ekin_tarihi,son_sulama,toprak_turu;
    String tarlaadi,ekinturu,ekintarihi,sonsulama,toprakturu;
    DatabaseReference reference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarlaekle);

        reference= FirebaseDatabase.getInstance().getReference("Tarlalar");

        fab=findViewById(R.id.fabEkle);
        tarla_adi =findViewById(R.id.edittext1);
        ekin_turu =findViewById(R.id.edittext2);
        ekin_tarihi =findViewById(R.id.edittext3);
        son_sulama =findViewById(R.id.edittext4);
        toprak_turu =findViewById(R.id.edittext5);
        fab.setOnClickListener(v -> {
            tarlaadi=tarla_adi.getText().toString();
            ekinturu=ekin_turu.getText().toString();
            ekintarihi=ekin_tarihi.getText().toString();
            sonsulama=son_sulama.getText().toString();
            toprakturu=toprak_turu.getText().toString();
            if(!TextUtils.isEmpty(tarlaadi) && !TextUtils.isEmpty(ekinturu) && !TextUtils.isEmpty(ekintarihi)
                    && !TextUtils.isEmpty(sonsulama) && !TextUtils.isEmpty(toprakturu)){
                FirebaseModel model = new FirebaseModel(tarlaadi,ekinturu,ekintarihi,sonsulama,toprakturu);
                reference.push().setValue(model);
            }
            Toast.makeText(TarlaEkleActivity.this,getResources().getString(R.string.tarlaeklendi),Snackbar.LENGTH_LONG).show();
            finish();
        });
    }
}
