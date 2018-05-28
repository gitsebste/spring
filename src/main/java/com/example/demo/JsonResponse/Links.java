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
class Links {

    public Link getSelf() {
        return self;
    }

    public void setSelf(Link self) {
        this.self = self;
    }

    public Link getProfile() {
        return profile;
    }

    public void setProfile(Link profile) {
        this.profile = profile;
    }

    public Link getSearch() {
        return search;
    }

    public void setSearch(Link search) {
        this.search = search;
    }
    
    Link self;Link profile;Link search;
    
}
