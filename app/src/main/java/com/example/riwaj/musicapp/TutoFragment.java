package com.example.riwaj.musicapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TutoFragment extends Fragment {
    RecyclerView rv;
    List<YouTubeVideos> youTubeVideos = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tutorial,null);
        rv=v.findViewById(R.id.recyclerView);

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setHasFixedSize(true);

        youTubeVideos.add(new YouTubeVideos("<iframe width='560' height='315' src='https://www.youtube.com/embed/egTNhyu-yFQ' frameborder='0' allow='autoplay; encrypted-media' allowfullscreen></iframe>"));

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        VideoAdapter videoAdapter=new VideoAdapter(youTubeVideos);
        rv.setAdapter(videoAdapter);
    }
}
