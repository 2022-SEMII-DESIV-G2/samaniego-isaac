package com.pfdevcon;

import java.util.ArrayList;

public class Pyramids {

    ArrayList<Pyramid> pyramids = new ArrayList<Pyramid>();

    public ArrayList<Pyramid> getPyramid() {
        return pyramids;
    }

    public void addPyramidlist(Pyramid pyramid) {
        pyramids.add(pyramid);
    }
}
