package hombuilt.wifiexp;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView WifiListView;
    Button OnButton , OffButton , ScanButton;

    WifiManager wifiManager;

    List<ScanResult> scanResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WifiListView= (ListView) findViewById(R.id.wifi_nw_list);
        OnButton= (Button) findViewById(R.id.on_btn);
        OffButton= (Button) findViewById(R.id.off_btn);
        ScanButton= (Button) findViewById(R.id.scan_btn);


        wifiManager= (WifiManager) getSystemService(Context.WIFI_SERVICE);

        OnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                wifiManager.setWifiEnabled(true);

            }
        });

        OffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                wifiManager.setWifiEnabled(false);
            }
        });

        ScanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                scanResults=new ArrayList<ScanResult>();

                scanResults= wifiManager.getScanResults();

                ArrayList<String> NW_NameArrayList=new ArrayList<String>();

                ArrayAdapter<String> arrayAdapter;

                for (ScanResult SR:scanResults)
                {
                    String NW_NAME=SR.SSID;
                    NW_NameArrayList.add(NW_NAME);
                }
                arrayAdapter=new ArrayAdapter<String>(MainActivity.this , android.R.layout.simple_list_item_1 , NW_NameArrayList);

                WifiListView.setAdapter(arrayAdapter);



            }
        });


    }
}
