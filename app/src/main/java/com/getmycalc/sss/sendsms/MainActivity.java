package com.getmycalc.sss.sendsms;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText mobileno, message;
Button sendsms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobileno = (EditText) findViewById(R.id.edittext1);
        message = (EditText)findViewById(R.id.edittext2);
        sendsms = (Button) findViewById(R.id.button1);

        //Performing onClick

        sendsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no = mobileno.getText().toString();
                String msg = message.getText().toString();

                //Getting Intent and PendingIntent instance'

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(),0,intent,0);

                //Getting the SMS manager instance and call the sendTextMessage method to send message

                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(no,null,msg,pi,null);
                Toast.makeText(getApplicationContext(),"Message Sent Successfully",Toast.LENGTH_LONG).show();
            }
        });
    }
}
