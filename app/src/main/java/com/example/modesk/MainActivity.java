package com.example.modesk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;

    TextView mPlugStatus1;
    TextView mPlugStatus2;
    TextView mPlugStatus3;
    TextView mPlugStatus4;
    TextView mPlugStatus5;
    TextView mLockText;

    ImageView mPlugStatusIcon1;
    ImageView mPlugStatusIcon2;
    ImageView mPlugStatusIcon3;
    ImageView mPlugStatusIcon4;
    ImageView mPlugStatusIcon5;
    ImageView mLockIcon;

    Switch mSwitch1;
    Switch mSwitch2;
    Switch mSwitch3;
    Switch mSwitch4;
    Switch mSwitch5;
    Switch mLockSwitch;

    ImageView mVoiceIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--------------------------------------------- VARIABLE ASSIGNMENT ---------------------------------------

        mLockText = findViewById(R.id.lockText);

        mPlugStatus1 = findViewById(R.id.plugStatus1);
        mPlugStatus2 = findViewById(R.id.plugStatus2);
        mPlugStatus3 = findViewById(R.id.plugStatus3);
        mPlugStatus4 = findViewById(R.id.plugStatus4);
        mPlugStatus5 = findViewById(R.id.plugStatus5);

        mPlugStatusIcon1 = findViewById(R.id.plugStatusIcon1);
        mPlugStatusIcon2 = findViewById(R.id.plugStatusIcon2);
        mPlugStatusIcon3 = findViewById(R.id.plugStatusIcon3);
        mPlugStatusIcon4 = findViewById(R.id.plugStatusIcon4);
        mPlugStatusIcon5 = findViewById(R.id.plugStatusIcon5);
        mLockIcon = findViewById(R.id.lockIcon);

        mSwitch1 = findViewById(R.id.switch1);
        mSwitch2 = findViewById(R.id.switch2);
        mSwitch3 = findViewById(R.id.switch3);
        mSwitch4 = findViewById(R.id.switch4);
        mSwitch5 = findViewById(R.id.switch5);
        mLockSwitch = findViewById(R.id.lockSwitch);

        //---------------------------------------------- SWITCH EVENT LISTENER --------------------------------

        // Switch 1
        mSwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mSwitch1.isChecked()){
                    mPlugStatusIcon1.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lighton));
                    mPlugStatus1.setText("Plug 1 status: ON");
                    mSwitch1.setChecked(true);

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference plug1Status = database.getReference("database/plug 1");
                    plug1Status.setValue(1);
                }
                else {
                    mPlugStatusIcon1.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lightoff));
                    mPlugStatus1.setText("Plug 1 status: OFF");
                    mSwitch1.setChecked(false);

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference plug1Status = database.getReference("database/plug 1");
                    plug1Status.setValue(0);
                }
            }
        });

        // Switch 2
        mSwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mSwitch2.isChecked()){
                    mPlugStatusIcon2.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lighton));
                    mPlugStatus2.setText("Plug 2 status: ON");
                    mSwitch2.setChecked(true);

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference plug2Status = database.getReference("database/plug 2");
                    plug2Status.setValue(1);
                }
                else {
                    mPlugStatusIcon2.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lightoff));
                    mPlugStatus2.setText("Plug 2 status: OFF");
                    mSwitch2.setChecked(false);

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference plug2Status = database.getReference("database/plug 2");
                    plug2Status.setValue(0);
                }
            }
        });

        // Switch 3
        mSwitch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mSwitch3.isChecked()){
                    mPlugStatusIcon3.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lighton));
                    mPlugStatus3.setText("Plug 3 status: ON");
                    mSwitch3.setChecked(true);

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference plug3Status = database.getReference("database/plug 3");
                    plug3Status.setValue(1);
                }
                else {
                    mPlugStatusIcon3.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lightoff));
                    mPlugStatus3.setText("Plug 2 status: OFF");
                    mSwitch3.setChecked(false);

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference plug3Status = database.getReference("database/plug 3");
                    plug3Status.setValue(0);
                }
            }
        });

        // Switch 4
        mSwitch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mSwitch4.isChecked()){
                    mPlugStatusIcon4.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lighton));
                    mPlugStatus4.setText("Plug 4 status: ON");
                    mSwitch4.setChecked(true);

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference plug4Status = database.getReference("database/plug 4");
                    plug4Status.setValue(1);
                }
                else {
                    mPlugStatusIcon4.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lightoff));
                    mPlugStatus4.setText("Plug 4 status: OFF");
                    mSwitch4.setChecked(false);

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference plug4Status = database.getReference("database/plug 4");
                    plug4Status.setValue(0);
                }
            }
        });

        // Switch 5
        mSwitch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mSwitch5.isChecked()){
                    mPlugStatusIcon5.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lighton));
                    mPlugStatus5.setText("Plug 5 status: ON");
                    mSwitch5.setChecked(true);

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference plug5Status = database.getReference("database/plug 5");
                    plug5Status.setValue(1);
                }
                else {
                    mPlugStatusIcon5.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lightoff));
                    mPlugStatus5.setText("Plug 4 status: OFF");
                    mSwitch5.setChecked(false);

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference plug5Status = database.getReference("database/plug 5");
                    plug5Status.setValue(0);
                }
            }
        });

        //---------------------------------------------- LOCK EVENT LISTENER --------------------------------

        mLockSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mLockSwitch.isChecked()){
                    mLockIcon.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lock));
                    mLockText.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.green));
                    mLockSwitch.setChecked(true);

                    mSwitch1.setEnabled(false);
                    mSwitch2.setEnabled(false);
                    mSwitch3.setEnabled(false);
                    mSwitch4.setEnabled(false);
                    mSwitch5.setEnabled(false);

                    mVoiceIcon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "You are in locked mode", Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                    });

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference plug1Status = database.getReference("database/lock");
                    plug1Status.setValue(1);
                }
                else {
                    mLockIcon.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.unlock));
                    mLockText.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                    mLockSwitch.setChecked(false);

                    mSwitch1.setEnabled(true);
                    mSwitch2.setEnabled(true);
                    mSwitch3.setEnabled(true);
                    mSwitch4.setEnabled(true);
                    mSwitch5.setEnabled(true);

                    mVoiceIcon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            speak();
                        }
                    });

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference plug1Status = database.getReference("database/lock");
                    plug1Status.setValue(0);
                }
            }
        });

        //--------------------------------------------- PLUG STATUS CHECKER ------------------------------------

        // Declare Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // Plug 1
        DatabaseReference plug1 = database.getReference("database/plug 1");
        plug1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Integer statusPlug1 = snapshot.getValue(Integer.class);

                assert statusPlug1 != null;
                if (statusPlug1.equals(1)){
                    mPlugStatusIcon1.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lighton));
                    mPlugStatus1.setText("Plug 1 status: ON");
                    mSwitch1.setChecked(true);
                }
                else if (statusPlug1.equals(0)){
                    mPlugStatusIcon1.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lightoff));
                    mPlugStatus1.setText("Plug 1 status: OFF");
                    mSwitch1.setChecked(false);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Do nothing
            }
        });

        // Plug 2
        DatabaseReference plug2 = database.getReference("database/plug 2");
        plug2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Integer statusPlug2 = snapshot.getValue(Integer.class);

                assert statusPlug2 != null;
                if (statusPlug2.equals(1)){
                    mPlugStatusIcon2.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lighton));
                    mPlugStatus2.setText("Plug 2 status: ON");
                    mSwitch2.setChecked(true);
                }
                else if (statusPlug2.equals(0)){
                    mPlugStatusIcon2.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lightoff));
                    mPlugStatus2.setText("Plug 2 status: OFF");
                    mSwitch2.setChecked(false);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Do nothing
            }
        });

        // Plug 3
        DatabaseReference plug3 = database.getReference("database/plug 3");
        plug3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Integer statusPlug3 = snapshot.getValue(Integer.class);

                assert statusPlug3 != null;
                if (statusPlug3.equals(1)){
                    mPlugStatusIcon3.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lighton));
                    mPlugStatus3.setText("Plug 3 status: ON");
                    mSwitch3.setChecked(true);
                }
                else if (statusPlug3.equals(0)){
                    mPlugStatusIcon3.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lightoff));
                    mPlugStatus3.setText("Plug 3 status: OFF");
                    mSwitch3.setChecked(false);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Do nothing
            }
        });

        // Plug 4
        DatabaseReference plug4 = database.getReference("database/plug 4");
        plug4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Integer statusPlug4 = snapshot.getValue(Integer.class);

                assert statusPlug4 != null;
                if (statusPlug4.equals(1)){
                    mPlugStatusIcon4.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lighton));
                    mPlugStatus4.setText("Plug 4 status: ON");
                    mSwitch4.setChecked(true);
                }
                else if (statusPlug4.equals(0)){
                    mPlugStatusIcon4.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lightoff));
                    mPlugStatus4.setText("Plug 4 status: OFF");
                    mSwitch4.setChecked(false);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Do nothing
            }
        });

        // Plug 5
        DatabaseReference plug5 = database.getReference("database/plug 5");
        plug5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Integer statusPlug5 = snapshot.getValue(Integer.class);

                assert statusPlug5 != null;
                if (statusPlug5.equals(1)){
                    mPlugStatusIcon5.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lighton));
                    mPlugStatus5.setText("Plug 5 status: ON");
                    mSwitch5.setChecked(true);
                }
                else if (statusPlug5.equals(0)){
                    mPlugStatusIcon5.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lightoff));
                    mPlugStatus5.setText("Plug 5 status: OFF");
                    mSwitch5.setChecked(false);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Do nothing
            }
        });

        // Lock
        DatabaseReference lock = database.getReference("database/lock");
        lock.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Integer lock = snapshot.getValue(Integer.class);

                assert lock != null;
                if (lock.equals(1)){
                    mLockIcon.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lock));
                    mLockText.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.green));
                    mLockSwitch.setChecked(true);
                }
                else if (lock.equals(0)){
                    mLockIcon.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.unlock));
                    mLockText.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                    mLockSwitch.setChecked(false);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Do nothing
            }
        });

        //------------------------------------------------- VOICE SEARCH ---------------------------------------

        mVoiceIcon = findViewById(R.id.voiceIcon);
        mVoiceIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                speak();
            }
        });

    }


    //--------------------------------------------------- SPEECH RECOGNITION----------------------------
    private void speak() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something to switch plug");

        try {
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
        }
        catch (Exception e){
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
    }

    //---------------------------------------------------- SPEECH RECOGNITION ----------------------------
    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUEST_CODE_SPEECH_INPUT:{
                if (resultCode == RESULT_OK && null != data){
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);


                    String status = result.get(0);

                    FirebaseDatabase database = FirebaseDatabase.getInstance();

                    //-------------------------------------- PLUG 1 ---------------------------------------------
                    DatabaseReference alpha = database.getReference("database/plug 1");

                    if (status.equals("Alpha on")){
                        mPlugStatus1.setText("Plug 1 status: ON");
                        mPlugStatusIcon1.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lighton));
                        alpha.setValue(1);
                    }

                    else if (status.equals("Alpha off")){
                        mPlugStatus1.setText("Plug 1 status: OFF");
                        mPlugStatusIcon1.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lighton));
                        alpha.setValue(0);
                    }

                    //-------------------------------------- PLUG 2 ---------------------------------------------
                    DatabaseReference beta = database.getReference("database/plug 2");

                    if (status.equals("Beta on")){
                        mPlugStatus1.setText("Plug 2 status: ON");
                        mPlugStatusIcon1.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lighton));
                        beta.setValue(1);
                    }

                    else if (status.equals("Beta off")){
                        mPlugStatus1.setText("Plug 2 status: OFF");
                        mPlugStatusIcon1.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lighton));
                        beta.setValue(0);
                    }

                    //-------------------------------------- PLUG 3 ---------------------------------------------
                    DatabaseReference gamma = database.getReference("database/plug 3");

                    if (status.equals("Gamma on")){
                        mPlugStatus1.setText("Plug 3 status: ON");
                        mPlugStatusIcon1.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lighton));
                        gamma.setValue(1);
                    }

                    else if (status.equals("Gamma off")){
                        mPlugStatus1.setText("Plug 3 status: OFF");
                        mPlugStatusIcon1.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lighton));
                        gamma.setValue(0);
                    }

                    //-------------------------------------- PLUG 4 ---------------------------------------------
                    DatabaseReference delta = database.getReference("database/plug 4");

                    if (status.equals("Delta on")){
                        mPlugStatus1.setText("Plug 4 status: ON");
                        mPlugStatusIcon1.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lighton));
                        delta.setValue(1);
                    }

                    else if (status.equals("Delta off")){
                        mPlugStatus1.setText("Plug 4 status: OFF");
                        mPlugStatusIcon1.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lighton));
                        delta.setValue(0);
                    }

                    //-------------------------------------- PLUG 5 ---------------------------------------------
                    DatabaseReference zeta = database.getReference("database/plug 5");

                    if (status.equals("Zeta on")){
                        mPlugStatus1.setText("Plug 5 status: ON");
                        mPlugStatusIcon1.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lighton));
                        zeta.setValue(1);
                    }

                    else if (status.equals("Zeta off")){
                        mPlugStatus1.setText("Plug 5 status: OFF");
                        mPlugStatusIcon1.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lighton));
                        zeta.setValue(0);
                    }

                    //-------------------------------------- SPEECH REJECTION ---------------------------------------------

                    else{
                        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Sorry. Command not found", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }





                }
                break;
            }
        }
    }


}