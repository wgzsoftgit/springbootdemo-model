package com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.factory;

import com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.color.Blue;
import com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.color.Color;
import com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.color.Green;
import com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.color.Red;
import com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.shape.Shape;

public class ColorFactory extends AbstractFactory {
    
   @Override
   public Shape getShape(String shapeType){
      return null;
   }
   
   @Override
   public Color getColor(String color) {
      if(color == null){
         return null;
      }        
      if(color.equalsIgnoreCase("RED")){
         return new Red();
      } else if(color.equalsIgnoreCase("GREEN")){
         return new Green();
      } else if(color.equalsIgnoreCase("BLUE")){
         return new Blue();
      }
      return null;
   }
}