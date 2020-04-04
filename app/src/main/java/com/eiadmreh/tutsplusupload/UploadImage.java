package com.eiadmreh.tutsplusupload;

import android.graphics.Bitmap;

public class UploadImage {
    private String ItemName;
    private String ItemPrice;
    private String ItemInfo;
    private String Link1;
    private String Link2;
    private String Link3;
    private String PriceInLink1;
    private String PriceInLink2;
    private String PriceInLink3;
    private String imagePath;
    private String idItem;
    //private Bitmap ImageUri;

    public UploadImage(){

    }


    public UploadImage(String itemName, String itemPrice, String itemInfo, String link1, String link2, String link3, String priceInLink1, String priceInLink2, String priceInLink3, String imagePath, String idItem) {
        ItemName = itemName;
        ItemPrice = itemPrice;
        ItemInfo = itemInfo;
        Link1 = link1;
        Link2 = link2;
        Link3 = link3;
        PriceInLink1 = priceInLink1;
        PriceInLink2 = priceInLink2;
        PriceInLink3 = priceInLink3;
        this.imagePath = imagePath;
        this.idItem = idItem;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(String itemPrice) {
        ItemPrice = itemPrice;
    }

    public String getItemInfo() {
        return ItemInfo;
    }

    public void setItemInfo(String itemInfo) {
        ItemInfo = itemInfo;
    }

    public String getLink1() {
        return Link1;
    }

    public void setLink1(String link1) {
        Link1 = link1;
    }

    public String getLink2() {
        return Link2;
    }

    public void setLink2(String link2) {
        Link2 = link2;
    }

    public String getLink3() {
        return Link3;
    }

    public void setLink3(String link3) {
        Link3 = link3;
    }

    public String getPriceInLink1() {
        return PriceInLink1;
    }

    public void setPriceInLink1(String priceInLink1) {
        PriceInLink1 = priceInLink1;
    }

    public String getPriceInLink2() {
        return PriceInLink2;
    }

    public void setPriceInLink2(String priceInLink2) {
        PriceInLink2 = priceInLink2;
    }

    public String getPriceInLink3() {
        return PriceInLink3;
    }

    public void setPriceInLink3(String priceInLink3) {
        PriceInLink3 = priceInLink3;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

}
