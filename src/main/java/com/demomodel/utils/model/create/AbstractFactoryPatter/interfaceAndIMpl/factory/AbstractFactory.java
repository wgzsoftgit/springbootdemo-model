package com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.factory;

import com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.color.Color;
import com.demomodel.utils.model.create.AbstractFactoryPatter.interfaceAndIMpl.shape.Shape;

public abstract class AbstractFactory {
   public abstract Color getColor(String color);
   public abstract Shape getShape(String shape) ;
}