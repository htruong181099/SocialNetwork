/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;

/**
 *
 * @author BaoPhuc
 */
public class restaurant {
    private int restaurant_id;
    private String restaurant_name;
    private String address;
    private int point;

    public restaurant(int restaurant_id, String restaurant_name, String address, int point) {
        this.restaurant_id = restaurant_id;
        this.restaurant_name = restaurant_name;
        this.address = address;
        this.point = point;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }
  

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "restaurant{" + "restaurant_id=" + restaurant_id + ", address=" + address + ", point=" + point + '}';
    }
    
}
