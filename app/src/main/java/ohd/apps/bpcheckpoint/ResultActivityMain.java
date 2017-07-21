package ohd.apps.bpcheckpoint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ResultActivityMain extends AppCompatActivity {
ImageView ig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_result);
        ig=(ImageView)findViewById(R.id.Home);

        int[] cards={R.drawable.rone,R.drawable.rtwo,R.drawable.rthree,R.drawable.rfour};
        Random r1 = new Random();
        int n = r1.nextInt(4);
        ImageView imageView = (ImageView)findViewById(R.id.imageView11);
        imageView.setImageResource(cards[n]);

        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ResultActivityMain.this,HomeActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(ResultActivityMain.this,MainActivity.class);
        startActivity(i);
    }
}
