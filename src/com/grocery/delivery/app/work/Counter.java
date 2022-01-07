package com.grocery.delivery.app.work;


import com.grocery.delivery.app.users.Customer;


import java.util.LinkedList;
import java.util.Queue;

public class Counter extends Work {
    Queue<Customer> customers;

    public Counter() {
        this.customers = new LinkedList<>();
    }

    public void addCustomer(Customer customer){ customers.add(customer);}

    public void processCustomers(){
        System.out.println("Processing Customers....");
        if(customers.isEmpty()) {
            completed();
            System.out.println("No Customers..");
        }
        else {
            Customer customer = customers.poll();
            cart = customer.getUserCart();
            System.out.println("Current Customer: "+customer+" cart: "+cart);
            customer.emptyCart();
            store.addDelivery(customer, worker.processCart(cart));
            System.out.println("Customer exiting store: "+customer);
        }
    }
}
