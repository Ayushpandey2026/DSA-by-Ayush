import java.util.*;

class DinnerPlates {
    private int capacity;
    private List<Stack<Integer>> stacks;
    private TreeSet<Integer> availableStacks;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        this.stacks = new ArrayList<>();
        this.availableStacks = new TreeSet<>();
    }

    public void push(int val) {
        if (availableStacks.isEmpty()) {
            stacks.add(new Stack<>());
            availableStacks.add(stacks.size() - 1);
        }
        
        int leftmostIndex = availableStacks.first();
        Stack<Integer> stack = stacks.get(leftmostIndex);
        stack.push(val);
        
        if (stack.size() == capacity) {
            availableStacks.remove(leftmostIndex);
        }
    }

    public int pop() {
        return popAtStack(stacks.size() - 1);
    }

    public int popAtStack(int index) {
        if (index < 0 || index >= stacks.size() || stacks.get(index).isEmpty()) {
            if (index == stacks.size() - 1 && index >= 0) {
                stacks.remove(stacks.size() - 1);
                availableStacks.remove(index);
                return pop();
            }
            return -1;
        }

        Stack<Integer> stack = stacks.get(index);
        int val = stack.pop();
        
        availableStacks.add(index);

        while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
            int lastIdx = stacks.size() - 1;
            stacks.remove(lastIdx);
            availableStacks.remove(lastIdx);
        }

        return val;
    }
}