/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promdashboard.model;

import org.springframework.stereotype.Component;

/**
 *
 * @author AMRE
 */
public class FilterCategory {

    private String label;
    private int key;

    public FilterCategory(int key, String label) {
        this.label = label;
        this.key = key;
    }

    public String getlabel() {
        return this.label;
    }

    /**
     * @return the key
     */
    public int getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(int key) {
        this.key = key;
    }

    public void setlabel(String label) {
        this.label = label;
    }
}
