package tasks;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class task2 {
    public static Queue<Integer> generate_queue(String str){
        Queue<Integer> queue = new LinkedList<>();
        String numbers[] = str.split(" ");
        for (int i = numbers.length - 1; i >=0; i--)
            queue.offer(Integer.valueOf(numbers[i]));
        return queue;
    }
    public static String run_game(Queue<Integer> queue1, Queue<Integer> queue2){
        int turns = 1;
        for (;queue1.isEmpty() != true && queue2.isEmpty() != true && turns <=106;turns++){
            if ((queue1.peek() > queue2.peek() && (queue1.peek() != 9 && queue2.peek() != 0)) ||
                    (queue1.peek() == 0 && queue2.peek() == 9)) { // выиграл 1ый
                queue1.offer(queue2.poll());
                queue1.offer(queue1.poll());
            }
            else {
                queue2.offer(queue1.poll());
                queue2.offer(queue2.poll());
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
