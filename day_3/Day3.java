package day_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day3 {
    public static void main(String[] args) {
        Day3 day3 = new Day3();
        day3.day3_part1();
        // day3.day3_part2();
    }

    public int get_max_outcome(String ratings){
        int max_outcome = 0;
        int largest_num = 0;
        int second_largest_num = 0;
        int second_digit = 0;
        int index = 0;
        int second_index = 0;
        int i = 0;
        int n = ratings.length();
        int[] numList = new int[n];
        for(String s : ratings.split("")){
            numList[i] = Integer.parseInt(s);
            if(numList[i] > largest_num){
                second_largest_num = largest_num;
                second_index = index;
                largest_num = numList[i];
                index = i;
            }
            i++;
        }

        if(index == numList.length - 1){
            index = second_index;
            largest_num = second_largest_num;
        }

        for(int j = index + 1; j < n; j++){
            if(numList[j] > second_digit){
                second_digit = numList[j];

            }
        }
        max_outcome = (largest_num * 10) + second_digit;
        System.out.println("Max outcome for " + ratings + " is: " + max_outcome);
        return max_outcome;
    }
    
    public void day3_part1(){
        try (BufferedReader br = new BufferedReader(new FileReader("day_3/day3_input.txt"))) {
            String line;
            int total_max = 0;
            while ((line = br.readLine()) != null) {
                total_max += get_max_outcome(line);
            }
            System.out.println("Day 3 Part 1: " + total_max);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 

    private void day3_part2() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'day3_part2'");
    }
}