package com.example.shared_pref;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameInput;
    EditText passwordInput;
    TextView yashwinText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = (EditText) findViewById(R.id.usernameInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        yashwinText = (TextView) findViewById(R.id.yashwinText);

    }

//  Save the user's login info
    public void saveInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);      //This means the info is private and hence secured

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", usernameInput.getText().toString());
        editor.putString("password", passwordInput.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
    }

//  Print out the saved data
    public void displayData(View view){
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);      //This means the info is private and hence secured

        String name = sharedPref.getString("username", "");     //The second parameter contains the value that we are going to get, so we leave it blank.
        String pw = sharedPref.getString("password", "");
        yashwinText.setText(name + "" + pw);
    }

}
