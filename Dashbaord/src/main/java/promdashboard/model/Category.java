/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promdashboard.model;

import java.math.BigInteger;

/**
 *
 * @author braim
 */
public class Category {
    
    private BigInteger id;
    private BigInteger parentid;
    private String name;
    private BigInteger createbyuserid;
    private BigInteger createtimemillis;
    private BigInteger lastupdatetimemillis;
    private BigInteger updatebyuserid;
    private Boolean userrequest;
    private Boolean show;
    private String description;
    private String picturename;
    private String picturepath;
    private Integer index;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getParentid() {
        return parentid;
    }

    public void setParentid(BigInteger parentid) {
        this.parentid = parentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getCreatebyuserid() {
        return createbyuserid;
    }

    public void setCreatebyuserid(BigInteger createbyuserid) {
        this.createbyuserid = createbyuserid;
    }

    public BigInteger getCreatetimemillis() {
        return createtimemillis;
    }

    public void setCreatetimemillis(BigInteger createtimemillis) {
        this.createtimemillis = createtimemillis;
    }

    public BigInteger getLastupdatetimemillis() {
        return lastupdatetimemillis;
    }

    public void setLastupdatetimemillis(BigInteger lastupdatetimemillis) {
        this.lastupdatetimemillis = lastupdatetimemillis;
    }

    public BigInteger getUpdatebyuserid() {
        return updatebyuserid;
    }

    public void setUpdatebyuserid(BigInteger updatebyuserid) {
        this.updatebyuserid = updatebyuserid;
    }

    public Boolean getUserrequest() {
        return userrequest;
    }

    public void setUserrequest(Boolean userrequest) {
        this.userrequest = userrequest;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicturename() {
        return picturename;
    }

    public void setPicturename(String picturename) {
        this.picturename = picturename;
    }

    public String getPicturepath() {
        return picturepath;
    }

    public void setPicturepath(String picturepath) {
        this.picturepath = picturepath;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
    
}

