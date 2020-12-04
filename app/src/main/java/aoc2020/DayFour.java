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
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DayFour {

    public static void main(String[] args) {

        try {
            List<String> result = Files.readAllLines(Paths.get("./d4.txt"));
            List<String> passports = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for(String s : result) {
                if(!s.equals("")) {
                    sb.append(s + " ");
                } else {
                    passports.add(sb.toString());
                    sb = new StringBuilder();
                }  
            }
            passports.add(sb.toString());
            int counter = 0;
            int fail = 0;
            Map<String, String> map;
            for (String s : passports) {
                /*
                byr (Birth Year)
                iyr (Issue Year)
                eyr (Expiration Year)
                hgt (Height)
                hcl (Hair Color)
                ecl (Eye Color)
                pid (Passport ID)
                */
                map = new HashMap<String, String>();
                String parts[] = s.split(" ");
                for(String part : parts){
                    String fields[] = part.split(":");   
                    String key = fields[0].trim();
                    String value = fields[1].trim();
                    map.put(key, value);
                }

                if (validateBirthYear(map.get("byr")) &&
                    validateIssueYear(map.get("iyr")) &&
                    validateExpirationYear(map.get("eyr")) &&
                    validateHeight(map.get("hgt")) &&
                    validateHair(map.get("hcl")) &&
                    validateEye(map.get("ecl")) &&
                    validatePassportID(map.get("pid"))) {
                        counter++;
                } else {
                    fail++;
                }
                //System.out.println(s);


            }
            System.out.println(counter);
            System.out.println(fail);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private static boolean validateBirthYear(String birthYear) {
        if (birthYear == null) return false;
        return validateYear(1920, 2002, Integer.parseInt(birthYear));
    }

    private static boolean validateIssueYear(String issueYear) {
        if (issueYear == null) return false;
        return validateYear(2010, 2020, Integer.parseInt(issueYear));
    }

    private static boolean validateExpirationYear(String expirationYear) {
        if (expirationYear == null) return false;
        return validateYear(2020, 2030, Integer.parseInt(expirationYear));
    }

    private static boolean validateYear(int minYear, int maxYear, int testYear) {
        if (testYear >= minYear && testYear <= maxYear) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean validateHeight(String height) {
        /**
        hgt (Height) - a number followed by either cm or in:
            If cm, the number must be at least 150 and at most 193.
            If in, the number must be at least 59 and at most 76.
        */
        if (height == null) return false;
        Pattern pattern = Pattern.compile("^[0-9]+(cm$|in$)");
        Matcher matcher = pattern.matcher(height);
        if(matcher.find()) {
            String units = height.substring(height.length() - 2, height.length());
            int value = Integer.parseInt(height.substring(0, height.indexOf(units)));
            if (units.equals("cm") && value >= 150 && value <= 193) {
                return true;
            } else if (units.equals("in") && value >= 59 && value <= 76) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    private static boolean validateHair(String hair) {
        //^#([a-f]|[0-9]){6}$
        if (hair == null) return false;
        Pattern pattern = Pattern.compile("^#([a-f]|[0-9]){6}$");
        Matcher matcher = pattern.matcher(hair);
        return matcher.find();
    }

    private static boolean validateEye(String eye) {
        //^#([a-f]|[0-9]){6}$
        if (eye == null) return false;
        Pattern pattern = Pattern.compile("^(amb|blu|brn|gry|grn|hzl|oth)$");
        Matcher matcher = pattern.matcher(eye);
        return matcher.find();
    }

    private static boolean validatePassportID(String passport) {
        //^#([a-f]|[0-9]){6}$
        if (passport == null) return false;
        Pattern pattern = Pattern.compile("^[0-9]{9}$");
        Matcher matcher = pattern.matcher(passport);
        return matcher.find();
    }
    //amb blu brn gry grn hzl oth
}
