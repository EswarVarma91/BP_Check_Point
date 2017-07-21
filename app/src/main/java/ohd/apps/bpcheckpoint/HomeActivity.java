package ohd.apps.bpcheckpoint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {
ImageView iv1,iv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        iv1=(ImageView)findViewById(R.id.checkyourbp);
        iv2=(ImageView)findViewById(R.id.suggestionbox);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(HomeActivity.this,FirstActivity.class);
                startActivity(i);
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(HomeActivity.this,SuggestionActivity.class);
                startActivity(i);
            }
        });
    }
}
