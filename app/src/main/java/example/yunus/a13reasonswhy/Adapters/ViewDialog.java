package example.yunus.a13reasonswhy.Adapters;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import example.yunus.a13reasonswhy.R;

/**
 * Created by yunus on 29.08.2017.
 */

public class ViewDialog
{

    private Context context;
    public void showDialog(Activity activity, final Context context)
    {
        this.context=context;
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_content);

        Button spotiftyButton = (Button) dialog.findViewById(R.id.btn_dialog);
        Button youtubeButton = (Button) dialog.findViewById(R.id.btn_dialog2);
        dialog.show();

        spotiftyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
                String uri= preferences.getString("uri","");
                Intent launcher = new Intent( Intent.ACTION_VIEW, Uri.parse(uri));
                context.startActivity(launcher);
                dialog.dismiss();

            }
        });

        youtubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();
            }
        });



    }


}
