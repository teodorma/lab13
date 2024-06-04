package Task5;

import java.util.ArrayList;
import java.util.List;

public class Bilant implements Comparable<Bilant>{
    private int a;
    private int b;

    public Bilant(){
        this.a = 0;
        this.b = 0;
    }

    public Bilant(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int compareTo(Bilant obj1){
        int c = this.a - this.b;
        int d = obj1.a - obj1.b;
        return Integer.compare(d, c);
    }

    public static void main(String[] args){
        List<Bilant> bilants = new ArrayList<>();
        bilants.add(new Bilant(1,4));
        bilants.add(new Bilant(2,1));
        bilants.add(new Bilant(3,10));

        List<Bilant> bilants_sortat = bilants.stream().sorted().toList();
        for (Bilant bilant : bilants_sortat) {
            System.out.println(bilant);
        }
    }

    @Override
    public String toString() {
        return this.a + " " + this.b + "\n";
    }

}
