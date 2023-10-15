/*    PROGIOS    */
package com.example.tnteam;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class insertFragment extends Fragment implements View.OnClickListener {
    Button Bn_ins_Agency, Bn_ins_Trip, Bn_ins_TripPackage;
    public insertFragment(){ /*Required empty public constructor  */  }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                                  Bundle savedInstanceState){
        // Inflate the layout for this fragment View view= inflater.inflate(R.layout.fragment_menu,
        View view = inflater.inflate(R.layout.fragment_insert, container, false);

        Bn_ins_Agency = view.findViewById(R.id.InsertAgencyButton);
        Bn_ins_Agency.setOnClickListener(this);
        Bn_ins_Trip = view.findViewById(R.id.InsertTripButton);
        Bn_ins_Trip.setOnClickListener(this);
        Bn_ins_TripPackage = view.findViewById(R.id.InsertTripPackageButton);
        Bn_ins_TripPackage.setOnClickListener(this);

        return view;
    }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.InsertAgencyButton:
                    AgencyActivity.fragmentManager.beginTransaction().
                            replace (R.id.fragment_container, new InsertAgencyFragment()).addToBackStack(null).commit();
                    break;
                case R.id.InsertTripButton:
                    AgencyActivity.fragmentManager.beginTransaction().
                            replace(R.id.fragment_container, new InsertTripFragment()).addToBackStack(null).commit();
                    break;
                case R.id.InsertTripPackageButton:
                    AgencyActivity.fragmentManager.beginTransaction().
                            replace(R.id. fragment_container, new InsertTripPackageFragment()).addToBackStack(null).commit();
                    break;
            }
        }
 }