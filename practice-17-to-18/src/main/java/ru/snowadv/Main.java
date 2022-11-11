package ru.snowadv;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String test1 = "abcdefghijklmnopqrstuv18340";
        String test2 = "abcdefghijklmnopdqrstuv184312340";
        System.out.println("Задание 1. Регулярка: '^abcdefghijklmnopqrstuv18340$'");
        System.out.printf("Тестируем '%s'. Результат: %b\n", test1, checkIfAtoV18340(test1));
        System.out.printf("Тестируем '%s'. Результат: %b\n", test2, checkIfAtoV18340(test2));

        test1 = "Ff:01:Ab:Cd:Ee:12";
        test2 = "Dd:Zz:He:ll:ooo";
        System.out.println("Задание 2. Регулярка: ([a-fA-F0-9]{2}:){5}[a-fA-F0-9]{2}");
        System.out.printf("Тестируем '%s'. Результат: %b\n", test1, isMacAddress(test1));
        System.out.printf("Тестируем '%s'. Результат: %b\n", test2, isMacAddress(test2));

        test1 = "Петя разбил машину об отбойник на Нюрбургринге и зацепил впередиедущего участника трек-дня.\nРемонт авто встал ему в 300000 RUR. " +
                "Администрация попросила у него 32132.6452 EU за ремонт отбойника, а американец,\nчью машину он зацепил, попросил компенсацию в размере " +
                "5000 USD";
        System.out.println("Задание 3. Регулярка: ((?<=(\\\\s|[^0-9]))|^)([0-9]+)(\\\\.[0-9]+)?\\\\s(USD|RUR|EU)((?=([^a-zA-Z]))|$)");
        System.out.printf("Тестовый текст: '%s'\n", test1);
        System.out.println("Результат: " + getPrices(test1).toString());
    }



    private static boolean checkIfAtoV18340(String string) {
        Pattern pattern = Pattern.compile("^abcdefghijklmnopqrstuv18340$");
        return pattern.matcher(string).matches();
    }

    private static boolean isMacAddress(String mac) {
        Pattern pattern = Pattern.compile("([a-fA-F0-9]{2}:){5}[a-fA-F0-9]{2}");
        return pattern.matcher(mac).matches();
    }

    private static Collection<String> getPrices(String text) {
        Matcher matcher = Pattern.compile("((?<=(\\s|[^0-9]))|^)([0-9]+)(\\.[0-9]+)?\\s(USD|RUR|EU)((?=([^a-zA-Z]))|$)").matcher(text);
        ArrayList<String> matches = new ArrayList<>();
        while(matcher.find()) {
            matches.add(matcher.group());
        }
        return matches;
    }
}