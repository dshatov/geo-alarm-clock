package ru.apps4omsk.sds.geoalarmclock;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.content.Intent;
import android.widget.NumberPicker;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    public long bus_id;

    public final String[] routes = {
            "Химик",
            "Кристалл",
            "Амур",
            "Первомайский рынок",
            "Марс",
            "Венера",
            "Юпитер",
            "Луна",
            "Плутон",
            "Земля",
    };

    public void doGpsTask(){
        //update geo
        Log.d("SDSLOG", " called GPS");

    }
    public void doUITask(){
        //update UI
        Log.d("SDSLOG", " called UI");
    }

    final String LOG_TAG_SDS = "SDSLOG";

    public void onClick(View v)
    {
        Intent intent = new Intent(MainActivity.this, bus_stop.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timer myTimer = new Timer(); // Создаем таймер
        final Handler uiHandler = new Handler();
        myTimer.schedule(new TimerTask() { // Определяем задачу
            @Override
            public void run() {
                doGpsTask();
                uiHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        doUITask();
                    }
                });
            }
        }, 1, 1 * 1000);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listRoutes = (ListView) findViewById(R.id.routes_lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, routes);

        listRoutes.setAdapter(adapter);

        listRoutes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Log.d("SDSLOG", "itemClick: position = " + position + ", id = "
                       + id);
                bus_id = id;
                askForRadius(position);
            }
        });
    }

    private void askForRadius(final int posit) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Когда вас разбудить?");
        alertDialog.setMessage("За сколько остановок вас разбудить:");

        final NumberPicker alarmRadiusInput = new NumberPicker(this);
        alarmRadiusInput.setMinValue(1);
        alarmRadiusInput.setMaxValue(8);
        alertDialog.setView(alarmRadiusInput);

        alertDialog.setPositiveButton("Поехали!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int alarmRadius = alarmRadiusInput.getValue();
                //startTracking(0, bus_id, alarmRadius);
                Log.d("SDSLOG", alarmRadius + "");
                Intent intent = new Intent(MainActivity.this, bus_stop.class);

                final int position = posit;
                intent.putExtra("stop_name", routes[position]);
                intent.putExtra("stop_number", position);
                startActivity(intent);
            }

        });

        alertDialog.show();
    }

    private void startTracking(int user, long id, int alarmRadius) {
        Tracker tracker = new Tracker(0, id, alarmRadius);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
