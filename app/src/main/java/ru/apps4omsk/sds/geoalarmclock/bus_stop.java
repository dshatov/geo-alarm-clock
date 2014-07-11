package ru.apps4omsk.sds.geoalarmclock;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by raketa on 10.07.14.
 */
public class bus_stop extends MainActivity {
    public int mTargetBusNumber, mCurrentBusNumber;
    public String mBusName;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus_stations);

        TextView tvStopName = (TextView)findViewById(R.id.textView2);
       // TextView tvStopNumber = (TextView)findViewById(R.id.textView2);
        mTargetBusNumber = getIntent().getExtras().getInt("stop_number");
        mBusName = getIntent().getExtras().getString("stop_name");
        tvStopName.setText("''"+mBusName+"''");
     //   tvStopNumber.setText(((Integer)mTargetBusNumber).toString());


    }


}
