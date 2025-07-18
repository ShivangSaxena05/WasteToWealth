package com.example.wastetowealth.screens;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.wastetowealth.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserProfileEditActivity extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    FirebaseFirestore db;
    Button btn_chooseimg,btn_uploadimg;
    ImageView iv_userimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_profile_edit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        db = FirebaseFirestore.getInstance();
        FirebaseApp.initializeApp(getApplicationContext());


        btn_chooseimg = findViewById(R.id.btn_chooseimg);
        btn_uploadimg = findViewById(R.id.btn_uploadimg);
        iv_userimg = findViewById(R.id.iv_userimg);




        btn_chooseimg.setOnClickListener(v-> openFileChooser());



    }
    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

}