package ohd.apps.bpcheckpoint;

import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {
    ImageView back_image, img, img2, img3, img4;
    ImageView scanning_bar;
    private ProgressBar bar;
    Animation mAnimation,aAnimation;
    private long then;
    private int longClickDuration = 2500;
    Timer t;
    TextView tv, tv1;
    int a = 1;
    int interval = 10;
    TimerTask tt;
    int min = 65;
    int max = 80;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scanning_bar = (ImageView) findViewById(R.id.scanning_bar);
        tv = (TextView) findViewById(R.id.text222);
        back_image = (ImageView) findViewById(R.id.imageView);
        scanning_bar.setVisibility(View.GONE);
        back_image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    a = 1;
                    t = new Timer();
                    tv.setText("Scanning...");
                    tv.setVisibility(View.VISIBLE);
                    then = (long) System.currentTimeMillis();
                    scanning_bar.setVisibility(View.VISIBLE);
                    mAnimation = new TranslateAnimation(0, 0, 100, -100);
                    mAnimation.setDuration(1000);
                    mAnimation.setRepeatCount(-1);
                    mAnimation.setRepeatMode(Animation.REVERSE);
                    mAnimation.setInterpolator(new LinearInterpolator());
                    scanning_bar.setAnimation(mAnimation);
                    tt = new TimerTask() {
                        @Override
                        public void run() {
                            if ((System.currentTimeMillis() - then) > longClickDuration) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (a == 1) {
                                            scanning_bar.clearAnimation();
                                            scanning_bar.setVisibility(View.INVISIBLE);
                                            scanning_bar.setVisibility(View.GONE);
                                            progress=new ProgressDialog(MainActivity.this);
                                            progress.setMessage("Calculating");
                                            progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                                            progress.setIndeterminate(true);
                                            progress.setProgress(0);
                                            progress.show();
                                            final int totalProgressTime = 100;
                                            final Thread t = new Thread() {
                                                @Override
                                                public void run() {
                                                    int jumpTime = 0;
                                                    while(jumpTime < totalProgressTime) {
                                                        try {
                                                            sleep(200);
                                                            jumpTime += 5;
                                                            progress.setProgress(jumpTime);
                                                        } catch (InterruptedException e) {
                                                            // TODO Auto-generated catch block
                                                            e.printStackTrace();
                                                        }
                                                    }
                                                }
                                            };
                                            t.start();
                                            new Handler().postDelayed(new Runnable() {

                                                public void run() {
                                                    Intent i = new Intent(MainActivity.this, ResultActivityMain.class);
                                                    startActivity(i);
                                                }
                                            }, 2000);
                                            a = 0;
                                        } else if (a == 0) {
                                        }
                                    }
                                });
                            }
                        }
                    };
                    t.schedule(tt, 5, 10);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    if ((System.currentTimeMillis() - then) > longClickDuration) {
		            /* Implement long click behavior here */
                        tv.setVisibility(View.GONE);
                        scanning_bar.clearAnimation();
                        scanning_bar.setVisibility(View.GONE);
                        return false;
                    } else {
		            /* Implement short click behavior here or do nothing */
                        scanning_bar.clearAnimation();
                        scanning_bar.setVisibility(View.GONE);
                        tv.setVisibility(View.VISIBLE);
                        tv.setText("Check Again");
                        tt.cancel();
                        t.cancel();
                        return true;
                    }
                }
                return true;

            }
        });

    }

        @Override
        public void onBackPressed() {
            Intent i=new Intent(MainActivity.this,FirstActivity.class);
            startActivity(i);
        }
    }

