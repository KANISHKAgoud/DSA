import java.util.*;
import sum.*;

interface Area
{
  final static float pi=3.14F;
  float compute(float x,float y);
}

class rectangle implements Area
{
  public  float compute (float x, float y)
  {
    return(x*y);
  }
}

class circle implements Area
{
 public float compute(float x , float y)
 {
   return(pi*x*x);
 }
}

class interpack

{

public static void main (String args[])
 {
  rectangle rect = new rectangle();
  circle cir = new circle();
  pack p=new pack();
  
  p.add(10,20);
 
  Area X;   
  X=rect;
  System.out.println(&quot;Area of rectangle:&quot; + X.compute(10,20));

  X= cir;
  System.out.println(&quot;Area of circle:&quot; + X.compute(10,0));
  }
}

//------------------------- end of 1st code---------------------------------------------

//---------------------------2nd code------------------------------------------------------
package sum;
public class pack
 {
   public  void add(double x,double y)
   {
   double z;
   z=x+y;
   System.out.println(&quot; net payment  = &quot;+z);
   }

}
