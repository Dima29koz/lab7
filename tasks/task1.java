package tasks;
import java.util.Stack;
public class task1 {
    public static Stack<Integer> generate_stack(String str){
        Stack<Integer> stack = new Stack<>();
        String numbers[] = str.split(" ");
        for (int i = 0; i < numbers.length; i++)
            stack.push(Integer.valueOf(numbers[i]));
        return stack;
    }
    public static String run_game(Stack<Integer> stack1, Stack<Integer> stack2){
        int turns = 1;
        Stack<Integer> tmp = new Stack<>();
        for (;stack1.isEmpty() != true && stack2.isEmpty() != true && turns <=106;turns++)
        {
            tmp.clear();
            if ((stack1.peek() > stack2.peek() && (stack1.peek() != 9 && stack2.peek() != 0)) || (stack1.peek() == 0 && stack2.peek() == 9)){ // выиграл 1ый
                int last_tmp = stack1.pop();
                while (!stack1.empty())
                    tmp.push(stack1.pop());
                stack1.push(stack2.pop());
                stack1.push(last_tmp);
                while (!tmp.empty())
                    stack1.push(tmp.pop());
            }
            else{//выиграл 2ой
                int last_tmp = stack2.pop();
                while (!stack2.empty())
                    tmp.push(stack2.pop());
                stack2.push(stack1.pop());
                stack2.push(last_tmp);
                while (!tmp.empty())
                    stack2.push(tmp.pop());
            }
        }
        if (turns >106)
            return "botva";
        else if (stack1.isEmpty() == true){
            return "second " + turns;
        }
        else if (stack2.isEmpty() == true) {
            return "first " + turns;
        }
        return "";
    }
}
