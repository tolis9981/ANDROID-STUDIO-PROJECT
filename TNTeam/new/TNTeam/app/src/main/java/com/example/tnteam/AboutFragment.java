//    PROGIOS
package com.example.tnteam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class AboutFragment extends Fragment {

    public AboutFragment(){ /*Required empty public constructor  */  }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about, container, false);

        return view;
    }
}
