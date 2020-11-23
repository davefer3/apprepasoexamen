package com.davefer.apprepasoexamen;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    Button btn;
    static TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);

        et1 = (EditText)findViewById(R.id.etusuario);
        et2 = (EditText)findViewById(R.id.etpass);
        btn = (Button)findViewById(R.id.btncontinuar);
        tv1 = (TextView)findViewById(R.id.tv1);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tabs, menu);
        return true;
    }

    public void comprobar(View view) {
        Log.i("tst",et1.getText().toString());
        Log.i("tst",et2.getText().toString());

        String user = et1.getText().toString();
        String pass = et2.getText().toString();

        if(user.equals("admin") && pass.equals("admin")){
            Intent i = new Intent(this, tabs.class);
            startActivity(i);
        }

    }

    public void sacarfecha(View view) {
       DialogFragment df = new DatePickerFragment();
       df.show(getSupportFragmentManager(),"DatePicker");

    }

    public void closeapp(MenuItem item) {
        String bpulsado = String.valueOf(item.getTitle());

        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("¿Cerrar?");
        dialogo.setMessage("¿Cerrar aplicación?");
        dialogo.setCancelable(false);

        dialogo.setPositiveButton("Si" ,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
            }
        });
        dialogo.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //
            }
        });
        dialogo.show();

    }


    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dpd = new DatePickerDialog(getActivity(),this,year,month,day);
            return dpd;
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            tv1.setText(dayOfMonth+ "/"+(month +1)+"/"+year);
        }
    }

}


