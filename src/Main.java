import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[][] days = new int[30][];

        for (int i = 0; i < 30; i++) {

            days[i] = new int[i + 1];
        }

        Scanner metod = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("Выберите метод:\n1-Ввести расходы за определенный день\n2-Траты за месяц\n3-Самая большая сумма расхода за месяц\n0-Выход");


            int met = metod.nextInt();

            if (met == 1) {

                System.out.println("Введите номер дня:");
                int dayNumber = metod.nextInt();
                if (dayNumber >= 1 && dayNumber <= 30) {
                    int[] selectedDay = days[dayNumber - 1];
                    if (selectedDay.length > 0) {
                        System.out.println("Траты на день " + dayNumber + " уже указаны. Хотите перезаписать? (y/n)");
                        String overwriteChoice = metod.next();
                        if (!overwriteChoice.equalsIgnoreCase("y")) {
                            break;
                        }
                    }
                    System.out.println("Введите сумму трат на день " + dayNumber + ":");
                    selectedDay[0] = metod.nextInt();
                    boolean addMore = true;
                    while (addMore) {
                        System.out.println("Хотите добавить траты за другой день? (y/n)");
                        String addMoreChoice = metod.next();
                        if (!addMoreChoice.equalsIgnoreCase("y")) {
                            addMore = false;
                        } else {
                            System.out.println("Введите номер дня:");
                            dayNumber = metod.nextInt();
                            if (dayNumber >= 1 && dayNumber <= 30) {
                                selectedDay = days[dayNumber - 1];
                                if (selectedDay.length > 0) {
                                    System.out.println("Траты на день " + dayNumber + " уже указаны. Хотите перезаписать? (y/n)");
                                    String overwriteChoice = metod.next();
                                    if (!overwriteChoice.equalsIgnoreCase("y")) {
                                        continue;
                                    }
                                }
                                System.out.println("Введите сумму трат на день " + dayNumber + ":");
                                selectedDay[0] = metod.nextInt();
                            }
                        }
                    }
                } else {
                    System.out.println("Неверный номер дня. Пожалуйста, выберите от 1 до 30.");
                }
            }
            if (met == 2) {
                for (int i = 0; i < 30; i++) {
                    int[] selectedDay = days[i];
                    if (selectedDay.length > 0) {
                        System.out.println((i + 1) + " день - " + selectedDay[0] + " руб");
                    }
                }
            }
            if (met == 3) {
                int maxSpent = 0;
                int maxSpentDay = 0;
                for (int i = 0; i < 30; i++) {
                    int[] selectedDay = days[i];
                    if (selectedDay.length > 0 && selectedDay[0] > maxSpent) {
                        maxSpent = selectedDay[0];
                        maxSpentDay = i + 1;
                    }
                }
                System.out.println(maxSpentDay + " день - " + maxSpent + " руб");
            }

            if (met == 0) {
                System.out.println("Прощай");
                exit = true;
            }
        }
    }
}