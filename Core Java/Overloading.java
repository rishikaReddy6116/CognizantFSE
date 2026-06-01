class Overloading{
    public static void main(String[] args){
        Overloading obj = new Overloading();
        System.out.println(obj.add(5,6));
        System.out.println(obj.add(5.5,6.7));
        System.out.println(obj.add(3,4,5));
    }
    int add(int a, int b){
        return a+b;
    }
    double add(double a , double b){
        return a+b;
    }
    int add(int a, int b, int c){
        return a+b+c;
    }
}