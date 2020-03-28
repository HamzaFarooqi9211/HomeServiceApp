package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import android.net.Uri;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.common.base.Splitter;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.core.FirestoreClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    boolean flag=true;
    TextView signButton;
    Button registerButton;
    ImageView imageView;
    TextInputLayout nameText;
    TextInputLayout cnicText;
    TextInputLayout phoneText;
    TextInputLayout passText;
    Bitmap bitmap;

    int CHOOSE_IMAGE=16;
    Uri uri;
    FirebaseFirestore db ;
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        imageView = findViewById(R.id.attachIcon);
        signButton = findViewById(R.id.signin);
        nameText=findViewById(R.id.nameText);
        cnicText=findViewById(R.id.cnicText);
        phoneText=findViewById(R.id.phoneText);
        passText=findViewById(R.id.passText);
        registerButton=findViewById(R.id.registerButton);
        db= FirebaseFirestore.getInstance();


        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Cnic image"), CHOOSE_IMAGE);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final String name=nameText.getEditText().getText().toString();
               final String phone=phoneText.getEditText().getText().toString();
               final String cnic=cnicText.getEditText().getText().toString();
               final String password=passText.getEditText().getText().toString();

                if(name==null || phone == null || cnic==null || password==null)
                {
                    Toast.makeText(getApplicationContext(), "Please Fill the required fields",Toast.LENGTH_LONG).show();
                    return;
                }
                db.collection("Users").document(phone).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(!documentSnapshot.exists())
                        {
                            if(!isValid(phone))
                            {Toast.makeText(getApplicationContext(), "Invalid phone",Toast.LENGTH_LONG).show();
                                return;
                            }
                            if(registerUser(name,phone,cnic,password)==true)
                            {
                                SessionManager.createLoginSessionForHelper(phone);
                                Intent intent=new Intent(getApplicationContext(),JobActivity.class);
                                startActivity(intent);
                            }
                            else Log.i(TAG,"registerUser rETURNED false");
                        }
                        else
                        {
                            Log.w(TAG,"aLREADY EXIST");

                            Toast.makeText(getApplicationContext(),"Account Already exist, Sign in to continue",Toast.LENGTH_LONG).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG,"On Failure called");
                    }
                });



            }
        });

    }

    public static boolean isValid(String s)
    {
        // The given argument to compile() method
        // is regular expression. With the help of
        // regular expression we can validate mobile
        // number.
        // 1) Begins with 0 or 91
        // 2) Then contains 7 or 8 or 9.
        // 3) Then contains 9 digits
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");

        // Pattern class contains matcher() method
        // to find matching between given number
        // and regular expression
        Matcher m = p.matcher(s);
        // (m.find() && m.group().equals(s));
        return true;
    }

    public boolean registerUser(String name, String phone, String cnic, String pass)
        {



            Map<String,String> users=new HashMap<>();
            users.put("name",name);
            users.put("phone",phone);
            users.put("cnic",cnic);
            users.put("password",pass);
           // users.put("cnicImage",cnicImage);
            Log.w(TAG,name+phone);

            db.collection("Users").document(phoneText.getEditText().getText().toString()).set(users).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Log.d(TAG,"SUCKSEXFUL");
                   flag=true;
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.w(TAG,"NotSUCKSEXFUL",e);
                    flag=false;
                }
            });


            return flag;
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==CHOOSE_IMAGE && resultCode==RESULT_OK && data!=null && data.getData()!=null)
        {
            uri=data.getData();
            try {
                 bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                imageView.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
