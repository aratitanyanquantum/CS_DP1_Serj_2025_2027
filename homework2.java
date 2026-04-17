class Figure {
    private double dim1;
    private double dim2;
    Figure(double dim1, double dim2){
        this.dim1=dim1;
        this.dim2=dim2;
    }
    Figure (double dim1){
        this(dim1, dim1);
    }

    Figure ()
    {
        this(11);
    }
    public double area()
    {
        return(this.dim1 * this.dim2)/2.0;
    }
    public double getDim1()
    {return dim1;}
    public double getDim2()
    {return dim2;}
    public void setDim1(double x)
    {this.dim1=x;}
    public void setDim2(double x)
    {this.dim2=x;}
}

class Rectangle extends Figure {
    Rectangle(double a, double b){
    super(a,b);}

    public double area()
    {
        return getDim1()*getDim2();
    }
}

class Triangle extends Figure {
    Triangle(double a, double b){
        super(a,b);}

    public double area()
    {
        return (getDim1()*getDim2())/2.0;
    }
}

public class homework2 {
    public static void main(String[] args) {
        Figure f1 = new Figure(10, 20);
        System.out.println("Area " + f1.area());

        Rectangle r1 = new Rectangle(10, 20);
        System.out.println("Area " + r1.area());

        Triangle t1 = new Triangle(10, 20);
        System.out.println("Area " + t1.area());
    }

}