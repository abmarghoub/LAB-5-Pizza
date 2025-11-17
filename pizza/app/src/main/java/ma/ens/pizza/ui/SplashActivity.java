package ma.ens.pizza.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import ma.ens.pizza.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        image = findViewById(R.id.image);

        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    RotateAnimation anim = new RotateAnimation(0.0f, 360.0f ,
                            Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
                    anim.setInterpolator(new LinearInterpolator());
                    anim.setRepeatCount(1);
                    anim.setDuration(500);
                    image.setAnimation(anim);
                    image.startAnimation(anim);
                    sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    Intent intent = new Intent(SplashActivity.this, ListPizzaActivity.class);
                    startActivity(intent);
                }
            }
        };
        t1.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.finish();
    }
}