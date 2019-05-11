/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author BaoPhuc
 */
public class Comment {
    private int comment_id;
    private int user_id;
    private int post_id;
    private String comment_content;
    private String comment_date;

    public Comment(int comment_id, int user_id, int post_id, String comment_content, String comment_date) {
        this.comment_id = comment_id;
        this.user_id = user_id;
        this.post_id = post_id;
        this.comment_content = comment_content;
        this.comment_date = comment_date;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getComment_date() {
        return comment_date;
    }

    public void setComment_date(String comment_date) {
        this.comment_date = comment_date;
    }

    @Override
    public String toString() {
        return "comment{" + "comment_id=" + comment_id + ", user_id=" + user_id + ", post_id=" + post_id + ", comment_content=" + comment_content + ", comment_date=" + comment_date + '}';
    }
    
}
