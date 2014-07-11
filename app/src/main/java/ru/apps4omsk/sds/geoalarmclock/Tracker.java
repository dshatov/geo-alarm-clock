package ru.apps4omsk.sds.geoalarmclock;

import android.util.Log;

/**
 * Created by Ильдар on 11.07.2014.
 */
public class Tracker {

    public Tracker(int user, long busStop, int alarmRadius) {
        long timer = System.currentTimeMillis();
        long lastRefreshTimer = timer;
        int delay = 1000;


        /*while(true)
        {
            timer = System.currentTimeMillis();// ~ getTicks()
            if (timer - lastRefreshTimer<delay)
                continue;
            lastRefreshTimer = timer;
            if (user-busStop-alarmRadius == 0)
            {
                Log.d("SDSLOG", "Приехали:)");//this place for alarm
                break;
            }
            else {
                if (user-busStop < 0)
                    user++;
                else
                    user--;
            }
        }*/
    }

}
