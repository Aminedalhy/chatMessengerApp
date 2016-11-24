package com.example.pc.interface_chat;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 22/10/2016.
 */
public class Chattext extends ArrayAdapter<Msg> {

    LinearLayout view_child ;
    LinearLayout view_parent ;

    public Chattext(Context context, List<Msg> messages) {
        super(context, 0,messages);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            //Nous récupérons notre row_tweet via un LayoutInflater,
            //qui va charger un layout xml dans un objet View
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.text_msg,parent, false);
            view_child = (LinearLayout) convertView.findViewById(R.id.layout_msg_child) ;
            view_parent = (LinearLayout) convertView.findViewById(R.id.layout_msg_parent);
        }


        TweetViewHolder viewHolder = (TweetViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new TweetViewHolder();
            viewHolder.Msg_text = (TextView) convertView.findViewById(R.id.text_msg);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Msg message = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.Msg_text.setText(message.getMsg_text());
          if(message.isMine)
          {
              view_child.setBackgroundResource(R.drawable.rounded_corner);
              view_parent.setGravity(Gravity.RIGHT);

          }



        else
          {

              view_child.setBackgroundResource(R.drawable.rounded_corner2);
              view_parent.setGravity(Gravity.LEFT);

          }


        return convertView;
    }



    private class TweetViewHolder{
        public TextView Msg_text;

    }

}
