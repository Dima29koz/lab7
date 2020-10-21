package tasks;

import java.util.LinkedList;

public class task4 {
    public static LinkedList<Integer> generate_list(String str){
        LinkedList<Integer> list = new LinkedList<>();
        String numbers[] = str.split(" ");
        for (int i = 0; i < numbers.length; i++)
            list.add(Integer.valueOf(numbers[i]));
        return list;
    }
    public static String run_game(LinkedList<Integer> list1, LinkedList<Integer> list2){
        int turns = 1;
        for (;list1.isEmpty() != true && list2.isEmpty() != true && turns <=106;turns++){
            if ((list1.getLast() > list2.getLast() && (list1.getLast() != 9 && list2.getLast() != 0)) ||
                    (list1.getLast() == 0 && list2.getLast() == 9)) { // выиграл 1ый
                list1.addFirst(list2.pollLast());
                list1.addFirst(list1.pollLast());
            }
            else {
                list2.addFirst(list1.pollLast());
                list2.addFirst(list2.pollLast());
            }
        }
        if (turns >106)
            return "botva";
        else if (list1.isEmpty() == true){
            return "second " + turns;
        }
        else if (list2.isEmpty() == true) {
            return "first " + turns;
        }
        return "";
    }
}
