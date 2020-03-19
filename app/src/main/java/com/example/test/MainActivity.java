package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.* ;

import android.widget.*;


public class MainActivity extends AppCompatActivity {

    private TextView ask_name;
    private TextView ask_sex;
    private TextView ask_likes;
    private EditText name;
    private RadioGroup radioGroup;
    private RadioButton female;
    private RadioButton male;
    private CheckBox drama;
    private CheckBox play;
    private CheckBox song;
    private CheckBox sports;
    private ImageView image;
    private Button move;
    private  ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ask_name = (TextView) findViewById(R.id.ask_name);
        ask_sex = (TextView) findViewById(R.id.ask_sex);
        ask_likes = (TextView) findViewById(R.id.ask_likes);

        name = (EditText) findViewById(R.id.name);

        radioGroup=(RadioGroup)findViewById(R.id.radioGroupId);
        female=(RadioButton)findViewById(R.id.female);
        male=(RadioButton)findViewById(R.id.male);

        drama = (CheckBox) findViewById(R.id.drama);
        play = (CheckBox) findViewById(R.id.play);
        song = (CheckBox) findViewById(R.id.song);
        sports = (CheckBox) findViewById(R.id.sports);

        image=(ImageView)findViewById(R.id.image);
        move=(Button)findViewById(R.id.move);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);

        RadioButtonListener radioButtonListener=new RadioButtonListener();
        female.setOnCheckedChangeListener(radioButtonListener);
        male.setOnCheckedChangeListener(radioButtonListener);

        CheckBoxListener listener =new CheckBoxListener();
        drama.setOnCheckedChangeListener(listener);
        play.setOnCheckedChangeListener(listener);
        song.setOnCheckedChangeListener(listener);
        sports.setOnCheckedChangeListener(listener);

        image.setScaleType(ImageView.ScaleType.CENTER);
        progressBar.setMax(100);
        ButtonListener buttonListener=new ButtonListener();
        move.setOnClickListener(buttonListener);

    }
    class RadioButtonListener implements android.widget.CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b) Log.d("MainActivity", "onCheckedChanged: 选中");
            else Log.d("MainActivity", "onCheckedChanged: 取消选中");
            System.out.println("选中男性 ---->"+b);
        }
    }


    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b){
                switch(compoundButton.getId()){
                    case R.id.drama:
                        System.out.println("适度追剧有益身心，过度追剧劳心伤神。注意把握时间哦~");
                        Log.d("MAinActivity", "onCheckedChanged: 选择追剧" );
                        break;
                    case R.id.play:
                        System.out.println("游戏一会健智益脑，沉迷游戏伤眼伤身。把握好度哦~");
                        Log.d("MAinActivity", "onCheckedChanged: 选择打游戏");
                        break;
                    case R.id.song:
                        System.out.println("是个安静的美少女（年）呢！听会歌放松一下心情~");
                        Log.d("MAinActivity", "onCheckedChanged: 选择听歌");
                        break;
                    case R.id.sports:
                        System.out.println("真是个好孩子！多做运动减脂又健康哦~");
                        Log.d("MAinActivity", "onCheckedChanged: 选择做运动");
                        break;
                }

            }
            else{
                switch(compoundButton.getId()){
                    case R.id.drama:
                        Log.d("MAinActivity","取消选择追剧");break;
                    case R.id.play:
                        Log.d("MAinActivity", "取消选择打游戏");break;
                    case R.id.song:
                        Log.d("MAinActivity", "取消选择听歌");break;
                    case R.id.sports:
                        Log.d("MAinActivity", "取消选择做运动");break;
                }

            }
        }


    }

    class ButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            progressBar.incrementProgressBy(10);
            Log.d("MAinActivity", "onClick: 增加了10%");
        }
    }
}
