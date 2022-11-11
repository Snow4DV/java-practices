package ru.snowadv;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ArrayList<String> licensePlatesList = new ArrayList<>();

        System.out.print("Введите количество номеров: ");
        int size = s.nextInt();
        for (int i = 0; i < size; i++) {
            licensePlatesList.add(LicensePlateGenerator.getRandomLicensePlate());
        }

        System.out.println("Полученные номера: " + licensePlatesList);

        HashSet<String> licensePlatesHashSet = new HashSet<>(licensePlatesList);
        TreeSet<String> licensePlatesTreeSet = new TreeSet<>(licensePlatesList);

        System.out.print("Введите номер для поиска: ");
        String licensePlate = s.next();

        anouneSearchResult("Поиск перебором", ()->licensePlatesList.contains(licensePlate));
        Collections.sort(licensePlatesList);
        anouneSearchResult("Бинарный поиск", ()->(Collections.binarySearch(licensePlatesList, licensePlate)) != -1);
        anouneSearchResult("Поиск в HashSet", ()->licensePlatesHashSet.contains(licensePlate));
        anouneSearchResult("Поиск в TreeSet", ()->licensePlatesTreeSet.contains(licensePlate));

    }

    private static void anouneSearchResult(String searchName, Searcher searcher) {

        long startTimeNs = System.nanoTime();
        boolean result = searcher.search();
        long endTimeNs = System.nanoTime();
        System.out.printf("%s: номер %sнайден, поиск занял %d нс\n", searchName, result ? "" : "не ", endTimeNs - startTimeNs);
    }

    private interface Searcher {
        boolean search();
    }



    private static class LicensePlateGenerator {
        private static final char[] letters = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
        public static String getRandomLicensePlate() {
            return getRandomLicensePlateLetter() + getDigits() + getRandomLicensePlateLetter()
                    + getRandomLicensePlateLetter() + getRegion();
        }


        private static char getRandomLicensePlateLetter() {
            int index = (int) (Math.random() * (letters.length - 1));
            return letters[index];
        }

        private static String getDigits() {
            return String.valueOf((int)(Math.random() * 899 + 100));
        }

        private static String getRegion() {
            return String.valueOf((int) (Math.random() * 198 + 1));
        }


    }

}