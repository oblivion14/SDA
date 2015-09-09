package com.pineone.sda.domain;


/**
 * Created by use on 2015-09-08.
 */
public class ContextModel {
    String contextModelName;
    String domianID;

    public ContextModel() {
    }

    public ContextModel(String domianID, String contextModelName) {
        this.domianID = domianID;
        this.contextModelName = contextModelName;
    }

    public String getDomianID() {
        return domianID;
    }

    public void setDomianID(String domianID) {
        this.domianID = domianID;
    }

    public String getContextModelName() {
        return contextModelName;
    }

    public void setContextModelName(String contextModelName) {
        this.contextModelName = contextModelName;
    }

}
