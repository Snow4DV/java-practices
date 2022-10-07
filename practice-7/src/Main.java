import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter task no [1/2]: ");
        int ex = scanner.nextInt();
        scanner.nextLine(); // ignore next line char
        switch(ex) {
            case 1:
                drunkenStack(scanner);
                break;
            case 2:
                drunkenQueue(scanner);
        }
    }

    private static void drunkenStack(Scanner scanner) {
        Stack<Integer> playerOneCards = new Stack<>(), playerTwoCards = new Stack<>();
        for (int i = 0; i < 10; i++) {
            (i < 5 ? playerOneCards : playerTwoCards).push(scanner.nextInt());
        }

        for (int step = 1; step <= 106; step++) {
            int playerOneCard = playerOneCards.pop(), playerTwoCard = playerTwoCards.pop();
            if(playerOneCard == 9 && playerTwoCard == 0 || (playerTwoCard > playerOneCard && !(playerOneCard == 0 && playerTwoCard == 9))) { // Second player wins
                bottomPushStack(playerTwoCards, playerOneCard, playerTwoCard);
            } else { // Player one wins
                bottomPushStack(playerOneCards, playerOneCard, playerTwoCard);
            }

            if(playerOneCards.empty()) {
                System.out.print("second " + step);
                break;
            } else if(playerTwoCards.empty()) {
                System.out.print("first " + step);
                break;
            } else if(step == 106) {
                System.out.print("botva");
            }
        }
    }

    private static void drunkenQueue(Scanner scanner) {
        Queue<Integer> playerOneCards = new ArrayDeque<>(), playerTwoCards = new ArrayDeque<>();
        String[] input1 = scanner.nextLine().split(" ");
        String[] input2 = scanner.nextLine().split(" ");
        for (int i = 0; i < 10; i++) {
            (i < 5 ? playerOneCards : playerTwoCards).add(Integer.valueOf((i < 5 ? input1[4-i] : input2[9-i])));
        }

        for (int step = 1; step <= 106; step++) {
            int playerOneCard = playerOneCards.poll(), playerTwoCard = playerTwoCards.poll();
            if(playerOneCard == 9 && playerTwoCard == 0 || (playerTwoCard > playerOneCard && !(playerOneCard == 0 && playerTwoCard == 9))) { // Second player wins
                playerTwoCards.add(playerOneCard);
                playerTwoCards.add(playerTwoCard);
            } else { // Player one wins
                playerOneCards.add(playerOneCard);
                playerOneCards.add(playerTwoCard);
            }

            if(playerOneCards.isEmpty()) {
                System.out.print("second " + step);
                break;
            } else if(playerTwoCards.isEmpty()) {
                System.out.print("first " + step);
                break;
            } else if(step == 106) {
                System.out.print("botva");
            }
        }
    }



    private static <T> void bottomPushStack(Stack<T> stack, T... objectsToInsert) { // Stack mess
        Stack<T> tempStack = new Stack<>();
        while(!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        for (T objectToInsert :
                objectsToInsert) {
            tempStack.push(objectToInsert);
        }
        while(!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
}