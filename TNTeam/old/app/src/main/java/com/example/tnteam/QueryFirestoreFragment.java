package com.example.tnteam;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

public class QueryFirestoreFragment extends Fragment {

    TextView queryTextResult;
    DocumentReference documentReference;

    public QueryFirestoreFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_query_firestore, container, false);

        queryTextResult = view.findViewById(R.id.txtqueryresult);

        documentReference = MainActivity.firestoreDB.collection("Clients").document("4002");

        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    Double id = documentSnapshot.getDouble("id");
                    Double born = documentSnapshot.getDouble("born");
                    String hotel = documentSnapshot.getString("hotel");
                    String name = documentSnapshot.getString("name");
                    Double package_id = documentSnapshot.getDouble("package_id");
                    String phone = documentSnapshot.getString("phone");

                    queryTextResult.setText(" id: " + id + "\n born:" + born + "\n hotel " + hotel + "\n name" + name + "\n package_id " + package_id + "\n phone " + phone);

                } else {
                    Toast.makeText(getActivity(), "document does not exist.", Toast.LENGTH_LONG).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "document does not exist.", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}