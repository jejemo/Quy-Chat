package com.example.joepriistomo.prochat.Holder;

import com.quickblox.chat.model.QBChatMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class QBChatMessageHolder {
    private static QBChatMessageHolder instance;
    private HashMap<String,ArrayList<QBChatMessage>>qbChatMessageArray;

    private QBChatMessageHolder(){
        this.qbChatMessageArray = new HashMap<>();
    }

    public void putMessages(String dialogId,ArrayList<QBChatMessage> qbChatMessages)
    {
        this.qbChatMessageArray.put(dialogId,qbChatMessages);
    }

    public void putMessage(String dialogId,QBChatMessage qbChatMessage)
    {
        List<QBChatMessage> lstResult = (List) this.qbChatMessageArray.get(dialogId);
        lstResult.add(qbChatMessage);
        ArrayList<QBChatMessage> lstAdded = new ArrayList(lstResult.size());
        lstAdded.addAll(lstResult);
        putMessages(dialogId,lstAdded);
    }

    public ArrayList<QBChatMessage> getChatMessageByDialogId(String dialogId)
    {
        return (ArrayList<QBChatMessage>)this.qbChatMessageArray.get(dialogId);
    }

}
