package com.engeto.first.project;

import java.util.ArrayList;

public class Orders  {

    //Atributy
    private Table table;
    private ArrayList<Order> orders = new ArrayList<>();


    // Konstruktory
    public Orders(Table table)
    {
        this.table = table;
    }

    // Metody

    public int getTableNumber() {
        return table.getNumber();
    }

    public void addOrder(Order order)
    {
        this.orders.add(order);
    }

//    public void saveOrdersToFile(String filename, List<Order> orderList) throws RestaurantException {
//        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
//            for (Order order : orderList) {
//                writer.println(order.toString());
//            }
//        } catch (IOException e) {
//            throw new RestaurantException("Nastala chyba při ukládání objednávek do souboru.");
//        }
//    }

    @Override
    public String toString() {

        String returnString = "";
        int i = 1;
        // Print orders for each table

                for (Order order : this.orders) {
                        returnString += ("\n" +
                                i +
                                ". " +
                                order.getDishFromCurrentMenu() +
                                " " +
                                this.getTotalPriceAsString(order) +
                                Settings.delimiter() +
                                order.getOrderedTime() +
                                this.orderClosed(order) +
                                Settings.delimiter() +
                                " číšník č. " + order.getWaiterId());
                        i++;
                }


        return returnString;
    }

    private String getTotalPriceAsString(Order order) {
        if (order.getOrderedAmount() > 1)
            return order.getOrderedAmount() + "x (" + order.getTotalPrice()+" Kč):";
        else return " (" + order.getTotalPrice()+" Kč):";
    }

    private String orderClosed(Order order) {
        if (order.getFulfilmentTime() == null)
            return "- objednávka nedokončena";
        else return "-" + order.getFulfilmentTime();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
