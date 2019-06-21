package com.example.endproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewPlayer extends Activity implements View.OnClickListener {
    Button b1;
    EditText e1;
    Intent backtoMain;
    String nick;
    SharedPreferences sharedPreferences;
    String MyPreferences = "Nickname";
    SharedPreferences.Editor editor;
    String nickname;
    //DatabaseNicknames db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_player_activity);

        e1 = findViewById(R.id.editText);
        b1 = findViewById(R.id.saveButton);
        b1.setOnClickListener(this);

        sharedPreferences = getSharedPreferences("A", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        //db = new DatabaseNicknames(this);
        //backtoMain = new Intent(NewPlayer.this, MainActivity.class);
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.saveButton) {
//            nick = String.valueOf(e1.getText());
//            backtoMain.putExtra("Player_Nick",nick);
            nickname = String.valueOf(e1.getText());
            if (TextUtils.isEmpty(nickname)) {
                Toast.makeText(this,"First you need to write your nickname",Toast.LENGTH_SHORT).show();
            }else
            {
                //db.addData(nickname);
                editor.putString("Nickname", nickname);
                editor.commit();
                finish();
            }
        }
    }
}
