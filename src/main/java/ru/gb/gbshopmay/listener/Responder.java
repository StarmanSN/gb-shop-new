package ru.gb.gbshopmay.listener;

public class Responder implements CustomListener {

    @Override
    public void addData() {
        System.out.println("Product add to cart");
    }

    @Override
    public void removeData() {
        System.out.println("Product removed from cart");
    }

    @Override
    public void updateData() {

    }
}
