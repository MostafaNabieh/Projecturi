package com.example.projecturi;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bu_website,bu_location,bu_share;
    EditText ed_share,ed_website,ed_location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bu_location=findViewById(R.id.bu_location);
        bu_website=findViewById(R.id.bu_website);
        bu_share=findViewById(R.id.bu_website);
        ed_website=findViewById(R.id.ed_website);
        ed_location=findViewById(R.id.ed_location);
        ed_share=findViewById(R.id.ed_share);
        bu_location.setOnClickListener(this);
        bu_website.setOnClickListener(this);
        bu_share.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v == bu_website)
        {
            openwebsite();
        }
        if(v == bu_location)
        {
            openlocation();
        }
        if(v == bu_share)
        {
            openshare();
        }

    }

    private void openshare() {
        String txt=ed_share.getText().toString();
        String type="text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(type)
                .setChooserTitle("Share")
                .setText(txt)
                .startChooser();

    }

    private void openlocation() {
        String loc=ed_location.getText().toString();
        Uri locuri=Uri.parse("geo:0,0?q="+loc);
        Intent intent=new Intent(Intent.ACTION_VIEW,locuri);
        if(intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }

    }

    private void openwebsite() {
        String url =ed_website.getText().toString();
        Uri weburi=Uri.parse(url);
        Intent intent=new Intent(Intent.ACTION_VIEW,weburi);
        if(intent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(intent);
        }


    }
}
