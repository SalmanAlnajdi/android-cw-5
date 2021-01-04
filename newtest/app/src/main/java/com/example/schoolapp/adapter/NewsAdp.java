package com.example.schoolapp.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolapp.R;
import com.example.schoolapp.modal.News;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class NewsAdp extends RecyclerView.Adapter {

    ArrayList<News> nArray;
    Context context;
    LinearLayout linearLayout;

    public NewsAdp(ArrayList<News> nArray, Context context, LinearLayout linearLayout) {
        this.nArray = nArray;
        this.context = context;
        this.linearLayout = linearLayout;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((ViewHolder) holder).title.setText(nArray.get(position).getTitle());
        ((ViewHolder) holder).news.setText(nArray.get(position).getNews());


        final AlertDialog.Builder builder = new AlertDialog.Builder(context);


        ((ViewHolder) holder).tot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("Delete");
                builder.setMessage("Are you sure!!!");
                builder.setCancelable(false).setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        final News n = nArray.get(position);
                        nArray.remove(position);
                        notifyDataSetChanged();

                        Snackbar.make(linearLayout, "NEWs has been deleted", Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                nArray.add(n);
                                notifyDataSetChanged();
                            }
                        }).show();

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "hoooo", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                //  Snackbar.make(((ViewHolder) holder).linearLayout,"news has been deleted",Snackbar.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return nArray.size();
    }


    private class ViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView title;
        public TextView news;
        public ImageView tot;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            title = itemView.findViewById(R.id.title);
            news = itemView.findViewById(R.id.news);
            tot = itemView.findViewById(R.id.delete);
            linearLayout = itemView.findViewById(R.id.linearlayout);
        }
    }
}
