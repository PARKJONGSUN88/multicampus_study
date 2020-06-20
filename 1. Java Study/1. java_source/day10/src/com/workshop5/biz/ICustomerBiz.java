package com.workshop5.biz;

import com.workshop5.entity.Customer;

public interface ICustomerBiz {
   public abstract void initializeCustomer();
   public abstract void printAllCustomer();
   public abstract void insertCustomer();
   public abstract void insertCustomer(Customer customer); //overload
   public abstract void deleteCustomer();
}
