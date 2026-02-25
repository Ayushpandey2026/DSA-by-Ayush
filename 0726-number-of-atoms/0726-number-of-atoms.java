class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());

        int i = 0;
        while (i < n) {
            char c = formula.charAt(i);

            if (c == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (c == ')') {
                Map<String, Integer> top = stack.pop();
                i++;
                
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int multiplier = (start == i) ? 1 : Integer.parseInt(formula.substring(start, i));
                
                for (String atom : top.keySet()) {
                    int count = top.get(atom);
                    stack.peek().put(atom, stack.peek().getOrDefault(atom, 0) + count * multiplier);
                }
            } else {
                int start = i;
                i++; 
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++;
                String name = formula.substring(start, i);
                
                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int count = (start == i) ? 1 : Integer.parseInt(formula.substring(start, i));
                
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + count);
            }
        }

        StringBuilder sb = new StringBuilder();
        Map<String, Integer> finalMap = stack.pop();
        for (String atom : finalMap.keySet()) {
            sb.append(atom);
            int count = finalMap.get(atom);
            if (count > 1) sb.append(count);
        }
        
        return sb.toString();
    }
}