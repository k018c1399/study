package myapps.c.listview;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    private static final String[] phone = {
            "iphone","android"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,phone);


            listView.setAdapter(arrayAdapter);












    }
}