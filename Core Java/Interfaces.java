interface Playable{
    public void play();
}
class Guitar implements Playable{
    public void play(){
        System.out.println("Krish knows to play Guitar");
    }
}
class Piano implements Playable{
    public void play(){
        System.out.println("Krish knows to play Piano");
    }
}
class Interfaces{
    public static void main(String []args){
        Guitar g = new Guitar();
        g.play();
        Piano p = new Piano();
        p.play();
    }
}