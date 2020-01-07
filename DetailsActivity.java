package com.example.altkamulassesignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class DetailsActivity extends AppCompatActivity {
    String Title,URL,ABSTACT,DATE;
    ImageView picture;
    TextView date,TITLE,ABS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        picture =findViewById(R.id.img_product_cat);
        date = findViewById(R.id.txt_notification_day);
      TITLE = findViewById(R.id.txt_notification_title);
        ABS = findViewById(R.id.txt_notification_body);



        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.containsKey("prdId")) {
                Title= bundle.getString("Title", "");
               DATE= bundle.getString("Date", "");
                URL= bundle.getString("Picture", "");
               ABSTACT= bundle.getString("Abstract", "");
            }
        }
        Glide.with(DetailsActivity.this).load(URL).into(picture);
        date.setText(DATE);
        ABS.setText(ABSTACT);
        TITLE.setText(Title);
    }
}
