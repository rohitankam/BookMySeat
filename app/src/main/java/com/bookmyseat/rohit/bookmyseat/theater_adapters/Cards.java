package com.bookmyseat.rohit.bookmyseat.theater_adapters;

/**
 * Created by ROHiT on 09-Mar-18.
 */

public class Cards {
    private String name;
    private int img;

    public Cards(String name,int img) {
        this.name = name;
        this.img=img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
