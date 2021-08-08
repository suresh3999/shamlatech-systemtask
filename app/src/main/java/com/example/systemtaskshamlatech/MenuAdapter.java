package com.example.systemtaskshamlatech;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {


    private List<MenuList> menuLists;
    private Context context;

    public MenuAdapter(List<MenuList> menuLists, Context context) {

        this.menuLists = menuLists;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {


        final MenuList menuList = menuLists.get(position);
        holder.idEmail.setText(menuList.getEmail());
        holder.idFirstName.setText(menuList.getFirst_name());
        holder.idLastName.setText(menuList.getLast_name());

        Picasso.with(context)
                .load(menuList.getAvatar())
                .into(holder.idIVUser);

        holder.idIVUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,ViewDetails.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("email",menuList.getEmail());
                intent.putExtra("firstname",menuList.getFirst_name());
                intent.putExtra("lastname",menuList.getLast_name());
                intent.putExtra("imagurl",menuList.getAvatar());
                context.startActivity(intent);

            }
        });


    }

    @Override


    public int getItemCount() {
        return menuLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {


        public ImageView idIVUser;
        public TextView idEmail,idFirstName,idLastName;



        public ViewHolder(View itemView) {
            super(itemView);


            idIVUser = (ImageView) itemView.findViewById(R.id.idIVUser);
            idEmail = (TextView) itemView.findViewById(R.id.idEmail);
            idFirstName = (TextView) itemView.findViewById(R.id.idFirstName);
            idLastName = (TextView) itemView.findViewById(R.id.idLastName);




        }

    }
}
