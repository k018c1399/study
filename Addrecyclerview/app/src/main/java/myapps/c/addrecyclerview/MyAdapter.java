package myapps.c.addrecyclerview;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private String[] myDataSet;

    MyAdapter(String[] dataset) {
        myDataSet = dataset;
    }

    @Override
    @NonNull

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_view,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("alreadyclick");
            }
        });

    }


    @Override
    public int getItemCount() {
        return myDataSet.length;
    }



    static class ViewHolder extends RecyclerView.ViewHolder {
        Button mButton;

        ViewHolder(View v){
            super(v);
            mButton =(Button)v.findViewById(R.id.button);

        }
    }




}

