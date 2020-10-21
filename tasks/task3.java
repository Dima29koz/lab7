package tasks;
import java.util.ArrayDeque;

public class task3 {
    public static ArrayDeque<Integer> generate_dequeue(String str){
        ArrayDeque<Integer> dequeue = new ArrayDeque<>();
        String numbers[] = str.split(" ");
        for (int i = 0; i < numbers.length; i++)
            dequeue.addLast(Integer.valueOf(numbers[i]));
        return dequeue;
    }
    public static String run_game(ArrayDeque<Integer> queue1, ArrayDeque<Integer> queue2){
        int turns = 1;
        for (;queue1.isEmpty() != true && queue2.isEmpty() != true && turns <=106;turns++){
            if ((queue1.getLast() > queue2.getLast() && (queue1.getLast() != 9 && queue2.getLast() != 0)) ||
                    (queue1.getLast() == 0 && queue2.getLast() == 9)) { // выиграл 1ый
                queue1.addFirst(queue2.pollLast());
                queue1.addFirst(queue1.pollLast());
            }
            else {
                queue2.addFirst(queue1.pollLast());
                queue2.addFirst(queue2.pollLast());
            }
        }
        if (turns >106)
            return "botva";
        else if (queue1.isEmpty() == true){
            return "second " + turns;
        }
        else if (queue2.isEmpty() == true) {
            return "first " + turns;
        }
        return "";
    }
}
