package yop.wikitec.wikitec;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import org.apache.commons.io.IOUtils;

import com.felipecsl.gifimageview.library.GifImageView;

import java.io.IOException;
import java.io.InputStream;

public class GifActivity extends AppCompatActivity {
    private GifImageView gifImageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);
        gifImageView = (GifImageView)findViewById(R.id.gifImageView);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setVisibility(progressBar.VISIBLE);
        progressBar.getIndeterminateDrawable()
                .setColorFilter(Color.parseColor("#f4bc33"), PorterDuff.Mode.SRC_IN);

        //Set GIFImageView resource
        try{
            InputStream inputStream = getAssets().open("wikitecinicio1.gif");
            byte[] bytes = IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        }
        catch (IOException ex)
        {

        }

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    GifActivity.this.startActivity(new Intent(GifActivity.this,Inicio.class));
                    GifActivity.this.finish();
                }
            },5000); // 5000 = 5seconds

    }
}
