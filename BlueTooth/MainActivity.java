package hombuilt.bluetoothexp;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button OnButton , OffButton , DiscoverButton;

    BluetoothAdapter bluetoothAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OnButton= (Button) findViewById(R.id.on_btn_id);
        OffButton= (Button) findViewById(R.id.off_btn_id);
        DiscoverButton= (Button) findViewById(R.id.discover_btn_id);

        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();

        OnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!bluetoothAdapter.isEnabled())
                {
                    bluetoothAdapter.enable();
                }

            }
        });

        OffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bluetoothAdapter.isEnabled())
                {
                    bluetoothAdapter.disable();
                }

            }
        });

        DiscoverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);

                startActivity(intent);


            }
        });



    }
}
