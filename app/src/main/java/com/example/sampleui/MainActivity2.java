package com.example.sampleui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity2 extends AppCompatActivity {

    MaterialButton btn;
    RelativeLayout relativeLayout;
    PopupWindow popupWindow;


    TextView cbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ViewsInitialise();


        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = (LayoutInflater) MainActivity2.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.pop_up, null);
                cbtn=(TextView) customView.findViewById(R.id.cancbtn);


                //instantiate popup window
                popupWindow = new PopupWindow(customView, 900, RelativeLayout.LayoutParams.WRAP_CONTENT);
                //display the popup window
                popupWindow.showAtLocation(relativeLayout, Gravity.CENTER_VERTICAL, 0, -250);


                cbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });



            }
        });

    }

    private void ViewsInitialise() {
        btn = (MaterialButton) findViewById(R.id.tokenbtn);
        relativeLayout = (RelativeLayout) findViewById(R.id.Relativelay);


    }
}