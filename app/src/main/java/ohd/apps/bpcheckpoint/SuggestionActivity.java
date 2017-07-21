package ohd.apps.bpcheckpoint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SuggestionActivity extends AppCompatActivity {
ImageView ig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        ig=(ImageView)findViewById(R.id.homesuggestion);
        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SuggestionActivity.this,HomeActivity.class);
                startActivity(i);
            }
        });
    }
}
