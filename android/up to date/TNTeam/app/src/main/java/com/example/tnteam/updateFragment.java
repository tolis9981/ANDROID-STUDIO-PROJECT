/*    PROGIOS    */
package com.example.tnteam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class updateFragment extends Fragment implements View.OnClickListener {
        Button Bn_Sailor, Bn_Boat, Bn_Reserves;
        public updateFragment(){ /*Required empty public constructor  */  }

        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container,
                                  Bundle savedInstanceState){
            // Inflate the layout for this fragment View view= inflater.inflate(R.layout.fragment_menu,
            View view = inflater.inflate(R.layout.fragment_update, container, false);

            Bn_Sailor = view.findViewById(R.id.updateAgencyButton);
            Bn_Sailor.setOnClickListener(this);
            Bn_Boat = view.findViewById(R.id.updateTripButton);
            Bn_Boat.setOnClickListener(this);
            Bn_Reserves = view.findViewById(R.id.updateTripPackageButton);
            Bn_Reserves.setOnClickListener(this);

            return view;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.updateAgencyButton:
                    AgencyActivity.fragmentManager.beginTransaction().
                            replace(R.id.fragment_container, new UpdateAgencyFragment()).addToBackStack(null).commit();
                    break;
                case R.id.updateTripButton:
                    AgencyActivity.fragmentManager.beginTransaction().
                            replace(R.id.fragment_container, new UpdateTripFragment()).addToBackStack(null).commit();
                    break;
                case R.id.updateTripPackageButton:
                    AgencyActivity.fragmentManager.beginTransaction().
                            replace(R.id. fragment_container, new UpdateTripPackageFragment()).addToBackStack(null).commit();
                    break;
            }
        }
    }