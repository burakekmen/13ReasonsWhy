package example.yunus.a13reasonswhy;

/**
 * Created by Eren on 16.8.2017.
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//expandable listview

import static example.yunus.a13reasonswhy.R.mipmap.ic_launcher;

public class ListViewWithImageAndText extends AppCompatActivity {

    // Array of strings for ListView Title
    String[] listviewTitle = new String[]{
            "Karakter 1", "Karakter 2", "Karakter 3", "Karakter 4",
            "Karakter 5", "Karakter 6", "Karaktere 7", "Karakter 8",
    };


    int[] listviewImage = new int[]{
            ic_launcher, ic_launcher, ic_launcher, ic_launcher,
            ic_launcher,ic_launcher,ic_launcher,ic_launcher    };

    String[] listviewShortDescription = new String[]{
            "Kısa karakter açıklaması", "Kısa karakter açıklaması", "Kısa karakter açıklaması", "Kısa karakter açıklaması",
            "Kısa karakter açıklaması", "Kısa karakter açıklaması", "Kısa karakter açıklaması", "Kısa karakter açıklaması",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_with_image_and_text);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 8; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            hm.put("listview_discription", listviewShortDescription[i]);
            hm.put("listview_image", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.karakterfoto, R.id.karakteradi, R.id.kisakarakteraciklamasi};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_activity, from, to);
        ListView androidListView = (ListView) findViewById(R.id.list_view);
        androidListView.setAdapter(simpleAdapter);
    }
}