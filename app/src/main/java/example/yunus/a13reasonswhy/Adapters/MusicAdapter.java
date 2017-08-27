package example.yunus.a13reasonswhy.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import example.yunus.a13reasonswhy.Models.Music;
import example.yunus.a13reasonswhy.R;

/**
 * Created by yunus on 23.08.2017.
 */

public class MusicAdapter extends BaseAdapter
{
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Music> musicList;

    public MusicAdapter(Context context,ArrayList<Music> musicList)
    {
        this.context=context;
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.musicList=musicList;
    }

    @Override
    public int getCount()
    {
        return musicList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return musicList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view=layoutInflater.inflate(R.layout.card_music,parent,false);
        TextView title= (TextView) view.findViewById(R.id.title);
        title.setText(context.getResources().getString(R.string.music_definition,
                                                musicList.get(position).getSong(),
                                                musicList.get(position).getSinger()));

        return view;
    }
}
