package com.eiadmreh.tutsplusupload;

import android.graphics.Bitmap;

public class UploadImage {
    private String ItemName;
    private String ItemPrice;
    private String ItemInfo;
    private String Link1;
    private String Link2;
    private String Link3;
    private String imagePath;
    private Bitmap ImageUri;

    public UploadImage(){

    }

    public UploadImage(String ItemName, String ItemPrice, String ItemInfo, String Link1, String Link2, String Link3, String imagePath){
        this.ItemName=ItemName;
        this.ItemPrice=ItemPrice;
        this.ItemInfo=ItemInfo;
        this.Link1=Link1;
        this.Link2=Link2;
        this.Link3=Link3;
        this.imagePath=imagePath;

    }
    public UploadImage(String ItemName, String ItemPrice, String ItemInfo, String Link1, String Link2, String Link3, Bitmap ImageUri){
        this.ItemName=ItemName;
        this.ItemPrice=ItemPrice;
        this.ItemInfo=ItemInfo;
        this.Link1=Link1;
        this.Link2=Link2;
        this.Link3=Link3;
        this.ImageUri=ImageUri;

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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setImageUri(Bitmap imageUri) {
        ImageUri = imageUri;
    }

    public Bitmap getImageUri() {
        return  ImageUri;
    }

}
