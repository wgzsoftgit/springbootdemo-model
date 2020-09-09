package com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.color;
public class Green implements Color {
 
   @Override
   public void fill() {
      System.out.println("Inside Green::fill() method.");
   }
}