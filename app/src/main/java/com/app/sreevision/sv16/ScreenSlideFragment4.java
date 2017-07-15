package com.app.sreevision.sv16;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Naveen on 28-11-2015.
 */
public class ScreenSlideFragment4 extends Fragment {
    Button Button3;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment4, container, false);

        Button3 = (Button)rootView.findViewById(R.id.button);

        Button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.sreevision16.in/workshops.html"));
                startActivity(intent);
            }
        });

        return rootView;

    }
}

