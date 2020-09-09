package com.demomodel.utils.model.create.ShapeFactory.interfaceIMpl;
public class Circle implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Inside Circle::draw() method.");
   }
}