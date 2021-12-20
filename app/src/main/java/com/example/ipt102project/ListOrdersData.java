package com.example.ipt102project;

public class ListOrdersData {



    private String FoodMenu_foodname;
    private int imgID;
    private double FoodMenu_foodprice;
    private double SubtotalValue;
    private boolean itemHasPearls;
    private int quantity;


    public ListOrdersData(String FoodMenu_foodname, double FoodMenu_foodprice, double SubtotalValue, boolean itemHasPearls, int quantity){
        this.setFoodMenu_foodname(FoodMenu_foodname);
//        this.setImgID(imgID);
        this.setFoodMenu_foodprice(FoodMenu_foodprice);
        this.setSubtotalValue(SubtotalValue);
        this.setItemHasPearls(itemHasPearls);
        this.setQuantity(quantity);
    }


    public String getFoodMenu_foodname() {
        return FoodMenu_foodname;
    }

    public void setFoodMenu_foodname(String foodMenu_foodname) {
        FoodMenu_foodname = foodMenu_foodname;
    }

//    public int getImgID() {
//        return imgID;
//    }
//
//    public void setImgID(int imgID) {
//        this.imgID = imgID;
//    }

    public double getFoodMenu_foodprice() {
        return FoodMenu_foodprice;
    }

    public void setFoodMenu_foodprice(double foodMenu_foodprice) {
        FoodMenu_foodprice = foodMenu_foodprice;
    }

    public double getSubtotalValue() {
        return SubtotalValue;
    }

    public void setSubtotalValue(double subtotalValue) {
        SubtotalValue = subtotalValue;
    }

    public boolean isItemHasPearls() {
        return itemHasPearls;
    }

    public void setItemHasPearls(boolean itemHasPearls) {
        this.itemHasPearls = itemHasPearls;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
