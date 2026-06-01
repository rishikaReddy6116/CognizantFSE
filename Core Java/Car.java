class Car{
    String make;
    String model;
    int year;
    Car(String makee, String modell, int yearr){
        this.make = makee;
        this.model = modell;
        this.year = yearr;
    }
    void DisplayDetails(){
        System.out.println("Country : "+make);
        System.out.println("Model : "+model);
        System.out.println("Year : "+year);
    }
    public static void main(String[] args){
        Car car = new Car("India","Jaguar",1940);
        car.DisplayDetails();
    }
}