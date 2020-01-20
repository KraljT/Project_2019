package com.example.stuff_14.Home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.stuff_14.R;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    private static final String TAG = "RecycleViewAdapter";
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();
    private Context context;

    public RecycleViewAdapter(ArrayList<String> mImageNames, ArrayList<String> mImages, ArrayList<String> mPrice, Context context) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mPrice = mPrice;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,final int i) {
        Log.d(TAG,"onBindViewHolder: called");
        Glide.with(context)
                .asBitmap()
                .load(mImages.get(i))
                .into(viewHolder.image);
        viewHolder.text.setText(mImageNames.get(i));
        viewHolder.price_text.setText(mPrice.get(i));
        viewHolder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick: Clicked on: "+mImageNames.get(i));
                Toast.makeText(context, mImageNames.get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView text;
        TextView price_text;
        RelativeLayout parent_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView_listitem);
            text = itemView.findViewById(R.id.textView_listitem);
            price_text = itemView.findViewById(R.id.textView_price);
            parent_layout = itemView.findViewById(R.id.parent);
        }
    }
}
