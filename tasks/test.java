package tasks;

public class test {
    public static void main(String[] args) {
        String str1 = "1 3 5 7 9";
        String str2 = "2 4 6 8 0";
        System.out.println("task1: " + task1.run_game(task1.generate_stack(str1), task1.generate_stack(str2))); // Stack.
        System.out.println("task2: " + task2.run_game(task2.generate_queue(str1), task2.generate_queue(str2))); // Queue
        System.out.println("task3: " + task3.run_game(task3.generate_dequeue(str1), task3.generate_dequeue(str2))); // Dequeue.
        System.out.println("task4: " + task4.run_game(task4.generate_list(str1), task4.generate_list(str2))); // List
    }
}
