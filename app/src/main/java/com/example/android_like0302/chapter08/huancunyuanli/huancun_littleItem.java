package com.example.android_like0302.chapter08.huancunyuanli;

public class huancun_littleItem {
    //1.列出小布局文件中的对应资源
    private int image;
    private String rating;
    private String name;

    //2.创建构造方法来进行初始化赋值
    public huancun_littleItem(int image, String rating, String name) {
        this.image = image;
        this.rating = rating;
        this.name = name;
    }
    //3.为三个属性创建getter和setter方法
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
