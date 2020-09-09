package com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.shape;
public class Rectangle implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}