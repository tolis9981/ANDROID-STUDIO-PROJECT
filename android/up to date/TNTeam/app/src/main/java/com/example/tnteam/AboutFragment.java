/*    PROGIOS    */
package com.example.tnteam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class AboutFragment extends Fragment implements View.OnClickListener {

    public AboutFragment(){ /*Required empty public constructor  */  }

    Button Bn_backlogin;
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

/*        Bn_backlogin = view.findViewById(R.id.backlogin);
        Bn_backlogin.setOnClickListener(this);*/
        return view;
    }


    public void onClick(View v) {/*
        switch (v.getId()){
            case R.id.backlogin:
                MainActivity.fragmentManager.beginTransaction().
                        replace(R.id.fragment_container,
                                new LoginFragment()).addToBackStack(null).commit();
                break;
        }*/
    }
}
