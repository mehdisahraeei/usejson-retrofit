package com.mahdi.retrofitjson.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.mahdi.retrofitjson.R;
import com.mahdi.retrofitjson.model.Model;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;



public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomView> {

    private Context context;
    private ArrayList<Model> modelList;


    public CustomAdapter(Context context, ArrayList<Model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @NotNull
    @Override
    public CustomView onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.body, parent, false);


        return new CustomView(view);
    }


    @Override
    public void onBindViewHolder(@NonNull @NotNull CustomAdapter.CustomView holder, int position) {

        holder.textView1.setText(modelList.get(position).getId());
        holder.textView2.setText(modelList.get(position).getName());

        Glide.with(context)
                .load(modelList.get(position).getImage())
                .into(holder.imageView);


        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    Toast.makeText(context, "mahdi", Toast.LENGTH_SHORT).show();
                } else if (position == 1) {
                    Toast.makeText(context, "ali", Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    Toast.makeText(context, "reza", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }



    @Override
    public int getItemCount()
    {
        return modelList.size();
    }


    public static class CustomView extends RecyclerView.ViewHolder {

        RelativeLayout layout;
        TextView textView1, textView2;
        ImageView imageView;


        public CustomView(@NonNull @NotNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.txt1);
            textView2 = itemView.findViewById(R.id.txt2);
            imageView = itemView.findViewById(R.id.img1);
            layout = itemView.findViewById(R.id.rel1);
        }

    }



}
