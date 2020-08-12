package myapps.c.addrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import java.util.Locale;



import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private String[] dataset = new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager rLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(rLayoutManager);

        int i = 0;
        while (i < 10) {
            dataset[i] = String.format(Locale.ENGLISH, "Data_0%d", i);
            i++;
        }
        RecyclerView.Adapter rAdapter = new MyAdapter(dataset);
        recyclerView.setAdapter(rAdapter);



    }
}