/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.JsonResponse;

/**
 *
 * @author device02
 */
public class JsonResponse<T> {
    //String arrName;
    public JsonResponse(){//String arrName){
        //this.arrName=arrName;  
        //Embedded<T> embedded= new Embedded<T>();
    }

    public Embedded<T> getEmbedded() {
        return _embedded;
    }

    public void setEmbedded(Embedded<T> _embedded) {
        this._embedded = _embedded;
    }
    public Links getLinks() {
        return _links;
    }

    public void setLinks(Links _links) {
        this._links = _links;
    }
    
    Embedded<T> _embedded;
    Links _links;
    
}
