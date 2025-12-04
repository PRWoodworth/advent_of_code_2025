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
                int remainder = (current + (direction * amount)) % 100;
                current = (remainder < 0) ? remainder + 100 : remainder;
                total_zero += (current == 0) ? 1 : 0;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Part 1: " + total_zero);
    }

    private void part_2(){
        int current = start;
        int total_pass_zero = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("day_1/day1_input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                int direction = line.charAt(0) == 'R' ? 1 : -1;
                int amount = Integer.parseInt(line.substring(1));
                int vel = direction * amount;
                int next = current + vel;
                int passes = 0;
                if(next > 0){
                    passes = next / 100;
                } else if(next == 0){
                    passes = 1;
                } else if(next < 0){
                    passes = (-next + 100) / 100;
                    if(current == 0){
                        passes -= 1;
                    }
                }
                total_pass_zero += passes;
                int remainder = (current + (direction * amount)) % 100;
                current = (remainder < 0) ? remainder + 100 : remainder;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Part 2: " + total_pass_zero);
    }
}