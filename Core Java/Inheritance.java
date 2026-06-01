class Animal{
    void makeSound(){
        System.out.println("Animals make different sounds");
    }
}
class Dog extends Animal{
    void makeSound(){
        System.out.println("Bark");
    }
}
class Inheritance{
    public static void main(String[] args){
        Dog d = new Dog();
        d.makeSound();
    }
}