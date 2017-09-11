package com.vitalii.vitaliiFramework2.helpers;

import java.io.IOException;

import com.mailosaur.MailboxApi;
import com.mailosaur.exception.MailosaurException;
import com.mailosaur.model.Email;

public class MailosaurHelper {

    protected final String API_KEY = "b4e4d2b193b5eb2";
    protected final String MAILBOX_ID = "druzey1a";

    public MailboxApi getEmailBox(String mailBoxId, String apiKey){
        return new MailboxApi(mailBoxId, apiKey);
    }

    public String getApiKey(){
        return API_KEY;
    }

    public String getMailBoxId(){
        return MAILBOX_ID;
    }

    public Email[] getAllEmails(){
        Email[] listOfEmails = null;
        try {
            listOfEmails = getEmailBox(getApiKey(), getMailBoxId()).getEmails();
        } catch (MailosaurException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listOfEmails;
    }

    public Email[] getEmailsByRecepient(String receipentName){
        Email[] listOfEmails = null;
        try {
            listOfEmails = getEmailBox(getApiKey(), getMailBoxId()).getEmailsByRecipient(receipentName);
        } catch (MailosaurException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listOfEmails;
    }

}
