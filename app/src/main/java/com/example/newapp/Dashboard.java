package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.newapp.ui.Activity;

public class Dashboard extends AppCompatActivity {
    private Button homeButton,settingsButton,activityButton;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        homeButton=findViewById(R.id.home);
        settingsButton=findViewById(R.id.settings);
        activityButton=findViewById(R.id.activity);
        homeButton.setEnabled(false);

        //title=findViewById(R.id.textView5);
        homeButton.setTextSize(25);
        replaceFragment(new HomeDashboard(), android.R.animator.fade_in, android.R.animator.fade_out);

        //replaceFragment(new Home(), android.R.animator.fade_in, android.R.animator.fade_out);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonUI(homeButton,activityButton,settingsButton);
                replaceFragment(new HomeDashboard(), android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                //replaceFragment(new Home(), android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonUI(settingsButton,homeButton,activityButton);

                replaceFragment(new Settings(),android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setButtonUI(activityButton,homeButton,settingsButton);

                replaceFragment(new Activity(),android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });
    }

    public void replaceFragment(Fragment fragment,int animEnter,int animExit) {

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(animEnter, animExit);
        fragmentTransaction.replace(R.id.linearLayout,fragment);
        fragmentTransaction.commit();

    }

    public void setButtonUI(Button mainButton,Button secButton1,Button secButton2){

        //enable the button that is clicked
        if(mainButton.isPressed()){
            secButton1.setEnabled(true);
            secButton2.setEnabled(true);
            mainButton.setEnabled(false);
        }

        // enlarge the button text that is clicked
        mainButton.setTextSize(25);
        secButton2.setTextSize(20);
        secButton1.setTextSize(20);

        // set button textcolour
        secButton1.setTextColor(getColor(R.color.light_grey));
        secButton2.setTextColor(getColor(R.color.light_grey));
        mainButton.setTextColor(getColor(R.color.white));

        // set button background i.e white tab interface
        secButton1.setBackground(getDrawable(R.drawable.rounded_buttons));
        secButton2.setBackground(getDrawable(R.drawable.rounded_buttons));
        mainButton.setBackground(getDrawable(R.drawable.button_tab));

    }

}