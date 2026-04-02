import java.util.Scanner;
    


class Student {
    int ID;
    String name;
    String lastName;
    double[] lastCSThreeGrades;
    int age;
    double height;
    double weight;
    boolean isEmployee;
    public Student(int code, String n, String l, int a, double h, double w, boolean i, double[] lTGrades) {
        ID = code;
        name = n;
        lastName = l;
        age = a;
        height = h;
        weight = w;
        isEmployee = i;
        lastCSThreeGrades = lTGrades;
    }

    public void FullName() {
        System.out.println(name + " " + lastName);
    }

}


class Box
{
    double length;
    double width;
    double height;
    String color;

    public Box(double l, double w, double h, String c) {
        length = l;
        width = w;
        height = h;
        color = c;
    }

    public Box() {
        length = -1;
        width = -1;
        height = -1;
        color = "Blue";
    }

    public Box(int a) {
        length = a;
        width = a;
        height = a;
        color = "Blue";
    }


    public double volume() {
        return length * width * height;
    }

    public double surfaceArea() {
        return 2 * (length * width + length * height + width * height);
    }
} 
    


class Point {
    double x, y;

    Point(double x, double y) {
        x = x;
        y = y;
    }

    Point(double p) {
        x = p;
        y = p;
    }

    void printPoint() {
        System.out.println("(" + x + ", " + y + ")");
    }
    void quarterPrint() {
        if (x > 0 && y > 0) System.out.println("I quarter");
        else if (x < 0 && y > 0) System.out.println("II quarter");
        else if (x < 0 && y < 0) System.out.println("III quarter");
        else if (x > 0 && y < 0) System.out.println("IV quarter");
    }

double distancePoint(Point d) {
        return Math.sqrt((x - d.x)*(x - d.x) + (y - d.y)*(y - d.y));
    }

Point bigPoint() {
        return new Point(x * 4, y * 4);
    }


    boolean sameLine(Point p) {
        if (x * p.y == y * p.x) return true;
        else return false;
    }

    static boolean isTriangle(Point a, Point b, Point c) {
        if( (b.x - a.x) * (c.y - a.y) != (b.y - a.y) * (c.x - a.x)) return true;
        else return false;
    }


    static double triangleArea(Point a, Point b, Point c) {
        return Math.abs((a.x * (b.y - c.y)) +(b.x * (c.y - a.y)) + (c.x * (a.y - b.y))) / 2.0;
    }

Point midPoint(Point o) {
        return new Point((x + o.x) / 2, (y + o.y) / 2);
    }

    boolean isInsideCircle(Point center, double radius) {
        if (distancePoint(center) <= radius) {
            return true;
        } else {
            return false;
        }
    }

}

class Vector {
    Point start;
    Point end;

    Vector(Point start, Point end) {
        start = start;
        end = end;
    }

void printVector() {
        System.out.print("Vector is ");
        start.printPoint();
        System.out.print(", ");
        end.printPoint();
    }

    double dx() {
        return end.x - start.x;
    }

    double dy() {
        return end.y - start.y;
    }

    double length() {
        return Math.sqrt(dx() * dx() + dy() * dy());
    }

    boolean par(Vector v) {
        return dx() * v.dy() == dy() * v.dx();
    }

double prod(Vector v) {
        return this.dx() * v.dx() + this.dy() * v.dy();
    }

Vector add(Vector v) {
        double newX = this.dx() + v.dx();
        double newY = this.dy() + v.dy();

        Point newEnd = new Point(
                start.x + newX,
                start.y + newY
        );

        return new Vector(this.start, newEnd);
    }
}
public class homework1 {



    public static void main(String[] args) {

        Point point1 = new Point(2, 3);
        Point point2 = new Point(4, 6);
        Point point3 = new Point(5);

        point1.printPoint();
        point2.printPoint();


        point1.quarterPrint();

        System.out.println("Distance: " + point1.distancePoint(point2));

        point3 = point1.bigPoint();
        point3.printPoint();



        System.out.println(point1.sameLine(point2));

        System.out.println(Point.isTriangle(point1, point2, point3));

        System.out.println(Point.triangleArea(point1, point2, new Point(1, 1)));

        Point mid = point1.midPoint(point2);
        mid.printPoint();

        System.out.println(point1.isInsideCircle(new Point(0, 0), 5));

        Scanner input = new Scanner(System.in);
        Student s1 = new Student(1,"Մարիա","Բրուտյան",16,1.60,50,false,
                new double[]{6,6,5});

        Student s2 = new Student(2,"Սերժ","Գանջալյան",16,1.70,60,false,
                new double[]{7,6,6});

        Student s3 = new Student(3,"Անտոն","Խաչատրյան",16,1.72,62,false,
                new double[]{6,7,6});

        Student s4 = new Student(4,"Հենրի","Հարությունյան",16,1.68,58,false,
                new double[]{5,6,5});

        Student s5 = new Student(5,"Հրանտ","Հարությունյան",16,1.75,65,false,
                new double[]{5,6,5});

        Student s6 = new Student(6,"Միքայել","Մադոյան",16,1.69,59,false,
                new double[]{6,5,6});

        Student s7 = new Student(7,"Արման","Մինասյան",16,1.74,63,false,
                new double[]{7,5,5});

        Student s8 = new Student(8,"Էդգար","Միքայելյան",16,1.71,61,false,
                new double[]{7,5,7});

        Student s9 = new Student(9,"Նարեկ","Վելիջանյան",16,1.67,55,false,
                new double[]{5,6,7});


        Box b1 = new Box(2, 3, 4, "Red");

        Box b2 = new Box(1, 1, 1, "Blue");
        
        Box b3 = new Box(5, 5, 5, "Green");

        Box b4 = new Box(2, 2, 2, "Yellow");

        Box b5 = new Box(3, 4, 5, "Purple");
        Box b6 = new Box();
        Box b7 = new Box(3);

        Box[] boxes = {b1, b2, b3, b4, b5, b6, b7};

        for (int i = 0; i < boxes.length; i++) {
            System.out.println("Box " + (i + 1) + ":");
            System.out.println(boxes[i].color);
            System.out.println(boxes[i].volume());
            System.out.println(boxes[i].surfaceArea());
            System.out.println();
        }

        Student[] students = {s1, s2, s3, s4, s5, s6, s7, s8, s9};

        for(int i=0;i<=8;i++){
            students[i].FullName();
            System.out.println(students[i].age);
            System.out.println(students[i].height);
            System.out.println(students[i].weight);
            double sum=0;
            for(int j=0;j<3;j++){
                sum+=students[i].lastCSThreeGrades[j];
            }
            System.out.println("Average grade for " + students[i].name + " " + students[i].lastName + " is " + sum/3);
        }
    }

}
