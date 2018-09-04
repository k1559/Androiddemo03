package mx.itesm.demo03;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityTwo extends AppCompatActivity {

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        context = getApplicationContext();

        Button vibButton = (Button) findViewById(R.id.button_vibrate);


        vibButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Toast MyToast = new Toast(context);
                //Set the pattern for vibration
                long pattern[] = {0, 200, 100, 300, 400}; // or you can just set a duration also in ms
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(pattern, -1);

                MyToast.makeText(context, "The phone is vibrating", Toast.LENGTH_LONG).show();


            }
        });
    }
}
