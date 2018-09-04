package mx.itesm.demo03;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context;

    private SensorManager sensorManager;
    private Button buttonone;
    private Button buttontwo;
    private Button buttonnotif;

    public int NOTIF_ID = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        buttonone = (Button) findViewById(R.id.buttonvibrate);
        buttontwo = (Button) findViewById(R.id.buttonproximity);
        buttonnotif = (Button) findViewById(R.id.buttonBar);


        buttonone.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view){

                Intent intent1 = new Intent(context, ActivityTwo.class);
                startActivity(intent1);
            }

        });

        buttontwo.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view){
                Intent intent2 = new Intent(context, ActivityThree.class);
                startActivity(intent2);
            }

        });

        final NotificationCompat.Builder NotifBuilder = new NotificationCompat.Builder(this);

        NotifBuilder.setSmallIcon(R.mipmap.ic_launcher);

        NotifBuilder.setContentTitle("This is a notification!");

        NotifBuilder.setContentText("This is a text inside notification");

        buttonnotif.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                NotificationManager MyNotification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                MyNotification.notify(NOTIF_ID, NotifBuilder.build());

            }
        });







    }
}

   /* Intent notificationIntent = new Intent(this, ChildActivity.class);
    PendingIntent contentIntent =
            PendingIntent.getActivity(context, 0, notificationIntent, 0);
mBuilder.setContentIntent(contentIntent);  */