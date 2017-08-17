package example.yunus.a13reasonswhy.AppIntro;

/**
 * Created by yunus on 14.08.2017.
 */

import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import com.github.paolorotolo.appintro.AppIntro;

import example.yunus.a13reasonswhy.Activities.BaseActivity;
import example.yunus.a13reasonswhy.R;

public class MyIntro extends AppIntro
{
    @Override
    public void init(@Nullable Bundle savedInstanceState)
    {
        addSlide(Slides.newInstance(R.layout.intro1));
        addSlide(Slides.newInstance(R.layout.intro2));
        addSlide(Slides.newInstance(R.layout.intro3));



        showSkipButton(true);
        showStatusBar(false);
        setSkipText("ATLA");
        setDoneText("TAMAMLA");
        setVibrate(true);
        setVibrateIntensity(30);
        setDepthAnimation();

    }

    @Override
    public void onSkipPressed()
    {
        finish();
        startActivity(new Intent(this,BaseActivity.class));
    }

    @Override
    public void onNextPressed() {

    }

    @Override
    public void onDonePressed()
    {
        finish();
        startActivity(new Intent(this,BaseActivity.class));
    }

    @Override
    public void onSlideChanged()
    {

    }
}
