/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package adapterpattern;

/**
 *
 * @author sedra
 */
public class AdapterPattern {

    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        System.out.println("Does Round Hole of radius 5 fits round peg of radius 5 :" + hole.fits(rpeg));
        SquarePeg small_sqpeg = new SquarePeg(5);
SquarePeg large_sqpeg = new SquarePeg(10);
//hole.fits((small_sqpeg); 

 SquarePegAdapter small_sqpeg_adapter = new SquarePegAdapter(small_sqpeg);
SquarePegAdapter large_sqpeg_adapter = new SquarePegAdapter(large_sqpeg);
        System.out.println("Does hole fits the small Square Peg : " +hole.fits(small_sqpeg_adapter)  );
    System.out.println("Does hole fits the Large Square Peg : " + hole.fits(large_sqpeg_adapter) ) ; 
       
    }
}



class RoundHole{
    private float radius;
    public RoundHole(float radius){
        this.radius=radius;
        
    }
    public float getRadius(){
        return this.radius;
    }
    
    public boolean fits(RoundPeg peg){
        return this.radius>=peg.getRadius();
    }
    
}
class RoundPeg{
    private float radius;
    public RoundPeg(float radius){
        this.radius=radius;
    }
    public float getRadius(){
        return this.radius;
    }
    
}
class SquarePeg {
    private float Width;
    public SquarePeg(float Width){
        this.Width= Width;
    }
    public float getWidth(){
        return this.Width;
    }
    
}
class SquarePegAdapter extends RoundPeg{
    private SquarePeg peg;
   
    public SquarePegAdapter(SquarePeg peg){
        super(5f);
        this.peg = peg;
        
        
        
    }
    public float getRadius(){
        return(float)( peg.getWidth() )*((float) Math.sqrt(2)/2);
    }
    
}