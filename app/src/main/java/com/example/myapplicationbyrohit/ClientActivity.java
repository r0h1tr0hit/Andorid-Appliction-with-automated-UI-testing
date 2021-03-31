package com.example.myapplicationbyrohit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.myapplicationbyrohit.MainActivity.EXTRA_MESSAGE;

public class ClientActivity extends AppCompatActivity {
    private String message;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        editText = (EditText)findViewById(R.id.editTextTextPersonName2);
        editText.setHint("Enter phone number or email address");
        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
    }
    public boolean phoneNumber(String s){
        if(s.length()!=10)
            return false;
        for(int i = 0;i<10;i++){
            if(s.charAt(i)>'9' || s.charAt(i)<'0')
                return false;
        }
        return true;
    }

    public boolean email(String s){
        s=s.trim();
        if(s.length() < 11)
            return false;
        String a = s.substring(s.length()-10);
        String b = s.substring(s.length()-11);
        if(a.compareToIgnoreCase("@gmail.com") == 0)
            return true;
        else if(s.length()>=12 && b.compareToIgnoreCase("@iisc.ac.in") == 0)
            return true;
        return false;

    }


    public void composeSmsMessage(View view) {

        //Sending a message
        String recepient = editText.getText().toString();

        if(phoneNumber(recepient)) {

            Context context = getApplicationContext();
            CharSequence text = "Sending SMS";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("smsto:" + recepient)); // This ensures only SMS apps respond
            intent.putExtra("sms_body", message);
            startActivity(intent);
        }
        else if (email(recepient)){

            Context context = getApplicationContext();
            CharSequence text = "Sending email";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + recepient));
            intent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(intent);
        }
        else{
            editText.setError("Enter a valid phone number or email address");
        }

    }

}