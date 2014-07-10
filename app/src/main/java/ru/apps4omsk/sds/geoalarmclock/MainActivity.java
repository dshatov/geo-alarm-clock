package ru.apps4omsk.sds.geoalarmclock;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] routes = {
                "Автобус 1",
                "Автобус 29",
                "Автобус 33",
                "Автобус 49",
                "Автобус 51",
                "Автобус 190",
                "Автобус 10",
                "Автобус 290",
                "Автобус 330",
                "Автобус 490",
                "Автобус 510",
                "Автобус 1900",
                "Автобус 100",
                "Автобус 2900",
                "Автобус 3300",
                "Автобус 4900",
                "Автобус 5100",
                "Автобус 19000"
        };

        ListView listRoutes = (ListView) findViewById(R.id.mainscreen_lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, routes);

        listRoutes.setAdapter(adapter);
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
