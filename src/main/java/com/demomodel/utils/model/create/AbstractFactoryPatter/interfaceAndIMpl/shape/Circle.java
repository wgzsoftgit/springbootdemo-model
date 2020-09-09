package com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.shape;
public class Circle implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Inside Circle::draw() method.");
   }
}