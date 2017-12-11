package com.love.rxjavademo.bean;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Transient;

/**
 * Created by adroid on 2017/12/11.
 */

@Entity
public class Food {

    @Id(assignable = true)
    private long id;
    private String name;
    private int count;
    private double price;
    private boolean eat;
    @Transient
    private String type;

    private String title;

    public Food() {
    }

    public Food(String name, int count, double price, boolean eat, String type,String title) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.eat = eat;
        this.type = type;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isEat() {
        return eat;
    }

    public void setEat(boolean eat) {
        this.eat = eat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", eat=" + eat +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
