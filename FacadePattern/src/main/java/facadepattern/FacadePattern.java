/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package facadepattern;

/**
 *
 * @author sedra
 */
public class FacadePattern {

    public static void main(String[] args) {
       ShapeMaker shapeMaker = new ShapeMaker();

      shapeMaker.drawCircle();
      shapeMaker.drawRectangle();
      shapeMaker.drawSquare();	
    }
}
 interface Shape {
   void draw();
}

 class Rectangle implements Shape {

   @Override
   public void draw() {
      System.out.println("A rectangle has been drawn");
   }
}
class Square implements Shape {

   @Override
   public void draw() {
      System.out.println("A square has been drawn");
   }
}
 class Circle implements Shape {

   @Override
   public void draw() {
      System.out.println("A circle has been drawn");
   }
}
 class ShapeMaker {
   private Shape circle;
   private Shape rectangle;
   private Shape square;

   public ShapeMaker() {
      circle = new Circle();
      rectangle = new Rectangle();
      square = new Square();
   }

   public void drawCircle(){
      circle.draw();
   }
   public void drawRectangle(){
      rectangle.draw();
   }
   public void drawSquare(){
      square.draw();
   }
}





