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
public class post {
   private int post_id;
   private int user_id;
   private String content;
   private String image_content;
   private String date_post;

    public post(int post_id, int user_id, String content, String image_content, String date_post) {
        this.post_id = post_id;
        this.user_id = user_id;
        this.content = content;
        this.image_content = image_content;
        this.date_post = date_post;
    }                                                           

    public post() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage_content() {
        return image_content;
    }

    public void setImage_content(String image_content) {
        this.image_content = image_content;
    }

    public String getDate_post() {
        return date_post;
    }

    public void setDate_post(String date_post) {
        this.date_post = date_post;
    }

    @Override
    public String toString() {
        return "post{" + "post_id=" + post_id + ", user_id=" + user_id + ", content=" + content + ", image_content=" + image_content + ", date_post=" + date_post + '}';
    }
   
}
