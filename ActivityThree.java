package mx.itesm.demo03;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;



public class ActivityThree extends AppCompatActivity {

   // Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        //context = getApplicationContext();

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        final Sensor proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        final AlertDialog.Builder DialogConf = new AlertDialog.Builder(this);

        DialogConf.setTitle("Warning");
        DialogConf.setMessage("You are close!");

        DialogConf.setNeutralButton("Close",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Do whatever you want here
                    }
                });


        if (proximitySensor == null) {
            //no sensor available/working
        }

        SensorEventListener proximitySensorListener = new SensorEventListener() {
            @Override

            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.values[0] < proximitySensor.getMaximumRange()) {
                    // Detected something nearby
                 //   getWindow().getDecorView().setBackgroundColor(Color.RED);

                    AlertDialog MyDialog = DialogConf.create();
                    MyDialog.show();


                } /*else
                    //When there's nothing nearby
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN); */
            }


            @Override

            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        sensorManager.registerListener(proximitySensorListener, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);

    }
}
