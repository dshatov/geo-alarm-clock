package ru.apps4omsk.sds.geoalarmclock;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;

public class MainActivity extends Activity {

    final String LOG_TAG_SDS = "SDSLOG";
    public void onClick(View v)
    {
        Intent intent = new Intent(MainActivity.this, bus_stop.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] routes = {
                "Химик",
                "Кристалл",
                "Амур",
                "Первомайский рынок",
                "Марс",
                "Венера",
                "Юпитер",
                "Луна",
                "Плутон",
                "23456",
        };

        ListView listRoutes = (ListView) findViewById(R.id.routes_lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, routes);

        listRoutes.setAdapter(adapter);
        listRoutes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Log.d(LOG_TAG_SDS, "itemClick: position = " + position + ", id = "
                        + id);



                Intent intent = new Intent(MainActivity.this, bus_stop.class);

                intent.putExtra("stop_name", routes[position]);
                intent.putExtra("stop_number", position);
                startActivity(intent);

            }
        });
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
