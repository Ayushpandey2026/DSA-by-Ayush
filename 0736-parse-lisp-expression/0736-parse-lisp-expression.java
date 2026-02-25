class Solution {
    public int evaluate(String expression) {
        return eval(expression, new HashMap<>());
    }

    private int eval(String exp, Map<String, Integer> parentScope) {
        if (exp.charAt(0) != '(') {
            if (Character.isDigit(exp.charAt(0)) || exp.charAt(0) == '-') {
                return Integer.parseInt(exp);
            }
            return parentScope.get(exp);
        }

        Map<String, Integer> scope = new HashMap<>(parentScope);
        
        String inner = exp.substring(exp.indexOf(' ') + 1, exp.length() - 1);
        int firstSpace = inner.indexOf(' ');
        String cmd = (firstSpace == -1) ? inner : inner.substring(0, firstSpace);

        if (exp.startsWith("(add")) {
            List<String> subExps = parse(exp.substring(5, exp.length() - 1));
            return eval(subExps.get(0), scope) + eval(subExps.get(1), scope);
        } else if (exp.startsWith("(mult")) {
            List<String> subExps = parse(exp.substring(6, exp.length() - 1));
            return eval(subExps.get(0), scope) * eval(subExps.get(1), scope);
        } else { 
            List<String> subExps = parse(exp.substring(5, exp.length() - 1));
            for (int i = 0; i < subExps.size() - 1; i += 2) {
                scope.put(subExps.get(i), eval(subExps.get(i + 1), scope));
            }
            return eval(subExps.get(subExps.size() - 1), scope);
        }
    }

    private List<String> parse(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            int start = i;
            if (s.charAt(i) == '(') {
                int bal = 0;
                while (i < n) {
                    if (s.charAt(i) == '(') bal++;
                    if (s.charAt(i) == ')') bal--;
                    i++;
                    if (bal == 0) break;
                }
            } else {
                while (i < n && s.charAt(i) != ' ') i++;
            }
            res.add(s.substring(start, i));
        }
        return res;
    }
}