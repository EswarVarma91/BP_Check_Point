package ohd.apps.bpcheckpoint;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FirstActivity extends AppCompatActivity {
ImageView iv1,iv2,iv3,iv4;
    ImageView b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        iv1=(ImageView)findViewById(R.id.male1);
        iv2=(ImageView)findViewById(R.id.male2);
        iv3=(ImageView)findViewById(R.id.female1);
        iv4=(ImageView)findViewById(R.id.female2);
        b1=(ImageView) findViewById(R.id.button1);
        iv2.setVisibility(View.GONE);
        iv4.setVisibility(View.GONE);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv1.setVisibility(View.GONE);
                iv2.setVisibility(View.VISIBLE);
                iv3.setVisibility(View.VISIBLE);
                iv4.setVisibility(View.GONE);
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i=new Intent(FirstActivity.this,MainActivity.class);
                        startActivity(i);
                    }
                });
            }
        });
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv2.setVisibility(View.GONE);
                iv3.setVisibility(View.GONE);
                iv4.setVisibility(View.VISIBLE);
                iv1.setVisibility(View.VISIBLE);
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i=new Intent(FirstActivity.this,MainActivity.class);
                        startActivity(i);
                    }
                });
            }
        });


    }

    @Override
    public void onBackPressed() {
        System.exit(4);
    }
}
