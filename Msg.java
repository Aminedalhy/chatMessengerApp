package com.example.pc.interface_chat;

/**
 * Created by pc on 22/10/2016.
 */
public class Msg {
    private  String msg_text;
    public boolean isMine ;

    public Msg(String msg , boolean isMine )
    {
        msg_text=msg ;
        this.isMine=isMine ;

    }



    public String getMsg_text()
    {
        return this.msg_text ;
    }


}
