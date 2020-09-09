package com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl;

import com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.factory.AbstractFactory;
import com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.factory.ColorFactory;
import com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.factory.ShapeFactory;

public class FactoryProducer {
   public static AbstractFactory getFactory(String choice){
      if(choice.equalsIgnoreCase("SHAPE")){
         return new ShapeFactory();
      } else if(choice.equalsIgnoreCase("COLOR")){
         return new ColorFactory();
      }
      return null;
   }
}