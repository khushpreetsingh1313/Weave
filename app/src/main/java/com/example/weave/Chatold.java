package com.example.weave;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class Chatold extends Activity {
    ArrayList<String> msg ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_old);

        final EditText type_msg = findViewById(R.id.type);
        ImageView send_btn = findViewById(R.id.send);
        ListView lv = findViewById(R.id.chat);
        msg = new ArrayList<String>();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, msg);
        lv.setAdapter(arrayAdapter);
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String s = type_msg.getText().toString();
                msg.add(s);
                type_msg.setText("");
            }
        });
    }

//    public class chatadapter extends ArrayAdapter<String>{
//
//        public chatadapter(@androidx.annotation.NonNull Context context, int resource) {
//            super(context, resource);
//        }
//    }
}
