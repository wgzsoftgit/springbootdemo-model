package com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.shape;
public class Square implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Inside Square::draw() method.");
   }
}