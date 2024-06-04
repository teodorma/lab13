package Task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Aparitii {
    private char c;
    private int s;

    Aparitii(char c) {
        this.c = c;
        this.s = 0;
    }

    public synchronized void incrementCount() {
        this.s++;
    }

    public int getCount() {
        return this.s;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Task6.Aparitii <filename>");
            return;
        }

        String filename = args[0];

        Aparitii aparitii = new Aparitii('c');

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                String finalLine = line;
                Thread thread = new Thread(() -> aparitii.func(finalLine));
                thread.start();
                thread.join();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total occurrences of character 'c': " + aparitii.getCount());
    }

    public void func(String line) {
        for (char i : line.toCharArray()) {
            if (i == c) {
                incrementCount();
            }
        }
    }
}
