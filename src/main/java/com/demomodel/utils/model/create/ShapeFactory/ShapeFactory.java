package com.demomodel.utils.model.create.ShapeFactory;

import com.demomodel.utils.model.create.ShapeFactory.interfaceIMpl.Circle;
import com.demomodel.utils.model.create.ShapeFactory.interfaceIMpl.Rectangle;
import com.demomodel.utils.model.create.ShapeFactory.interfaceIMpl.Shape;
import com.demomodel.utils.model.create.ShapeFactory.interfaceIMpl.Square;

public class ShapeFactory {
    
   //使用 getShape 方法获取形状类型的对象
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
}