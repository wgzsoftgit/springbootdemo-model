package com.demomodel.utils.model.create.ShapeFactory.interfaceIMpl;
public class Rectangle implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}