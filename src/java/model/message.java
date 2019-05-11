/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author admin
 */
public class message {
    private int message_id;
    private String content;
    private int receiver_id;
    private int senter_id;
    private String sent_time;

    public message() {
    }
    
    public message(int message_id, String content, int receiver_id, int senter_id, String sent_time) {
        this.message_id = message_id;
        this.content = content;
        this.receiver_id = receiver_id;
        this.senter_id = senter_id;
        this.sent_time = sent_time;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(int receiver_id) {
        this.receiver_id = receiver_id;
    }

    public int getSenter_id() {
        return senter_id;
    }

    public void setSenter_id(int senter_id) {
        this.senter_id = senter_id;
    }

    public String getSent_time() {
        return sent_time;
    }

    public void setSent_time(String sent_time) {
        this.sent_time = sent_time;
    }
    
}

