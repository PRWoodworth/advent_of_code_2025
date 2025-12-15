package day_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2 {
    public static void main(String[] args) {
        Day2 day2 = new Day2();
        day2.part_1();
        day2.part_2();
    }

    public boolean isInvalid(String current_str){
        int str_len = current_str.length();
        String first_half = current_str.substring(0, str_len / 2);
        String second_half = current_str.substring(str_len / 2);
        if(first_half.equals(second_half)){
            return true;
        } 
        return false;
    }

    public boolean isInvalid_Regex(String current_str){
        Pattern pattern = Pattern.compile("^(\\d+)\\1+$");
        Matcher matcher = pattern.matcher(current_str);
        if(matcher.find()){
            return true;
        } 
        return false;
    }

    private void part_1() {
        try (BufferedReader br = new BufferedReader(new FileReader("day_2/day2_input.txt"))) {
            String line;
            String filePath = "day_2/p1_output.txt";
            long invalid_sum = 0;
            FileWriter writer = new FileWriter(filePath);
            while ((line = br.readLine()) != null) {
                String [] parts = line.split(",");
                for(String part : parts){
                    writer.write("Current range: " + part + "\n");
                    String split_part[] = part.split("-");
                    long lowerBound = Long.parseLong(split_part[0]);
                    long upperBound = Long.parseLong(split_part[1]);
                    for(long i = lowerBound; i <= upperBound; i++){
                        //invalid ID = if first half of number = second half of number (i.e. 11, 1212, 123123, etc.)
                        String current_str = Long.toString(i);
                        int str_len = current_str.length();
                        writer.write("Checking ID: " + current_str + "\n");
                        if(str_len % 2 == 0){
                            if(isInvalid(current_str)){
                                writer.write("Invalid ID found: " + i + "\n");
                                invalid_sum += i;
                            } 
                        } else {
                            continue;
                        }
                    }
                }
            }
            writer.close();
            System.out.println("Part 1: " + invalid_sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void part_2() {
        long invalid_sum = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("day_2/day2_input.txt"))) {
            String filePath = "day_2/p2_output.txt";
            FileWriter writer = new FileWriter(filePath);
            String line;
            while ((line = br.readLine()) != null) {
                String [] parts = line.split(",");
                for(String part : parts){
                    String split_part[] = part.split("-");
                    long lowerBound = Long.parseLong(split_part[0]);
                    long upperBound = Long.parseLong(split_part[1]);
                    for(long i = lowerBound; i <= upperBound; i++){
                        String current_str = Long.toString(i);
                        if(isInvalid_Regex(current_str)){
                            writer.write("Invalid ID found: " + i + "\n");
                            invalid_sum += i;
                        } 
                    }
                }
            }
            writer.close();
            System.out.println("Part 2: " + invalid_sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
