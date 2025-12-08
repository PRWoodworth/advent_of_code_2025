package day_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {
    public static void main(String[] args) {
        Day2 day2 = new Day2();
        day2.part_1();
        day2.part_2();
    }

    private void part_1() {
        try (BufferedReader br = new BufferedReader(new FileReader("day_2/day2_input.txt"))) {
            String line;
            int invalid_sum = 0;
            while ((line = br.readLine()) != null) {
                String [] parts = line.split(",");
                for(String part : parts){
                    long lowerBound = Long.parseLong(part.split("-")[0]);
                    long upperBound = Long.parseLong(part.split("-")[1]);
                    for(long i = lowerBound; i <= upperBound; i++){

                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void part_2() {
        try (BufferedReader br = new BufferedReader(new FileReader("day_1/day1_input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
