/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package compositepattern;

import java.util.ArrayList;

/**
 *
 * @author sedra
 */
public class CompositePattern {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
interface Graphic{
    void move(float x , float y);
    void draw();
    
}
class Dot implements Graphic{
    float x,y;

    public Dot(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Dot() {
    }
    

    @Override
    public void move(float x, float y) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    this.x+=x; 
    this.y+=y;
    }

    @Override
    public void draw() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        System.out.println("A dot has been drawn");
    }
    
}

class Circle extends Dot{
    float radius;
    
    public Circle(float x,float y , float Radius){
        
        
    }
    public void draw(){
        System.out.println("A circle has been drawn whose radius is : "+radius);
    }
    
}


class CompoundGraphic implements Graphic{
    
    ArrayList<Graphic> children = new ArrayList<Graphic>(); // Create an ArrayList object

    public CompoundGraphic() {
    }
    
    public void addChild(Graphic child){
        this.children.add(child);
    }
    public void removeChild(){
        this.children.remove(0);
    }
    
    @Override
    public void move(float x, float y) {
        
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    for(Graphic e : children){
        e.move(x, y);
    }
    
    }

    @Override
    public void draw() {
       
// throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    for(Graphic e : children){
        e.draw();
    }
    }
    
}
class ImageEditor{
    CompoundGraphic all;
    void load(){
        all = new CompoundGraphic();
        all.addChild(new Circle(5,5,5));
        all.addChild(new Dot(2,2));
        
    }
    
     void groupSelected(CompoundGraphic[] components){
         CompoundGraphic group = new CompoundGraphic();
         for (CompoundGraphic component : components){
             group.addChild(component);
         }
         all.addChild(group);
         all.draw();
     }
}