package com.example.hp.friend_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String FriendsName[]={"MANISH","VISHWA","VIKAS","MANYU","VK_ROY"};
    ListView l1;
    ArrayAdapter<String>adaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     l1 = (ListView)findViewById(R.id.list_friend);
     adaptor = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,FriendsName);
     l1.setAdapter(adaptor);
     l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             String str=FriendsName[5];
             Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
         }
     });
    }
}
