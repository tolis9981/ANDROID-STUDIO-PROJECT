//    PROGIOS
package com.example.tnteam;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class InsertTripPackageFragment extends Fragment{
        EditText editText1, editText2, editText3,editText4,editText5;
        Button insert_trip_Bn;

    public InsertTripPackageFragment() { /* Required empty public constructor*/}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflate the Layout for this fragment

        View view = inflater.inflate(R.layout.fragment_insert_trip_package, container, false);
        editText1 = view.findViewById(R.id.TripPackageInsetEditText1);
        editText2 = view.findViewById(R.id.TripPackageInsetEditText2);
        editText3 = view.findViewById(R.id.TripPackageInsetEditText3);
        editText4 = view.findViewById(R.id.TripPackageInsetEditText4);
        editText5 = view.findViewById(R.id.TripPackageInsetEditText5);

        insert_trip_Bn = view.findViewById(R.id.TripPackageInsetButton);
        insert_trip_Bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1i metavliti
                int Var_trip_package_Id = 0;
                try {
                    Var_trip_package_Id = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse + ex");
                }
                //2i metavliti
                int Var_agency_id = 0;
                try {
                    Var_agency_id = Integer.parseInt(editText2.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse + ex");
                }
                //3i metavliti
                int Var_trip_id = 0;
                try {
                    Var_agency_id = Integer.parseInt(editText3.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse + ex");
                }
                //4i metavliti
                String Var_date_deperature = editText4.getText().toString();
                //5i metavliti
                int Var_trip_price = 0;
                try {
                    Var_trip_price = Integer.parseInt(editText5.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse + ex");
                }

                try {
                    TripPackageTable tripPackage = new TripPackageTable();
                    tripPackage.setId(Var_trip_package_Id);
                    tripPackage.setAgencyCode(Var_agency_id);
                    tripPackage.setTripCode(Var_trip_id);
                    tripPackage.setDeparture(Var_date_deperature);
                    tripPackage.setPrice(Var_trip_price);

                    MainActivity.myAppDatabase.myDao().insertTripPackage(tripPackage);
                    Toast.makeText(getActivity(), "Insert Trip Package Complete !", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                }
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
                editText5.setText("");
            }
        });
        return view;
    }
}