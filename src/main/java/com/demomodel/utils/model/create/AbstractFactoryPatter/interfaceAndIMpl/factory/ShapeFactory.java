package com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.factory;

import com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.color.Color;
import com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.shape.Circle;
import com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.shape.Rectangle;
import com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.shape.Shape;
import com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.shape.Square;

public class ShapeFactory extends AbstractFactory {
    
   @Override
   public Shape getShape(String shapeType){
      if(shapeType == null){
         return null;
      }        
      if(shapeType.equalsIgnoreCase("CIRCLE")){
         return new Circle();
      } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
         return new Rectangle();
      } else if(shapeType.equalsIgnoreCase("SQUARE")){
         return new Square();
      }
      return null;
   }
   
   @Override
   public Color getColor(String color) {
      return null;
   }
}