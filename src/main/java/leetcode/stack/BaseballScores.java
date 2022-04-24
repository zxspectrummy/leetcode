package leetcode.stack;

import java.util.*;

public class BaseballScores {
    public int calPoints(String[] ops) {
        int sum = 0;
        Deque<Integer> results = new LinkedList<>();
        for(String op:ops) {
            switch (op) {
                case "C" -> sum -= results.pop();
                case "D" -> {
                    int lastElement = results.peek();
                    results.push(lastElement * 2);
                    sum += lastElement * 2;
                }
                case "+" -> {
                    int currentElement = results.pop();
                    int prevElement = results.peek();
                    results.push(currentElement);
                    results.push(currentElement + prevElement);
                    sum += currentElement + prevElement;
                }
                default -> {
                    try {
                        int score = Integer.parseInt(op);
                        results.push(score);
                        sum += score;
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(String.format("Unsupported argument %s", op));
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        new BaseballScores().run();
    }

    private void run() {
        System.out.println(calPoints(new String[] {"5","2","C","D","+"}));
    }
}
