package com.example.android_like0302.chapter08.recycleView;

public class RecycleView_littleItem {
    //1.将小布局的xml控件类型声明
    int image;
    String name;
    String rating;
  //2.设置构造器
    public RecycleView_littleItem(int image, String name, String rating) {
        this.image = image;
        this.name = name;
        this.rating = rating;
    }
 //3.设置构造方法
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
