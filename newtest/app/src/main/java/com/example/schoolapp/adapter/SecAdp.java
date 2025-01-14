package com.example.schoolapp.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolapp.R;
import com.example.schoolapp.modal.ChildItem;
import com.example.schoolapp.modal.ParentItem;

import java.util.List;

public class SecAdp extends RecyclerView.Adapter<SecAdp.ChildViewHolder> {

private List<ChildItem> ChildItemList;



    // Constuctor
        SecAdp(List<ChildItem> childItemList)
        {
        this.ChildItemList = childItemList;
        }

@NonNull
@Override
public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
        {

        // Here we inflate the corresponding
        // layout of the child item
        View view = LayoutInflater
        .from(viewGroup.getContext())
        .inflate(
        R.layout.child_item,
        viewGroup, false);



        return new ChildViewHolder(view);
        }


    @Override
public void onBindViewHolder(
@NonNull ChildViewHolder childViewHolder,
        int position)
        {

        // Create an instance of the ChildItem
        // class for the given position
        ChildItem childItem = ChildItemList.get(position);

        // For the created instance, set title.
        // No need to set the image for
        // the ImageViews because we have
        // provided the source for the images
        // in the layout file itself
        childViewHolder.ChildItemTitle.setText(childItem.getChildItemTitle());
        }

@Override
public int getItemCount()
        {

        // This method returns the number
        // of items we have added
        // in the ChildItemList
        // i.e. the number of instances
        // of the ChildItemList
        // that have been created
        return ChildItemList.size();
        }

// This class is to initialize
// the Views present
// in the child RecyclerView
class ChildViewHolder
        extends RecyclerView.ViewHolder {

    TextView ChildItemTitle;

    ChildViewHolder(View itemView)
    {
        super(itemView);
        ChildItemTitle = itemView.findViewById(R.id.child_item_title);
    }
}
}
