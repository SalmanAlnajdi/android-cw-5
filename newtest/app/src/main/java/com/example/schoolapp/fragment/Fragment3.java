package com.example.schoolapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.schoolapp.R;
import com.example.schoolapp.activities.MainPage;
import com.example.schoolapp.modal.News;
import com.example.schoolapp.adapter.NewsAdp;

import java.util.ArrayList;


public class Fragment3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);

        ArrayList<News> newsList = new ArrayList<>();

        News n1 = new News("fire","blaaa blaaa blaa");
        News n2 = new News("fire","blaaa blaaa blaa");
        News n3 = new News("fire","blaaa blaaa blaa");

        newsList.add(n1);
        newsList.add(n2);
        newsList.add(n3);


        RecyclerView newsL = (RecyclerView) view.findViewById(R.id.rv_news);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearlayout);

        newsL.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager((MainPage)getActivity());
        newsL.setLayoutManager(lm);

        NewsAdp na = new NewsAdp(newsList, (MainPage)getActivity(),linearLayout);
        newsL.setAdapter(na);

        return view;
    }

}