package example.yunus.a13reasonswhy.Fragments;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import java.util.ArrayList;
import example.yunus.a13reasonswhy.Adapters.MusicAdapter;
import example.yunus.a13reasonswhy.Models.Music;
import example.yunus.a13reasonswhy.R;


public class MusicFragment extends Fragment {

    private String TAG="MUSIC";
    ListView listView;
    MusicAdapter musicAdapter;
    ArrayList<Music> musicArrayList=new ArrayList<>();
    private DatabaseReference firebaseDatabase;
    ProgressBar progressBar;
    public String [] songs={"music1","music2","music3","music4"};
    public MusicFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_music, container, false);
        firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Songs");
        progressBar= (ProgressBar) view.findViewById(R.id.progressBar);
        listView= (ListView) view.findViewById(R.id.musicList);
        musicAdapter=new MusicAdapter(getContext(),musicArrayList);
        listView.setAdapter(musicAdapter);
        fetchMusicList();
        return view;
    }

    public void fetchMusicList()
    {

        for (int i=0;i<songs.length;i++)
        {
            final Music music=new Music();
            firebaseDatabase.child(songs[i]).addListenerForSingleValueEvent(new ValueEventListener()
            {

                @Override
                public void onDataChange(final DataSnapshot dataSnapshot)
                {

                    music.setSong(String.valueOf(dataSnapshot.child("song").getValue()));
                    music.setSinger(String.valueOf(dataSnapshot.child("singer").getValue()));
                    music.setAlbumCover(String.valueOf(dataSnapshot.child("albumURL").getValue()));
                    music.setSongURL(String.valueOf(dataSnapshot.child("songURL").getValue()));
                    musicArrayList.add(music);
                    musicAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onCancelled(DatabaseError databaseError)
                {

                }
            });
        }


    }




}
