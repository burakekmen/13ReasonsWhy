package example.yunus.a13reasonswhy;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    public List<String> list_parent;
    public ExpandListViewAdapter expand_adapter;
    public HashMap<String, List<String>> list_child;
    public ExpandableListView expandlist_view;
    public List<String> gs_list;
    public List<String> fb_list;
    public int last_position = -1;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        expandlist_view = (ExpandableListView)findViewById(R.id.expand_listview);

        Hazırla(); // expandablelistview içeriğini hazırlamak için

        // Adapter sınıfımızı oluşturmak için başlıklardan oluşan listimizi ve onlara bağlı olan elemanlarımızı oluşturmak için HaspMap türünü yolluyoruz
        expand_adapter = new ExpandListViewAdapter(getApplicationContext(), list_parent, list_child);
        expandlist_view.setAdapter(expand_adapter);  // oluşturduğumuz adapter sınıfını set ediyoruz
        expandlist_view.setClickable(true);

        expandlist_view.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                String child_name = (String)expand_adapter.getChild(groupPosition, childPosition);
                //Toast.makeText(getApplicationContext(),"hey" + child_name, Toast.LENGTH_LONG).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(child_name)
                        .setTitle("Mobilhanem Expandablelistview")
                        .setCancelable(false)
                        .setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();


                return false;
            }
        });


		/*
		expandlist_view.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {

				if(last_position != -1 && last_position != groupPosition)
				{
					expandlist_view.collapseGroup(last_position);
				}
				last_position = groupPosition;

			}
		});
		*/

    }
    public void Hazırla()
    {
        list_parent = new ArrayList<String>();  // başlıklarımızı listemelek için oluşturduk
        list_child = new HashMap<String, List<String>>(); // başlıklara bağlı elemenları tutmak için oluşturduk

        list_parent.add("GALATASARAY");  // ilk başlığı giriyoruz
        list_parent.add("FENERBAHCE");   // ikinci başlığı giriyoruz

        gs_list = new ArrayList<String>();  // ilk başlık için alt elemanları tanımlıyoruz
        gs_list.add("Muslera");
        gs_list.add("Sabri");
        gs_list.add("Chejdou");
        gs_list.add("Semih Kaya");
        gs_list.add("Telles");
        gs_list.add("Selçuk İnan");
        gs_list.add("Felipe Melo");
        gs_list.add("Hamit");
        gs_list.add("Weslej Sneijder");
        gs_list.add("Bruma");
        gs_list.add("Burak Yılmaz");

        fb_list = new ArrayList<String>(); // ikinci başlık için alt elemanları tanımlıyoruz
        fb_list.add("Volkan Demirel");
        fb_list.add("Gökhan Gönül");
        fb_list.add("Bekir");
        fb_list.add("Caner Erkin");
        fb_list.add("Mehmet Topal");
        fb_list.add("Emre");
        fb_list.add("Alper Potuk");
        fb_list.add("Mehmet Topuz");
        fb_list.add("Diego");
        fb_list.add("Sow");
        fb_list.add("Emenike");

        list_child.put(list_parent.get(0),gs_list); // ilk başlığımızı ve onların elemanlarını HashMap sınıfında tutuyoruz
        list_child.put(list_parent.get(1), fb_list); // ikinci başlığımızı ve onların elemanlarını HashMap sınıfında tutuyoruz


    }


}