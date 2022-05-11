package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//
//public class Form_for_host extends Fragment {
//    private String zone;
//    Button host_submit;
//    TextView slot;
//    TextView sport_name;
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View v =  inflater.inflate(R.layout.fragment_form_for_host, container, false);
//        final String[] zone = new String[1];
//        final String[] location = new String[1];
//        slot = v.findViewById(R.id.slots);
//        sport_name = v.findViewById(R.id.eventname);
//        String[] value = new String[]{"North","East","West","South"};
//
//
//        Spinner sp = v.findViewById(R.id.zone_spinner);
//        sp.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item,value));
//        HashMap<String, String[]> map = new HashMap<String, String[]>();
//        map.put("North", new String[]{"Bonta Park", "North Delhi Municipal Park", "Shalimar Lovers Park", "Kamla Nehru North", "Shubash Park"});
//        map.put("South", new String[]{"Deer Park", "Maa Sarada Park", "Qila Rai Pithora Park", "Pancheel Park"});
//        map.put("East", new String[]{"Green Belt Park", "Krishna Jayanti Park", "Shiv Park", "The Maharana Pratap Park"});
//        map.put("West", new String[]{"Bheemrao Ambedkar Park", "Sanjay Park", "Bindra Park", "Jheel Wala Park"});
//        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                String temp_zone = sp.getSelectedItem().toString();
//                zone[0] = temp_zone;
//                if(map.containsKey(temp_zone)){
//
//                   // zone = adapterView.getItemAtPosition(i).toString();
//                    Spinner sp2 = v.findViewById(R.id.location_spinner);
//                    sp2.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item,map.get(temp_zone)));
//                    location[0] = sp2.getSelectedItem().toString();
//                }
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//        host_submit = v.findViewById(R.id.host_submit);
//        host_submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String slt = slot.getText().toString();
//                String s_name = sport_name.getText().toString();
//                System.out.println(slt);
//                System.out.println(s_name);
//                FirebaseFirestore firebaseFirestore;
//                DocumentReference ref;
//                firebaseFirestore = FirebaseFirestore.getInstance();
//                ref = firebaseFirestore.collection("event").document();
//                Map<String, Object> mapper = new HashMap<>();
//
//                mapper.put("Name",s_name );
//                mapper.put("zone", zone[0]);
//                mapper.put("location", location[0]);
//                mapper.put("slots",slt);
//                firebaseFirestore.collection("event").add(mapper);
//
//                String ID = fetch_id(s_name,location[0],zone[0],slt);
//                Log.d("form for host","id = "+ID);
//                EventData event_data = new EventData(s_name,location[0],zone[0],Integer.parseInt(slt),ID);
//                Intent intent = new Intent(getActivity(), EventProgress.class);
//                intent.putExtra("EventData", event_data);
//                startActivity(intent);
//            }
//        });
//
//        return v;
//
//    }
//
//
//    public String fetch_id(String Name,String Location,String Zone,String Slots){
//
//        final String[] ID = new String[1];
//        FirebaseFirestore db= FirebaseFirestore.getInstance();
//        System.out.println("IN");
//        db.collection("event")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//
//                        if (task.isSuccessful()) {
//                            System.out.println("out");
//                            System.out.println(task.getResult().isEmpty());
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                System.out.println(document.getData());
//                                String name1 = (String) document.getData().get("Name");
//                                String location1 = (String) document.getData().get("location");
//                                String slots1 = (String) document.getData().get("slots");
//                                String zone1 = (String) document.getData().get("zone");
//                                String id = (String) document.getId();
//                                if(name1.equals(Name) && location1.equals(Location) && zone1.equals(Zone) && slots1.equals(Slots)){
//                                    ID[0] = id;
//                                    break;
//                                }
//                            }
//
//                        } else {
//                            System.out.println("out2");
//                            Log.d("data", "Error getting documents: ", task.getException());
//                        }
//                    }
//                });
//        // check if username and password available and correct.
//        return ID[0];
//    }
//
//}


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Form_for_host extends Fragment {
    private String zone;
    private Button host_submit;
    private TextView slot;
    private TextView sport_name;
//    public String chat_id ;
    private String event_id;
    private String ss;


    final String[] ID = new String[1];
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_form_for_host, container, false);
        final String[] zone = new String[1];
        final String[] location = new String[1];
        slot = v.findViewById(R.id.slots);
        sport_name = v.findViewById(R.id.eventname);
        String[] value = new String[]{"North","East","West","South"};


        Spinner sp = v.findViewById(R.id.zone_spinner);
        sp.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item,value));
        HashMap<String, String[]> map = new HashMap<String, String[]>();
        map.put("North", new String[]{"Bonta Park", "North Delhi Municipal Park", "Shalimar Lovers Park", "Kamla Nehru North", "Shubash Park"});
        map.put("South", new String[]{"Deer Park", "Maa Sarada Park", "Qila Rai Pithora Park", "Pancheel Park"});
        map.put("East", new String[]{"Green Belt Park", "Krishna Jayanti Park", "Shiv Park", "The Maharana Pratap Park"});
        map.put("West", new String[]{"Bheemrao Ambedkar Park", "Sanjay Park", "Bindra Park", "Jheel Wala Park"});
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String temp_zone = sp.getSelectedItem().toString();
                zone[0] = temp_zone;
                if(map.containsKey(temp_zone)){

                    // zone = adapterView.getItemAtPosition(i).toString();
                    Spinner sp2 = v.findViewById(R.id.location_spinner);
                    sp2.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item,map.get(temp_zone)));
                    location[0] = sp2.getSelectedItem().toString();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        host_submit = v.findViewById(R.id.host_submit);
        host_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String slt = slot.getText().toString();
                String s_name = sport_name.getText().toString();
                System.out.println(slt);
                System.out.println(s_name);
                FirebaseFirestore firebaseFirestore;
                DocumentReference ref;
                firebaseFirestore = FirebaseFirestore.getInstance();
                ref = firebaseFirestore.collection("event").document();

                Map<String, Object> mapper = new HashMap<>();
                mapper.put("Message","Welcome Everyone" );
                final String[] chat_id = new String[1];
                firebaseFirestore.collection("chat")
                        .add(mapper)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                chat_id[0] = documentReference.getId().toString();
                                Log.d("Value of chat id: ", "DocumentSnapshot written with ID: " + chat_id[0]);
                                System.out.println("document id3: "+ chat_id[0]);
                            }
                        });

                System.out.println("document id2: "+chat_id[0]);

                mapper = new HashMap<>();

                mapper.put("Name",s_name );
                mapper.put("zone", zone[0]);
                mapper.put("team_size", slt);
                mapper.put("location", location[0]);
                mapper.put("slots",slt);
                mapper.put("chat_id", chat_id[0]);

                firebaseFirestore.collection("event")
                        .add(mapper)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                event_id = documentReference.getId().toString();
                                Log.d("Value of chat id: ", "DocumentSnapshot written with ID: " + documentReference.getId());
                                System.out.println("document id: "+documentReference.getId());
                            }
                        });
                create_event(s_name,location[0],zone[0],slt, chat_id[0],event_id);

            }
        });

        return v;

    }


    public void create_event(String Name,String Location,String Zone,String Slots,String chat_id,String event_id){
        Log.d("event_id","id "+event_id);
        EventData event_data = new EventData(Name,Location,Zone,Integer.parseInt(Slots),chat_id,event_id);
        Intent intent = new Intent(getActivity(), EventProgress.class);
        intent.putExtra("EventData", event_data);
        Log.d("fetch data abhinesh","id = "+" done");
        startActivity(intent);
    }


//    public void fetch_id(String Name,String Location,String Zone,String Slots){
//
//
//        FirebaseFirestore db= FirebaseFirestore.getInstance();
//        //System.out.println("IN");
//        db.collection("event")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//
//                        if (task.isSuccessful()) {
//                            System.out.println("out");
//                            //System.out.println(task.getResult().isEmpty());
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                //System.out.println(document.getData());
//                                String name1 = (String) document.getData().get("Name");
//                                String location1 = (String) document.getData().get("location");
//                                String slots1 = (String) document.getData().get("slots");
//                                String zone1 = (String) document.getData().get("zone");
//                                String id = (String) document.getId();
//                                //System.out.println("Getting forloop ID: "+id);
//                                if(name1.length()!=0 && location1.length()!=0 && slots1.length()!=0 && zone1.length()!=0){
//                                    if(name1.equals(Name) && location1.equals(Location) && zone1.equals(Zone) && slots1.equals(Slots)){
//                                        //System.out.println("Getting inside ID: "+id);
//                                        ID[0] = id;
//                                        Log.d("fetch data abhinesh","id = "+ID[0]);
//                                        Toast.makeText(getActivity(), id, Toast.LENGTH_SHORT).show();
//                                        EventData event_data = new EventData(name1,location1,zone1,Integer.parseInt(slots1), "");
//                                        Intent intent = new Intent(getActivity(), EventProgress.class);
//                                        intent.putExtra("EventData", event_data);
//                                        Log.d("fetch data abhinesh","id = "+" done");
//                                        startActivity(intent);
//                                        break;
//                                    }
//                                }
//                                else{
//                                    Toast.makeText(getActivity(),"Please fill all the fields",Toast.LENGTH_SHORT).show();
//                                }
//                            }
//
//                        } else {
//                            System.out.println("out2");
//                            Log.d("data", "Error getting documents: ", task.getException());
//                        }
//                    }
//                });
//        // check if username and password available and correct.
//        System.out.println("getting id: "+ID[0]);
//        return ;
//    }

}