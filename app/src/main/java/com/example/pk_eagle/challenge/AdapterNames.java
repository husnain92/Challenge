package com.example.pk_eagle.challenge;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by PK_Eagle on 9/27/2016.
 */

public class AdapterNames extends RecyclerView.Adapter<AdapterNames.ViewHolder> {
    public ArrayList<DataModel> listResult;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvFname, tvLname, tvComma;

        public ViewHolder(View v) {
            super(v);
            tvFname = (TextView) v.findViewById(R.id.tvFname);
            tvLname = (TextView) v.findViewById(R.id.tvLname);
            tvComma = (TextView) v.findViewById(R.id.tvComma);
        }
    }

    public void add(int position, DataModel item) {
        listResult.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(String item) {
        int position = listResult.indexOf(item);
        listResult.remove(position);
        notifyItemRemoved(position);
    }

    public AdapterNames(ArrayList<DataModel> myDataset) {
        listResult = myDataset;
    }

    @Override
    public AdapterNames.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvFname.setText(listResult.get(position).getFirstName());
        if (listResult.get(position).getLastName().length() > 0)
            holder.tvLname.setText(listResult.get(position).getLastName());
        else {
            holder.tvComma.setVisibility(View.GONE);
            holder.tvLname.setVisibility(View.GONE);
        }


    }

    @Override
    public int getItemCount() {
        return listResult.size();
    }

}
