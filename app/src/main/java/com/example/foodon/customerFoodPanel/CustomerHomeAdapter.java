package com.example.foodon.customerFoodPanel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodon.R;
import com.example.foodon.UpdateDishModel;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class CustomerHomeAdapter extends RecyclerView.Adapter<CustomerHomeAdapter.ViewHolder> {
    private Context mcontext;
    private List<UpdateDishModel> updateDishModellist;
    DatabaseReference databaseReference;

    public CustomerHomeAdapter(Context context,List<UpdateDishModel>updateDishModellist)
    {
        this.updateDishModellist=updateDishModellist;
        this.mcontext=context;
    }



    @NonNull
    @Override
    public CustomerHomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.customer_menudish,parent,false);
        return new CustomerHomeAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomerHomeAdapter.ViewHolder holder, int position) {
        final UpdateDishModel updateDishModel=updateDishModellist.get(position);
        Glide.with(mcontext).load(updateDishModel.getImageURL()).into(holder.imageView);
        holder.Dishname.setText(updateDishModel.getPrice());
        updateDishModel.getRandomUID();
        updateDishModel.getChefId();
        holder.price.setText("Price:  " +updateDishModel.getPrice()+"Rs");




    }

    @Override
    public int getItemCount() {
        return updateDishModellist.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView Dishname,price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.menu_image);
            Dishname=itemView.findViewById(R.id.dishname);
            price=itemView.findViewById(R.id.dishprice);



        }
    }

}
