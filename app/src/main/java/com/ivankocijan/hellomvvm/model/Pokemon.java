package com.ivankocijan.hellomvvm.model;

import com.google.gson.annotations.SerializedName;

import android.text.TextUtils;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 12.08.15.
 */
public class Pokemon {

    @SerializedName("name")
    private String name;

    @SerializedName("attack")
    private int attack;

    @SerializedName("catch_rate")
    private int catchRate;

    @SerializedName("resource_uri")
    private String resourceUri;

    private String image;

    @SerializedName("defense")
    private String defense;

    public String getResourceUri() {
        return resourceUri;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return "http://2.bp.blogspot.com/-6XZJOn_s4V0/UT1LVmbATcI/AAAAAAAADCI/5YtUS6Jemzo/s1600/Pok%C3%A9bola.png";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getCatchRate() {
        return catchRate;
    }

    public void setCatchRate(int catchRate) {
        this.catchRate = catchRate;
    }

    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public int getPokedexId() {

        if (TextUtils.isEmpty(resourceUri)) {
            return 1; //Default is Bulbasaur :)
        }

        String[] resourceArray = resourceUri.split("/");
        return Integer.parseInt(resourceArray[resourceArray.length - 1]);


    }

    public String getDefense() {
        return defense;
    }
}
