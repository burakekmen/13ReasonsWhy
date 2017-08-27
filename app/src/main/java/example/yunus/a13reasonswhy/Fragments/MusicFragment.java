package example.yunus.a13reasonswhy.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import example.yunus.a13reasonswhy.Adapters.MusicAdapter;
import example.yunus.a13reasonswhy.Models.Music;
import example.yunus.a13reasonswhy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicFragment extends Fragment {

    ListView listView;
    MusicAdapter musicAdapter;
    ArrayList<Music> musicArrayList=new ArrayList<>();;
    public MusicFragment()
    {
        // Required empty public constructor
    }
    //https://open.spotify.com/user/11131679308
    //https://open.spotify.com/user/11131679308/playlist/3NDM5KSpHC6R2tgRAVSsUX
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_music, container, false);
        listView= (ListView) view.findViewById(R.id.musicList);
        musicAdapter=new MusicAdapter(getContext(),musicArrayList);
        listView.setAdapter(musicAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String uri = "spotify:track:5aW6mgQmHPszfK1wyonSZi";
                Intent launcher = new Intent( Intent.ACTION_VIEW, Uri.parse(uri) );
                startActivity(launcher);
            }
        });
        return view;
    }

}
