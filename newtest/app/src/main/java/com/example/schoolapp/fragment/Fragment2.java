package com.example.schoolapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.schoolapp.R;
import com.example.schoolapp.modal.ChildItem;
import com.example.schoolapp.activities.MainPage;
import com.example.schoolapp.modal.ParentItem;
import com.example.schoolapp.adapter.FristAdp;

import java.util.ArrayList;
import java.util.List;


public class Fragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        RecyclerView ParentRecyclerViewItem = (RecyclerView) view.findViewById(R.id.rv_section);

        // Initialise the Linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager((MainPage)getActivity());

        // Pass the arguments
        // to the parentItemAdapter.
        // These arguments are passed
        // using a method ParentItemList()
        FristAdp parentItemAdapter = new FristAdp(ParentItemList());

        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        ParentRecyclerViewItem.setAdapter(parentItemAdapter);
        ParentRecyclerViewItem.setLayoutManager(layoutManager);
    return view;
    }

    private List<ParentItem> ParentItemList()
    {
        List<ParentItem> itemList = new ArrayList<>();

        ParentItem item = new ParentItem("10th Grade Sc - 5", ChildItemList());
        itemList.add(item);
        ParentItem item1 = new ParentItem("Title 2", ChildItemList());
        itemList.add(item1);
        ParentItem item2 = new ParentItem("Title 3", ChildItemList());
        itemList.add(item2);
        ParentItem item3 = new ParentItem("Title 4", ChildItemList());
        itemList.add(item3);

        return itemList;
    }

    // Method to pass the arguments
    // for the elements
    // of child RecyclerView
    private List<ChildItem> ChildItemList()
    {
        List<ChildItem> ChildItemList = new ArrayList<>();

        ChildItemList.add(new ChildItem("Card 1"));
        ChildItemList.add(new ChildItem("Card 2"));
        ChildItemList.add(new ChildItem("Card 3"));
        ChildItemList.add(new ChildItem("Card 4"));

        return ChildItemList;
    }
}

