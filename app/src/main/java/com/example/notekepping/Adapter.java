package com.example.notekepping;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.viewmodel> {

    private List<Note> list=new ArrayList<>();
    Context context;
    @NonNull
    @Override
    public viewmodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutmy,parent,false);
        context=parent.getContext();
        return new viewmodel(view);



    }

    @Override
    public void onBindViewHolder(@NonNull viewmodel holder, int position) {

        Note cuurennote=list.get(position);

        holder.title.setText(cuurennote.getTitle());
        holder.dis.setText(cuurennote.getDiscriptions());
        holder.number.setText(String.valueOf(cuurennote.getPrios()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(context,add.class);
                context.startActivity(it);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  void setNotes(List<Note> notes)
    {
        this.list=notes;
        notifyDataSetChanged();
    }

    public Note getNoteAt(int position)
    {
        return list.get(position);
    }

    public class viewmodel extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView dis;
        private TextView number;

        public viewmodel(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title1);
            dis=itemView.findViewById(R.id.des);
            number=itemView.findViewById(R.id.num);

        }
    }
}
