package edu.whiteake19up.carstereo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;


public class CarStereo extends AppCompatActivity implements View.OnClickListener {

    private ImageButton on_button;
    private TextView cd_deck;

    private Button preset_1;
    private Button preset_2;
    private Button preset_3;
    private Button preset_4;
    private Button preset_5;
    private Button preset_6;
    private Button prev_button;
    private Button pause_button;
    private Button next_button;
    private ToggleButton am_fm;
    private TextView tuner_value;
    private SeekBar tuner;
    private int preset_value_fm1 = 0;
    private int preset_value_am1 = 0;
    private int preset_value_fm2 = 0;
    private int preset_value_am2 = 0;
    private int preset_value_fm3 = 0;
    private int preset_value_am3 = 0;
    private int preset_value_fm4 = 0;
    private int preset_value_am4 = 0;
    private int preset_value_fm5 = 0;
    private int preset_value_am5 = 0;
    private int preset_value_fm6 = 0;
    private int preset_value_am6 = 0;
    private Button volume_up;
    private Button volume_down;
    private ProgressBar volume_display;
    private boolean on = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_stereo);

        on_button = (ImageButton)findViewById(R.id.on_Button);
        on_button.setOnClickListener(this);

        cd_deck = (TextView)findViewById(R.id.cd_deck);
        cd_deck.setOnClickListener(this);

        volume_display = (ProgressBar)findViewById(R.id.volume_display);
        volume_display.setOnClickListener(this);

        prev_button = (Button) findViewById(R.id.prev_button);
        prev_button.setOnClickListener(this);

        pause_button = (Button) findViewById(R.id.pause_button);
        pause_button.setOnClickListener(this);

        next_button = (Button) findViewById(R.id.next_button);
        next_button.setOnClickListener(this);

        preset_1 = (Button) findViewById(R.id.preset_1);
        preset_1.setOnClickListener(this);
        preset_1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(am_fm.isChecked()){
                    preset_value_am1 = tuner.getProgress();
                }
                else{
                    preset_value_fm1 = tuner.getProgress();
                }
                return false;
            }
        });

        preset_2 = (Button) findViewById(R.id.preset_2);
        preset_2.setOnClickListener(this);
        preset_2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(am_fm.isChecked()){
                    preset_value_am2 = tuner.getProgress();
                }
                else{
                    preset_value_fm2 = tuner.getProgress();
                }
                return false;
            }
        });

        preset_3 = (Button) findViewById(R.id.preset_3);
        preset_3.setOnClickListener(this);
        preset_3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(am_fm.isChecked()){
                    preset_value_am3 = tuner.getProgress();
                }
                else{
                    preset_value_fm3 = tuner.getProgress();
                }
                return false;
            }
        });

        preset_4 = (Button) findViewById(R.id.preset_4);
        preset_4.setOnClickListener(this);
        preset_4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(am_fm.isChecked()){
                    preset_value_am4 = tuner.getProgress();
                }
                else{
                    preset_value_fm4 = tuner.getProgress();
                }
                return false;
            }
        });

        preset_5 = (Button) findViewById(R.id.preset_5);
        preset_5.setOnClickListener(this);
        preset_5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(am_fm.isChecked()){
                    preset_value_am5 = tuner.getProgress();
                }
                else{
                    preset_value_fm5 = tuner.getProgress();
                }
                return false;
            }
        });

        preset_6 = (Button) findViewById(R.id.preset_6);
        preset_6.setOnClickListener(this);
        preset_1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(am_fm.isChecked()){
                    preset_value_am6 = tuner.getProgress();
                }
                else{
                    preset_value_fm6 = tuner.getProgress();
                }
                return false;
            }
        });

        tuner_value = (TextView) findViewById(R.id.tuner_value);

        tuner = (SeekBar) findViewById(R.id.tuner);
        tuner.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {

                if(am_fm.isChecked()){
                    tuner_value.setText( (tuner.getProgress() + 530) + "kHz");
                }
                else{
                    int station = tuner.getProgress() + 881;
                    tuner_value.setText( station/10 + "." + station%10 + "MHz");
                }

            }
        });

        am_fm = (ToggleButton) findViewById(R.id.am_fm);
        am_fm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tuner.setMax(1170);
                    tuner.incrementProgressBy(10);


                } else {
                    tuner.setMax(198);
                    tuner.incrementProgressBy(2);
                }
            }
        });

        volume_up = (Button) findViewById(R.id.volume_up);
        volume_up.setOnClickListener(this);

        volume_down = (Button) findViewById(R.id.volume_down);
        volume_down.setOnClickListener(this);

        volume_display = (ProgressBar) findViewById(R.id.volume_display);
    }

    @Override
    public void onClick(View view) {
        int on_color = Color.rgb(103 , 198, 230);
        if(!on){
            on_button.setBackgroundColor(on_color);
            cd_deck.setBackgroundColor(on_color);
            volume_display.setBackgroundColor(on_color);
            prev_button.setTextColor(on_color);
            pause_button.setTextColor(on_color);
            next_button.setTextColor(on_color);



        }
        else if(view.getId() == R.id.on_Button){
            on_button.setBackgroundColor(Color.WHITE);
            cd_deck.setBackgroundColor(Color.GRAY);
            volume_display.setBackgroundColor(Color.GRAY);
            prev_button.setTextColor(Color.BLACK);
            pause_button.setTextColor(Color.BLACK);
            next_button.setTextColor(Color.BLACK);
            on = false;
        }
        if(on){
            if(view.getId() == R.id.volume_up){
                volume_display.setProgress(volume_display.getProgress() + 1);
            }
            if(view.getId() == R.id.volume_down){
                volume_display.setProgress(volume_display.getProgress() - 1);
            }
        }
        switch (view.getId()) {

            case R.id.preset_1:
                if(am_fm.isChecked()){
                    if(preset_value_am1 != 0){
                        tuner.setProgress(preset_value_am1);
                    }
                    else{
                        tuner.setProgress(20);
                    }

                }
                else{
                    if(preset_value_fm1 != 0){
                        tuner.setProgress(preset_value_fm1);
                    }
                    else{
                        tuner.setProgress(28);
                    }

                }
                break;

            case R.id.preset_2:
                if(am_fm.isChecked()){
                    if(preset_value_am2 != 0){
                        tuner.setProgress(preset_value_am2);
                    }
                    else{
                        tuner.setProgress(70);
                    }

                }
                else{
                    if(preset_value_fm2 != 0){
                        tuner.setProgress(preset_value_fm2);
                    }
                    else{
                        tuner.setProgress(48);
                    }

                }
                break;

            case R.id.preset_3:
                if(am_fm.isChecked()){
                    if(preset_value_am3 != 0){
                        tuner.setProgress(preset_value_am3);
                    }
                    else{
                        tuner.setProgress(120);
                    }

                }
                else{
                    if(preset_value_fm3 != 0){
                        tuner.setProgress(preset_value_fm3);
                    }
                    else
                        tuner.setProgress(68);
                }
                break;
            case R.id.preset_4:
                if(am_fm.isChecked()){
                    if(preset_value_am4 != 0){
                        tuner.setProgress(preset_value_am4);
                    }
                    else
                        tuner.setProgress(170);
                }
                else{
                    if(preset_value_fm4 != 0){
                        tuner.setProgress(preset_value_fm4);
                    }
                    else
                        tuner.setProgress(88);
                }
                break;
            case R.id.preset_5:
                if(am_fm.isChecked()){
                    if(preset_value_am5 != 0){
                        tuner.setProgress(preset_value_am5);
                    }
                    else
                        tuner.setProgress(220);
                }
                else{
                    if(preset_value_fm5 != 0){
                        tuner.setProgress(preset_value_fm5);
                    }
                    else
                        tuner.setProgress(108);
                }
                break;
            case R.id.preset_6:
                if(am_fm.isChecked()){
                    if(preset_value_am6 != 0){
                        tuner.setProgress(preset_value_am6);
                    }
                    else
                        tuner.setProgress(270);
                }
                else{
                    if(preset_value_fm6 != 0){
                        tuner.setProgress(preset_value_fm6);
                    }
                    else
                        tuner.setProgress(128);
                }
                break;

            default:
                on = true;
                break;
        }


    }




}
