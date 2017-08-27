package example.yunus.a13reasonswhy.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import example.yunus.a13reasonswhy.R;

public class InformationActivity extends AppCompatActivity {

    ImageButton backToBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("13 Reasons Why");
        setContentView(R.layout.activity_information);
        backToBase= (ImageButton) findViewById(R.id.backToBase);
        backToBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(InformationActivity.this,BaseActivity.class));
            }
        });
    }
}
