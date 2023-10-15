/*    PROGIOS    */
package com.example.tnteam;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

public class LoginFragment extends Fragment implements View.OnClickListener {

    public TextInputEditText S_id,S_name,S_address;
    Button Bn_login;

    public LoginFragment(){ /*Required empty public constructor  */  }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){
        // Inflate the layout for this fragment View view= inflater.inflate(R.layout.fragment_menu,
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        Bn_login = view.findViewById(R.id.agency_login_button);
        Bn_login.setOnClickListener(this);
        S_id=view.findViewById(R.id.agency_login_id);
        S_id.setOnClickListener(this);
        S_name=view.findViewById(R.id.agency_login_name);
        S_name.setOnClickListener(this);
        S_address=view.findViewById(R.id.agency_login_address);
        S_address.setOnClickListener(this);
        return view;
    }

    public String getS_id(){
        return S_id.getText().toString() ;
    }
    // PAUSE
    @Override
    public void onClick(View v) {
/*        switch (v.getId()){
            case R.id.agency_login_button:
                MainActivity.fragmentManager.beginTransaction().
                        replace(R.id.fragment_container, new AgencyActivity()).addToBackStack(null).commit();
                break;

        }
*/    }
}