package com.gracjan.gamestore.entity;

import jakarta.persistence.*;

@Table(name = "game")
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="title")
    private String title;
    @Column(name="quantity")
    private int quantity;
    @Column(name="category")
    private String category;
    @Column(name="platform")
    private String platform;
    @Column(name="price")
    private double price;

    public Game() {
    }

    public Game(String title, int quantity, String category, String platform, double price) {
        this.title = title;
        this.quantity = quantity;
        this.category = category;
        this.platform = platform;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
