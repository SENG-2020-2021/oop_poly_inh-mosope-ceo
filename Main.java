import java.util.Scanner;
import java.lang.Math;
//Complete this program that the user will be able to choose the quadilateral it wants to calculate its perimeter and area

class Main {
  public static void main(String[] args) {
    System.out.println("this program allows you to calculate the area and perimeter of any quadilatral listed. Enter P for parallelogram, T for Trapezoid, H for Rhombus, S for Square and R for rectangle NOTE: all inputs must be in capital Case");
  

    Scanner sc = new Scanner(System.in);
    //Declare a char to store the chosen quadilateral
   char selection = sc.next().charAt(0);
    //using a switch check what the user selected and use it to calculate the perimeter and area of the desired quadilateral 
    Scanner scan = new Scanner(System.in);
  switch(selection){

    //this should be in the parallelogram case
    case 'P':
          System.out.println("This program calculates the area and perimeter of the parallelogram.");
          System.out.println("Input the base of your Parallelogram");
         
          float pBase = scan.nextFloat();
          System.out.println("Input the height of your Parallelogram");
          float pHeight = scan.nextFloat();
          Parallelogram p = new Parallelogram(pBase, pHeight);
          
          Quadilateral q = p;

        
          System.out.println("Input the dimension of the first pair of your Parallelogram");
          q.setLength(scan.nextFloat());
          System.out.println("Input the second pair of your Parallelogram");
          q.setBreadth(scan.nextFloat());
          
          System.out.printf("The area of the parallelogram with base %.2f and height %.2f is %.2f", pBase, pHeight, p.Area());

          System.out.println("");
          System.out.printf("The perimeter of the parallelogram with First Pair: %.2f and SecondPair: %.2f is %.2f", q.getLength(), q.getBreadth(), q.calculatePerimeter());
          System.out.println("");
          System.out.println("");
          System.out.println("");
          break;


          //this should be in the Trapezoid case
    case 'T':    
          System.out.println("Calculation for a Trapezoid");
          System.out.println("Input first side");
          float a = scan.nextFloat();
          System.out.println("Input second side");
          float b = scan.nextFloat();
          System.out.println("Input third side");
          float c = scan.nextFloat();
          System.out.println("Input fourth side");
          float d = scan.nextFloat();
          Trapezoid t = new Trapezoid(a, b, c, d);
          System.out.printf("The perimeter of the Trapezoid with First Side: %.2f, Second Side: %.2f, Third Side: %.2f, and Fourth Side: %.2f is %.2f", a, b, c, d, t.calculatePerimeter()); 
          break;
         
         
          //Rhombus case
    case 'H':
          System.out.println("This programs calculates the area and perimeter of the Rhombus");
          System.out.println("Input the first diagonal");
          float d1 = scan.nextFloat();
          System.out.println("Input second diagonal");
          float d2 = scan.nextFloat();
         System.out.println("Input length of side");
          float rs = scan.nextFloat();
          
          Rhombus Rho = new Rhombus(d1, d2, rs);
          System.out.printf("The area of the Rhombus with First diagonal: %.2f and Second diagonal: %.2f is %.2f", d1, d2, Rho.area());
          System.out.println(" ");
          System.out.printf("The perimeter of the Rhombus with First diagonal: %.2f, Second diagonal: %.2f  and side length: %.2f is %.2f", d1, d2,rs, Rho.perimeter());
          break;
    
          //Square case
    case 'S':
    	 System.out.println("This programs calculates the area and perimeter of the Square");
    	 System.out.println("Input side length");
    	 float length = scan.nextFloat();
    	 
    	 Square sqr = new Square(length);
    	 System.out.printf("The area of a square with side: %.2f is %.2f",length, sqr.area());
    	 System.out.println(" ");
    	 System.out.printf("The perimeter of a square with side: %.2f is %.2f",length, sqr.perimeter());
    	 break;
    	 
       //Rectangle case
    case 'R':
    	System.out.println("This programs calculates the area and perimeter of the Rectangle");
    	System.out.println("Input length");
    	float l1 = scan.nextFloat();
    	System.out.println("Insert breadth");
    	float b2 = scan.nextFloat();
    	
    	Rectangle rec = new Rectangle(l1,b2);
   	 	System.out.printf("The area of a rectangle with length: %.2f and breadth: %.2f is %.2f",l1,b2,rec.area());
   	 	System.out.println("");
   	 	System.out.printf("The perimeter of a rectangle with length: %.2f and breadth: %.2f is %.2f", l1,b2,rec.perimeter());


     }
  }
}

//Create class for Rhombus
class Rhombus extends Quadilateral{
  private float diagonal1;
  private float diagonal2;
  private float side;
  public Rhombus(float d1,float d2, float rs){
    diagonal1 = d1;
    diagonal2 = d2;
    side = rs;
    

  }
public float area(){
  return (diagonal1 * diagonal2)/2;
  }
public float perimeter() {
	return 4*side;
	}
}



//Create class for square
class Square extends Quadilateral{
	private float length;
	public Square(float sl) {
	length = sl;	
	}
	
	public float area() {
		return (float) Math.pow(length,2);
	}
	
	public float perimeter() {
		return 4*(length);
	}
}


//create class for Rectangle
class Rectangle extends Quadilateral {
	private float length;
	private float breadth;
	public Rectangle(float l1, float b2) {
		length = l1;
		breadth = b2;
	}
	public float area() {
		return (length*breadth);
	}
	public float perimeter() {
		return 2*(length + breadth);
	}
}





//class for Trapezoid
class Trapezoid extends Quadilateral{
  private float side1;
  private float side2;
  private float side3;
  private float side4;
  public Trapezoid (float a, float b, float c, float d){
    side1 = a;
    side2 = b;
    side3 = c;
    side4 = d;
  }

  public float calculatePerimeter(){
    return side1+side2+side3+side4;
  }
}



class Parallelogram extends Quadilateral{
  private float base;
  private float height;
  public Parallelogram (float b, float h){
    if (b <= 0){
      System.out.println("You cannot have a negative or zero base. Therfore base returns to default which is 1");
      base = 1;
    }
    else
      base = b;
    if (h <= 0){
      System.out.println("You cannot have a negative or zero height. Therfore height returns to default which is 1");
      height = 1;
    }
    else
      height = h;
  }
  public float Area(){
    return base*height;
  }

}

class Quadilateral {
  private float length;
  private float breadth;

  public void setLength(float l){
    length = l;
  }

  public float getLength(){
    return length;
  }

  public void setBreadth(float b){
    breadth = b;
  }

  public float getBreadth(){
    return breadth;
  }

  public float calculatePerimeter(){
    return 2*(length+breadth);
  }
}
