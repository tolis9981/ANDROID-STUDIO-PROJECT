//    PROGIOS
package com.example.tnteam;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.List;

public class QueryFragment extends Fragment {
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    TextView querytextView, querytextresult;
    Button bnqueryrun;
    int test;
    public QueryFragment() { /*Required empty public constructor*/ }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate (R.layout.fragment_query, container, false);

        final String[] queryArray = getResources().getStringArray(R.array.queries_description_array);
        querytextView = view. findViewById(R.id.txtquery);
        spinner = view.findViewById (R.id.spinner);
        adapter = ArrayAdapter.createFromResource (getContext (), R.array.queries_array, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                querytextView.setText(queryArray[position]);
                test=position+1;
            }
            @Override
            public void onNothingSelected (AdapterView<?> parent) {

            }
        });
        querytextresult = view.findViewById(R.id.txtqueryresult);
        bnqueryrun = view.findViewById(R.id.queryrun);
        bnqueryrun.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            querytextresult.setText("test" + test);
            String result = "";

            switch (test) {
                case 1:
                    List<AgencyTable> agency = MainActivity.myAppDatabase.
                            myDao().getAgencyTable();
                    for (AgencyTable i : agency) {
                        int code = i.getId();
                        String name = i.getName();
                        String address = i.getAddress();
                        result = result + "\n Id: " + code + "\n Name: " + name + "\n Address:" + address +"\n";
                    }
                    querytextresult.setText(result);
                    break;
                case 2:
                    List<TripTable> trip = MainActivity.myAppDatabase.
                            myDao().getTripTable();
                    for (TripTable i : trip) {
                        int code = i.getId();
                        String city = i.getCity();
                        String county = i.getCountry();
                        int Duration = i.getDays();
                        String Type = i.getType();
                        result = result + "\n Id: " + code + "\n City: " + city + "\n County: " + county + "\n Duration: " + Duration+ "\n Type: " + Type+"\n";
                    }
                    querytextresult.setText(result);
                    break;
                case 3:
                    List<TripPackageTable> reserves = MainActivity.myAppDatabase.
                            myDao().getTripPackageTable();
                    for (TripPackageTable i : reserves) {
                        int Package_id = i.getId();
                        int AgencyCode = i.getAgencyCode();
                        int TripCode = i.getTripCode();
                        String Departure = i.getDeparture();
                        double Price = i.getPrice();
                        result = result + "\n Package_id: " + Package_id + "\n AgencyCode: " + AgencyCode
                                + "\n TripCode: " + TripCode + "\n Departure: " + Departure + "\n Price: " + Price ;
                    }
                    querytextresult.setText(result);
                    break;
                case 4:
                    List<ResultStringInt> resultStringInts = MainActivity.myAppDatabase.
                            myDao().getQuery4();
                    for (ResultStringInt i : resultStringInts) {
                        int Agency_id = i.getField1();
                        String Agency_Name = i.getField2();
                        result = result + "\n Agency's id:" + Agency_id + "\n Agency_Name:"+ Agency_Name + "\n";
                    }
                    querytextresult.setText(result);
                    break;
                case 5:
                    List<AgencyTable> AgencyDiakopes = MainActivity.myAppDatabase.myDao().getQuery5();

                    for (AgencyTable i : AgencyDiakopes) {
                        int code = i.getId();
                        String name = i.getName();
                        String address = i.getAddress();
                        result = result + "\n Id: " + code + "\n Name: " + name + "\n Address:" + address ;
                    }
                    querytextresult.setText(result);
                    break;
                case 6:
                    List<String> strings = MainActivity.myAppDatabase.myDao().getQuery6();
                    for (String i : strings) {
                        result = result + "\n Agency name: " + i + "\n";
                    }
                    querytextresult.setText(result);
                    break;


/*
                case 7:
                    List<Integer> integers = MainActivity.myAppDatabase.myDao().getQuery7();
                    for (Integer i : integers) {
                        result = result + "\n Reserves sid: " + i + "\n";
                    }
                    querytextresult.setText(result);
                    break;
                case 8:
                    List<String> strings2 = MainActivity.myAppDatabase.myDao().getQuery8();
                    for (String i : strings2) {
                        result = result + "\n Sailor's Name:" + i + "\n";
                    }
                    querytextresult.setText(result);
                    break;
                case 9:
                    List<Integer> integers2 = MainActivity.myAppDatabase.myDao().getQuery9();
                    for (Integer i : integers2) {
                        result = result + "\n Sailors age sid: " + i + "\n";
                    }
                    querytextresult.setText(result);
                    break;

                case 10:
                    List<String> strings3 = MainActivity.myAppDatabase.myDao().getQuery10();
                    for (String i : strings3) {
                        result = result + "\n Sailor's Name:" + i + "\n";
                    }
                    querytextresult.setText(result);
                    break;

                case 11:
                    List<Integer> integers3 = MainActivity.myAppDatabase.myDao().getQuery11();
                    for (Integer i : integers3) {
                        result = result + "\n Sailors age sid: " + i + "\n";
                    }
                    querytextresult.setText(result);
                    break;

                case 12:
                    List<String> strings5 = MainActivity.myAppDatabase.myDao().getQuery12();
                    for (String i : strings5) {
                        result = result + "\n Sailor's Name: " + i + "\n";
                    }
                    querytextresult.setText(result);
                    break;

                case 13:
                    List<String> strings6 = MainActivity.myAppDatabase.myDao().getQuery13();
                    for (String i : strings6) {
                        result = result + "\n Sailor's Name:" + i + "\n";
                    }
                    querytextresult.setText(result);
                    break;

                case 14:
                    List<ResultStringInt> resultstringInts14 = MainActivity.myAppDatabase.myDao().getQuery14();
                    for (ResultStringInt i : resultstringInts14) {
                        String Sailors_name = i.getField1();
                        int Max_age = i.getField2();
                        result = result + "\n Sailor's Name:" + Sailors_name + "\n Maximum Age: " + Max_age + "\n";
                    }
                    querytextresult.setText(result);
                    break;

                case 15:
                    List<String> strings15 = MainActivity.myAppDatabase.myDao().getQuery15("red");
                    for (String i : strings15) {
                        result = result + "\n Sailor's Name: " + i + "\n";
                    }
                    querytextresult.setText(result);
                    break;
*/

        }
        }});
        return view;
    }
}