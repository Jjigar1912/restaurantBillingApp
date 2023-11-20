package com.example.resturant_billing.model;

public class food_item {

    private Long id;

    private String name;

    private int price;

    private int qty;

    private Long categoryid;

    public food_item(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Long getCategory() {
        return categoryid;
    }

    public void setCategory(Long categoryid) {
        this.categoryid = categoryid;
    }

    @Override
    public String toString() {
        return "food_item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", categoryId=" + categoryid +
                '}';
    }
}
