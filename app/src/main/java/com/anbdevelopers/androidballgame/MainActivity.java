package com.anbdevelopers.androidballgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anb.androidballgame.R;

public class MainActivity extends AppCompatActivity
{
    TextView scoreTxt;
    TextView levelTxt;
    int score=0;
    int level=1;
    Handler handler;
    ImageView ball0;
    ImageView ball1;
    ImageView ball2;
    ImageView ball3;
    ImageView ball4;
    ImageView ball5;
    ImageView red_ball0;
    ImageView red_ball1;
    MediaPlayer popSound;
    MediaPlayer lostSound;
    AudioManager audioManager;
    //Orignal Positions x and y
    float posBall0x;
    float posBall0y;
    float posBall1x;
    float posBall1y;
    float posBall2x;
    float posBall2y;
    float posBall3x;
    float posBall3y;
    float posBall4x;
    float posBall4y;
    float posBall5x;
    float posBall5y;
    float red_ball0x;
    float red_ball0y;
    float red_ball1x;
    float red_ball1y;
    int streamMaxVolume;
    int currentVol;
    int newVol;
    int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioManager= (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        streamMaxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        currentVol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        newVol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        ball0 = findViewById(R.id.ball0);
        ball1 = findViewById(R.id.ball1);
        ball2 = findViewById(R.id.ball2);
        ball3 = findViewById(R.id.ball3);
        ball4 = findViewById(R.id.ball4);
        ball5 = findViewById(R.id.ball5);
        red_ball0=findViewById(R.id.red_ball_0);
        red_ball1 = findViewById(R.id.red_ball_1);
        scoreTxt=findViewById(R.id.score_txt);
        levelTxt = findViewById(R.id.level_txt);
        //Getting original positions x and y
        posBall0x = ball0.getTranslationX();
        posBall0y = ball0.getTranslationY();
        posBall1x = ball1.getTranslationX();
        posBall1y = ball1.getTranslationY();
        posBall2x = ball2.getTranslationX();
        posBall2y = ball2.getTranslationY();
        posBall3x = ball3.getTranslationX();
        posBall3y = ball3.getTranslationY();
        posBall4x = ball4.getTranslationX();
        posBall4y = ball4.getTranslationY();
        posBall5x = ball5.getTranslationX();
        posBall5y = ball5.getTranslationY();
        red_ball0x = red_ball0.getTranslationX();
        red_ball0y = red_ball0.getTranslationY();
        red_ball1x = red_ball1.getTranslationX();
        red_ball1y = red_ball1.getTranslationY();

        handler = new Handler(Looper.getMainLooper());

//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run()
//            {
//                playLevel1();
//            }
//        }, 10,100);

//        new Timer().scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//
//            }
//        },0,100);
    }
    public void ballClicked(View view)
    {

        if (popSound != null) {
            popSound.stop();
            popSound.release();
            popSound = null;
        }
        popSound = MediaPlayer.create(this,R.raw.pop);
        popSound.start();
        view.setVisibility(View.INVISIBLE);
        score++;
        popSound.start();
        checkScoreLevel();
    }
    public void redBallClicked(View view)
    {
        if (lostSound != null) {
            lostSound.stop();
            lostSound.release();
            lostSound = null;
        }
        lostSound = MediaPlayer.create(this,R.raw.lost);
        lostSound.start();
        Toast.makeText(this, "RED BALL CLICKED\nYOU LOOSE START AGAIN", Toast.LENGTH_LONG).show();
        handler.postDelayed(() -> playLevel1(), 1000);

    }
    private void checkScoreLevel()
    {
        scoreTxt.setText("Score = "+score);
        if (score==1)
        {
            resetViews();
            handler.postDelayed(this::playLevel2, 1000);

        }else if(score==3)
        {
            resetViews();
            handler.postDelayed(this::playLevel3, 1000);
        }else if(score==6)
        {
            resetViews();
            handler.postDelayed(this::playLevel4, 1000);
        }else if(score==9)
        {
            resetViews();
            handler.postDelayed(this::playLevel5, 1000);
        }else if(score==11)
        {
            resetViews();
            handler.postDelayed(this::playLevel6, 2000);
        } else if(score==15)
        {
            resetViews();
            handler.postDelayed(this::playLevel7, 2000);
        }else if(score==18)
        {
            resetViews();
            handler.postDelayed(this::playLevel8, 2500);
        }else if(score==23)
        {
            resetViews();
            handler.postDelayed(this::playLevel9, 2500);
        }else if (score==29)
        {
            resetViews();
            handler.postDelayed(this::playLevel10, 2000);
        }else if (score==35)
        {
            resetViews();
            levelTxt.setText("Congrats, You won");
        }
    }




    private void playLevel1()
    {
        resetViews();
        levelTxt.setText("Level 1");
        scoreTxt.setText("Score = 0");
        score=0;
        level=1;
        ball0.setVisibility(View.VISIBLE);
        ball0.animate().translationXBy(1200).setDuration(4000);
    }

    private void playLevel2()
    {
        resetViews();
        score=1;
        level=2;
        levelTxt.setText("Level 2");
        scoreTxt.setText("Score = "+score);
        ball0.setVisibility(View.VISIBLE);
        ball0.animate().translationXBy(1500).setDuration(4000);
        ball3.setVisibility(View.VISIBLE);
        ball3.animate().translationXBy(-1500).setDuration(4000);
    }
    private void playLevel3()
    {
        resetViews();
        score=3;
        level=3;
        levelTxt.setText("Level 3");
        scoreTxt.setText("Score = "+score);
        ball0.setVisibility(View.VISIBLE);
        ball0.animate().translationXBy(1500).translationYBy(1000).setDuration(4000);
        ball3.setVisibility(View.VISIBLE);
        ball3.animate().translationXBy(-1500).setDuration(3000);
        ball2.setVisibility(View.VISIBLE);
        ball2.animate().translationXBy(1500).setDuration(4000);

    }
    private void playLevel4()
    {
        resetViews();
        score=6;
        level=4;
        levelTxt.setText("Level 4");
        scoreTxt.setText("Score = "+score);
        ball0.setVisibility(View.VISIBLE);
        ball0.animate().translationXBy(1500).translationYBy(1000).setDuration(4000);
        ball1.setVisibility(View.VISIBLE);
        ball1.animate().translationXBy(1500).translationYBy(1000).setDuration(3500);
        ball2.setVisibility(View.VISIBLE);
        ball2.animate().translationXBy(1500).setDuration(4000);
        red_ball0.setVisibility(View.VISIBLE);
        red_ball0.animate().translationXBy(1500).translationYBy(1000).setDuration(3000);

    }
    private void playLevel5()
    {
        resetViews();
        score=9;
        level=5;
        levelTxt.setText("Level 5");
        scoreTxt.setText("Score = "+score);
        ball3.setVisibility(View.VISIBLE);
        ball3.animate().translationXBy(-1500).setDuration(3000);
        ball2.setVisibility(View.VISIBLE);
        ball2.animate().translationXBy(1500).setDuration(4000);
        red_ball0.setVisibility(View.VISIBLE);
        red_ball0.animate().translationXBy(1500).translationYBy(-1000).setDuration(4000);
    }
    private void playLevel6()
    {
        resetViews();
        score=11;
        level=6;
        levelTxt.setText("Level 6");
        scoreTxt.setText("Score = "+score);
        ball0.setVisibility(View.VISIBLE);
        ball0.animate().translationXBy(1500).setDuration(4000);
        ball3.setVisibility(View.VISIBLE);
        ball3.animate().translationXBy(-1500).setDuration(4000);
        ball2.setVisibility(View.VISIBLE);
        ball2.animate().translationXBy(1500).setDuration(4000);
        red_ball0.setVisibility(View.VISIBLE);
        red_ball0.animate().translationXBy(1500).translationYBy(-1000).setDuration(4000);
        ball5.setVisibility(View.VISIBLE);
        ball5.animate().translationYBy(-1500).setDuration(4000);
    }
    private void playLevel7()
    {
        resetViews();
        score=15;
        level=7;
        levelTxt.setText("Level 7");
        scoreTxt.setText("Score = "+score);
        ball3.setVisibility(View.VISIBLE);
        ball3.animate().translationXBy(-1500).setDuration(4000);
        ball2.setVisibility(View.VISIBLE);
        ball2.animate().translationXBy(1500).setDuration(4000);
        red_ball0.setVisibility(View.VISIBLE);
        red_ball0.animate().translationXBy(1500).translationYBy(-1000).setDuration(4000);
        red_ball1.setVisibility(View.VISIBLE);
        red_ball1.animate().translationXBy(-1500).translationYBy(1000).setDuration(4000);
        ball5.setVisibility(View.VISIBLE);
        ball5.animate().translationYBy(-1500).setDuration(4000);
    }
    private void playLevel8()
    {
        resetViews();
        score=18;
        level=8;
        levelTxt.setText("Level 8");
        scoreTxt.setText("Score = "+score);
        ball0.setVisibility(View.VISIBLE);
        ball0.animate().translationYBy(1000).setDuration(4000);
        ball1.setVisibility(View.VISIBLE);
        ball1.animate().translationXBy(1500).translationYBy(1000).setDuration(3500);
        ball3.setVisibility(View.VISIBLE);
        ball3.animate().translationXBy(-1500).setDuration(4000);
        ball2.setVisibility(View.VISIBLE);
        ball2.animate().translationXBy(1500).setDuration(4000);
        red_ball1.setVisibility(View.VISIBLE);
        red_ball1.animate().translationXBy(-1500).translationYBy(1000).setDuration(4000);
        ball5.setVisibility(View.VISIBLE);
        ball5.animate().translationYBy(-1500).setDuration(4000);
    }

    private void playLevel9()
    {
        resetViews();
        score=23;
        level=9;
        levelTxt.setText("Level 9");
        scoreTxt.setText("Score = "+score);
        ball0.setVisibility(View.VISIBLE);
        ball0.animate().translationXBy(1500).setDuration(4000);
        ball1.setVisibility(View.VISIBLE);
        ball1.animate().translationXBy(1500).setDuration(4000);
        ball2.setVisibility(View.VISIBLE);
        ball2.animate().translationXBy(1500).setDuration(4000);
        red_ball0.setVisibility(View.VISIBLE);
        red_ball0.animate().translationXBy(1500).setDuration(4000);
        red_ball1.setVisibility(View.VISIBLE);
        red_ball1.animate().translationXBy(-1500).setDuration(4000);
        red_ball1.setVisibility(View.VISIBLE);
        red_ball1.animate().translationXBy(-1500).setDuration(4000);
        ball3.setVisibility(View.VISIBLE);
        ball3.animate().translationXBy(-1500).setDuration(4000);
        ball4.setVisibility(View.VISIBLE);
        ball4.animate().translationXBy(-1500).setDuration(4000);
        ball5.setVisibility(View.VISIBLE);
        ball5.animate().translationXBy(-1500).setDuration(4000);

    }
    private void playLevel10()
    {
        resetViews();
        score=29;
        level=10;
        levelTxt.setText("Level 10");
        scoreTxt.setText("Score = "+score);
        ball0.setVisibility(View.VISIBLE);
        ball0.animate().translationXBy(1500).translationYBy(1000).setDuration(4000);
        ball1.setVisibility(View.VISIBLE);
        ball1.animate().translationXBy(1500).setDuration(4000);
        ball2.setVisibility(View.VISIBLE);
        ball2.animate().translationXBy(1500).setDuration(4000);
        red_ball0.setVisibility(View.VISIBLE);
        red_ball0.animate().translationXBy(1500).translationYBy(-1000).setDuration(3000);
        red_ball1.setVisibility(View.VISIBLE);
        red_ball1.animate().translationXBy(-1500).setDuration(3000);
        red_ball1.setVisibility(View.VISIBLE);
        red_ball1.animate().translationXBy(-1500).setDuration(4000);
        ball3.setVisibility(View.VISIBLE);
        ball3.animate().translationXBy(-1500).setDuration(4000);
        ball4.setVisibility(View.VISIBLE);
        ball4.animate().translationXBy(-1500).setDuration(4000);
        ball5.setVisibility(View.VISIBLE);
        ball5.animate().translationXBy(-1500).translationYBy(-1000).setDuration(4000);

    }
    private void resetViews()
    {

        //Resetting all balls to original positions
        ball0.clearAnimation();
        ball0.setTranslationX(posBall0x);
        ball0.setTranslationY(posBall0y);
        ball0.setVisibility(View.INVISIBLE);

        ball1.clearAnimation();
        ball1.setTranslationX(posBall1x);
        ball1.setTranslationY(posBall1y);
        ball1.setVisibility(View.INVISIBLE);

        ball2.clearAnimation();
        ball2.setTranslationX(posBall2x);
        ball2.setTranslationY(posBall2y);
        ball2.setVisibility(View.INVISIBLE);

        ball3.clearAnimation();
        ball3.setTranslationX(posBall3x);
        ball3.setTranslationY(posBall3y);
        ball3.setVisibility(View.INVISIBLE);

        ball4.clearAnimation();
        ball4.setTranslationX(posBall4x);
        ball4.setTranslationY(posBall4y);
        ball4.setVisibility(View.INVISIBLE);

        ball5.clearAnimation();
        ball5.setTranslationX(posBall5x);
        ball5.setTranslationY(posBall5y);
        ball5.setVisibility(View.INVISIBLE);

        red_ball0.clearAnimation();
        red_ball0.setTranslationX(red_ball0x);
        red_ball0.setTranslationY(red_ball0y);
        red_ball0.setVisibility(View.INVISIBLE);

        red_ball1.clearAnimation();
        red_ball1.setTranslationX(red_ball1x);
        red_ball1.setTranslationY(red_ball1y);
        red_ball1.setVisibility(View.INVISIBLE);
    }
    public void restartGame(View view)
    {
        resetViews();
        playLevel1();
    }
// NEXT LEVEL WILL BE TRIGGERED BY PRESSING VOLUME KEY OR BY COMPLETING LEVEL
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    nextLevel(level);
                    level++;
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_UP) {
                    nextLevel(level);
                    level++;

                }
                return true;

            default:
                return super.dispatchKeyEvent(event);
        }
    }
    public void restartLevel(View view)
    {
        if (level==1)
        {
            resetViews();
            playLevel1();
        }else if (level==2)
        {
            resetViews();
            playLevel2();
        }else if(level==3)
        {
            resetViews();
            playLevel3();
        }else if(level==4)
        {
            resetViews();
            playLevel4();
        }else if(level==5)
        {
            resetViews();
            playLevel5();
        }else if(level==6)
        {
            resetViews();
            playLevel6();
        }else if(level==7)
        {
            resetViews();
            playLevel7();
        }else if(level==8)
        {
            resetViews();
            playLevel8();
        }else if(level==9)
        {
            resetViews();
            playLevel9();
        }
        else if(level==10)
        {
            resetViews();
            playLevel10();
        }

    }

    public void nextLevel(int l)
    {
        if (l==1)
        {
            resetViews();
            playLevel1();
        }else if (l==2)
        {
            resetViews();
            playLevel2();
        }else if(l==3)
        {
            resetViews();
            playLevel3();
        }else if(l==4)
        {
            resetViews();
            playLevel4();
        }else if(l==5)
        {
            resetViews();
            playLevel5();
        }else if(l==6)
        {
            resetViews();
            playLevel6();
        }else if(l==7)
        {
            resetViews();
            playLevel7();
        }else if(l==8)
        {
            resetViews();
            playLevel8();
        }else if(l==9)
        {
            resetViews();
            playLevel9();
        }
        else if(l==10)
        {
            resetViews();
            playLevel10();
        }

    }
}