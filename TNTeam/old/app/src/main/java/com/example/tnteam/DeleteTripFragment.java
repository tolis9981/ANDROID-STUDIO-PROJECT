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

public class DeleteTripFragment extends Fragment {
    EditText editText;
    Button button;

    public DeleteTripFragment() { /* Required empty public constructor*/}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_delete_trip
                , container, false);
        editText = view.findViewById(R.id.TripDeleteEditText1);
        button = view.findViewById(R.id.TripDeleteButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1i metavliti
                int Var_id = 0;
                try {
                    Var_id = Integer.parseInt(editText.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse + ex");
                }
                TripTable trip = new TripTable();
                trip.setId(Var_id);

                MainActivity.myAppDatabase.myDao().deleteTrip(trip);
                Toast.makeText(getActivity(), "Delete Trip Complete !", Toast.LENGTH_LONG).show();

                editText.setText("");
            }
        });
        return view;
    }
}