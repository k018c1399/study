package myapps.c.addrecyclerview;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private String[] dataset = new String[10];

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;

        ViewHolder(View v){
            super(v);
            mTextView =(TextView)v.findViewById(R.id.text_view);

        }
    }

    MyAdapter(String[] myDataset) { dataset = myDataset;}

    @Override
    @NonNull

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_view,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        holder.mTextView.setText(dataset[position]);

        Button sendButton = findViewById(R.id.button);
        sendButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            System.out.println("alreadyclick");



        });






    @Override
    public int getItemCount() {return dataset.length;}




}
    }
    