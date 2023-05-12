package com.ksi.myprojects;

public class CardData {
   private int imageId;
   private boolean isCardFB = false; //카드 앞 뒤 상태 false = 앞 true = 뒤
    private boolean isCardMatch = false; //카드 매치 false = 매치 x true = 매치 o

    public CardData(int imageId, boolean isCardFB , boolean isCardMatch)
    {
        this.imageId = imageId;
        this.isCardFB = isCardFB;
        this.isCardMatch = isCardMatch;
    }

    public int getImageId()
    {
        return imageId;
    }
    public void setImageId(int imageId)
    {
        this.imageId = imageId;
    }
    public boolean isCardFB()
    {
        return isCardFB;
    }
    public void setCardFB(boolean cardFB)
    {
        this.isCardFB = cardFB;
    }
    public boolean isCardMatch()
    {
        return isCardMatch;
    }
    public void setCardMatch(boolean cardMatch)
    {
        this.isCardMatch = cardMatch;
    }

}
