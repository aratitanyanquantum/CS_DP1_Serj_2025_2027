class Twostacks {
    private int[] arr;
    private int top1; 
    private int top2; 
    private int size;

    public Twostacks(int n) {
        size = n;
        arr = new int[n];
        top1 = -1;       
        top2 = n;       
    }

    public void push1(int x) {
        if (top1 < top2 - 1) { 
            arr[++top1] = x;
        } 
    }

    public void push2(int x) {
        if (top1 < top2 - 1) {
            arr[--top2] = x;
        } 
    }

    public int pop1() {
        if (top1 >= 0) {
            int num = arr[top1--];
            arr[top1 ] = 0;
            return num;
        } else {
            return -1;
        }
    }

    public int pop2() {
        if (top2 < size) {
            int num = arr[top2++];
            arr[top2 ] = 0;
            return num;
        } else {
            return -1;
        }
    }
}
public class homework3 {
    public static void main(String[] args) {
        Twostacks TwoSt = new Twostacks(6);
        TwoSt.push1(4);
        TwoSt.push1(1);
        TwoSt.push1(3);
        TwoSt.pop1();
        TwoSt.push1(8);
        TwoSt.pop1();










    }
}
