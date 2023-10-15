/*    PROGIOS    */
package com.example.tnteam;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class deleteFragment extends Fragment implements View.OnClickListener {
    Button Bn_Sailor, Bn_Boat, Bn_Reserves;
    public deleteFragment(){ /*Required empty public constructor  */  }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){
        // Inflate the layout for this fragment View view= inflater.inflate(R.layout.fragment_menu,
        View view = inflater.inflate(R.layout.fragment_delete, container, false);

        Bn_Sailor = view.findViewById(R.id.InsertAgencyButton);
        Bn_Sailor.setOnClickListener(this);
        Bn_Boat = view.findViewById(R.id.InsertTripButton);
        Bn_Boat.setOnClickListener(this);
        Bn_Reserves = view.findViewById(R.id.InsertTripPackageButton);
        Bn_Reserves.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.InsertAgencyButton:
                AgencyActivity.fragmentManager.beginTransaction().
                        replace(R.id.fragment_container, new DeleteAgencyFragment()).addToBackStack(null).commit();
                break;
            case R.id.InsertTripButton:
                AgencyActivity.fragmentManager.beginTransaction().
                        replace(R.id.fragment_container, new DeleteTripFragment()).addToBackStack(null).commit();
                break;
            case R.id.InsertTripPackageButton:
                AgencyActivity.fragmentManager.beginTransaction().
                        replace(R.id. fragment_container, new DeleteTripPackageFragment()).addToBackStack(null).commit();
                break;
        }
    }
}