package info.androidhive.retrofit.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.koushikdutta.ion.Ion;

import info.androidhive.retrofit.R;

public class PosterActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.poster);

    Intent intent = getIntent();
    String path= intent.getStringExtra("posterPath");
    ImageView image = (ImageView) findViewById(R.id.imageView);
    Ion.with(image)
      .load("http://image.tmdb.org/t/p/w640/" + path);
  }
}
