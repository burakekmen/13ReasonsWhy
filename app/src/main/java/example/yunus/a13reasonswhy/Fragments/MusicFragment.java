package example.yunus.a13reasonswhy.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.yunus.a13reasonswhy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicFragment extends Fragment {


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
        String uri = "spotify:track:5aW6mgQmHPszfK1wyonSZi";
        Intent launcher = new Intent( Intent.ACTION_VIEW, Uri.parse(uri) );
        startActivity(launcher);
        return view;
    }

}
