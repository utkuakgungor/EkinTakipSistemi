package com.utkuakgungor.ekintakipsistemi.utils;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.utkuakgungor.ekintakipsistemi.R;

import java.util.List;

/**
 * Created by utkuakgungor on 5.12.2017.
 */

public class FirebaseAdapter extends RecyclerView.Adapter<FirebaseAdapter.UserViewHolder> {

    private List<FirebaseModel> list;
    private Context context;

    public FirebaseAdapter(List<FirebaseModel> list, Context context){
        this.list=list;
        this.context=context;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false));
    }

    @Override
    public void onBindViewHolder(final UserViewHolder holder, int position ){
        FirebaseModel user=list.get(position);
        holder.txt_tarla_adi.setText(user.getTarla_adi());
        holder.txt_ekin_turu.setText(user.getEkin_turu());
        holder.txt_ekin_tarihi.setText(user.getEkin_tarihi());
        holder.txt_son_sulama.setText(user.getSon_sulama());
        holder.txt_toprak_turu.setText(user.getToprak_turu());
    }

    @Override
    public int getItemCount(){
        return list.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        TextView txt_tarla_adi,txt_ekin_turu,txt_ekin_tarihi,txt_son_sulama,txt_toprak_turu;

        public UserViewHolder(View itemView){
            super(itemView);

            txt_tarla_adi=itemView.findViewById(R.id.degiskenTitle1);
            txt_ekin_turu=itemView.findViewById(R.id.degiskenTitle2);
            txt_ekin_tarihi=itemView.findViewById(R.id.degiskenTitle3);
            txt_son_sulama=itemView.findViewById(R.id.degiskenTitle4);
            txt_toprak_turu=itemView.findViewById(R.id.degiskenTitle5);
        }
    }
}
