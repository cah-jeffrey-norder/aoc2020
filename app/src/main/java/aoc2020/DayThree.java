/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package aoc2020;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;
import java.math.BigInteger;

public class DayThree {

    public static void main(String[] args) {

        try {
            List<String> result = Files.readAllLines(Paths.get("./d3.txt"));
            int height = result.size();
            int width = result.get(0).length();
            int more = ((height * 7) / width) + 1;
            StringBuilder sb;
            for (int x = 0; x < height; x++) {
                sb = new StringBuilder(result.get(x));
                for (int i = 0; i < more; i++) {
                    sb.append(result.get(x));
                }
                result.set(x, sb.toString());
            }
            int widthIndex = 0;
            int a = 0;
            for (String s : result) {
                if (s.charAt(widthIndex) == '#') {
                    a++;
                }
                widthIndex += 1;
            }
            int b = 0;
            widthIndex = 0;
            for (String s : result) {
                if (s.charAt(widthIndex) == '#') {
                    b++;
                }
                widthIndex += 3;
            }
            int c = 0;
            widthIndex = 0;
            for (String s : result) {
                if (s.charAt(widthIndex) == '#') {
                    c++;
                }
                widthIndex += 5;
            }
            int d = 0;
            widthIndex = 0;
            for (String s : result) {
                if (s.charAt(widthIndex) == '#') {
                    d++;
                }
                widthIndex += 7;
            }
            int e = 0;
            widthIndex = 0;
            for (int z = 0; z < result.size() - 1; z = z + 2) {     
                if (result.get(z).charAt(widthIndex) == '#') {
                    e++;
                }
                widthIndex += 1;
            }
            BigInteger answer = new BigInteger(String.valueOf(a));
            answer = answer.multiply(new BigInteger(String.valueOf(b)));
            answer = answer.multiply(new BigInteger(String.valueOf(c)));
            answer = answer.multiply(new BigInteger(String.valueOf(d)));
            answer = answer.multiply(new BigInteger(String.valueOf(e)));
            System.out.println(answer);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
