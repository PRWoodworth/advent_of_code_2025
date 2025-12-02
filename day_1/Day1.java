import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {
    
    final int start = 50;
    public static void main(String[] args) {
        Day1 day1 = new Day1();
        day1.part_1();
        day1.part_2();
    }

    private void part_1(){
        int current = start;
        int total_zero = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("day_1/day1_input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                int direction = line.charAt(0) == 'R' ? 1 : -1;
                int amount = Integer.parseInt(line.substring(1));
                switch (direction) {
                    case 1:
                        current += amount;
                        break;
                    case -1:
                        current -= amount;
                        break;
                }
                if(current < 0){
                    current += 100;
                }
                
                current = current % 100;

                if(current == 0){
                    total_zero++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Part 1: " + total_zero);
    }

    private void part_2(){

    }
}