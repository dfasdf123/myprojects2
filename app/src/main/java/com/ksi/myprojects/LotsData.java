package com.ksi.myprojects;

public class LotsData {
   private int imageId;
   private boolean isLotsFB = false;


    public LotsData(int imageId,boolean isCardFB )
    {
        this.imageId = imageId;
        this.isLotsFB = isLotsFB;


    }

    public int getImageId()
    {
        return imageId;
    }
    public void setImageId(int imageId)
    {
        this.imageId = imageId;
    }

    public boolean isLotsFB() {
        return isLotsFB;
    }

    public void setLotsFB(boolean lotsFB) {
        isLotsFB = lotsFB;
    }
}
