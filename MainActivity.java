package com.example.pc.interface_chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public int i =0 ;// just for testing
    Msg chat_m ;
    ImageButton image_send ;
    EditText edit_msg ;
    String message ;
    ListView list_view_msg ;
    List<Msg> M_C = new ArrayList<Msg>();
    Chattext adapter ;
    LinearLayout view_child ;
    LinearLayout view_parent ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_msg = (EditText) findViewById(R.id.send_editText);
        image_send= (ImageButton) findViewById(R.id.send_imagebutton);
        list_view_msg = (ListView) findViewById(R.id.msg_list);
        list_view_msg.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        list_view_msg.setStackFromBottom(true);
        adapter = new Chattext(MainActivity.this , M_C);


        image_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                message= edit_msg.getText().toString() ;
                if(i%2==0) {
                    chat_m = new Msg(message, true);
                    i++;
                }
                else
                {
                     chat_m = new Msg(message, false);
                    i++;
                }
                Toast.makeText(getApplication(),message,Toast.LENGTH_LONG).show();
                M_C.add(chat_m);
                list_view_msg.setAdapter(adapter);
                edit_msg.setText("");
                list_view_msg.deferNotifyDataSetChanged();
            }
        });
    }
}
