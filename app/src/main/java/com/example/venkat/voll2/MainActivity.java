package com.example.venkat.voll2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    public List<Song> songs = new ArrayList<>();
    StringRequest request;
    RequestQueue queue;
    Recyclerviewadapter adapter;
    String url="http://starlord.hackerearth.com/studio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =(RecyclerView)findViewById(R.id.Recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        songs.add("Hello");
//        songs.add("World");
//        Recyclerviewadapter x = new Recyclerviewadapter(Song);
//        recyclerView.setAdapter(x);
        getsongs();

    }

    public void getsongs(){
        queue= Volley.newRequestQueue(this);
        request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("mainactivity",response);
                try {
                    JSONArray root = new JSONArray(response);
                    for(int i =0;i<root.length();i++){
                        JSONObject songinfo = root.optJSONObject(i);
                        String song_name = songinfo.optString("song");
                        String song_artist = songinfo.optString("artist");
                        songs.add(new Song(song_name,song_artist));
                    }
                    adapter=new Recyclerviewadapter(songs,MainActivity.this);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }
}
