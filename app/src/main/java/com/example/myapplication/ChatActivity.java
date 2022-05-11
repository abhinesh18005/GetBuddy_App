package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ChatActivity extends AppCompatActivity {

    private String chat_id;
    private Button send;
    private TextView message;
    private EditText enter_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chat_id = getIntent().getStringExtra("chat_id");
        message = findViewById(R.id.chat_message);
        enter_message = findViewById(R.id.chat_enter_message);
        send = findViewById(R.id.chat_button);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp1 = enter_message.getText().toString();
                final String[] temp2 = {""};
                enter_message.setText("");
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                DocumentReference docRef = db.collection("event").document(chat_id);
                docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                Log.d("fetch data ff", "Name = " + document.getData().get("message"));
                                temp2[0] = (String) document.getData().get("message".toString());
                            } else {
                                Log.d("fetch data", "No such document");
                            }
                        } else {
                            Log.d("fetch data", "get failed with ", task.getException());
                        }
                    }
                });

                temp2[0]+=temp1;
                Log.d("message", temp2[0]);
                Map<String, Object> mapper = new HashMap<>();
                mapper.put("message", temp2[0]);
                db= FirebaseFirestore.getInstance();
                db.collection("event").document(chat_id).update(mapper);
            }
        });
    }
}
