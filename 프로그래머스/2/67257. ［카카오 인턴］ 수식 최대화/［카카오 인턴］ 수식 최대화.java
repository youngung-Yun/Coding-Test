import java.util.*;

class Solution {
    
    static char[][] priorities = {{'+', '-', '*'}, {'+', '*', '-'},
                                  {'-', '+', '*'}, {'-', '*', '+'},
                                  {'*', '+', '-'}, {'*', '-', '+'}};
     
    public long solution(String expression) {
        List<Long> operands = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        
        long number = 0L;
        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                number *= 10L;
                number += Character.getNumericValue(ch);
            } else {
                operators.add(ch);
                operands.add(number);
                number = 0L;
            }
        }
        operands.add(number);
        
        long answer = 0L;
        for (char[] priority : priorities) {
            List<Long> operandsCopy = new ArrayList<>(operands);
            List<Character> operatorsCopy = new ArrayList<>(operators);
            for (char oper : priority) {
                // operator(i)는 operand(i)와 operand(i+1)에 대해 연산함
                for (int i = 0; i < operatorsCopy.size(); i++) {
                    char ch = operatorsCopy.get(i);
                    if (oper != ch) {
                        continue;
                    }     
                    long result;
                    if (oper == '+') {
                        result = operandsCopy.get(i) + operandsCopy.get(i+1);
                    } else if (oper == '-') {
                        result = operandsCopy.get(i) - operandsCopy.get(i+1);

                    } else {
                       result = operandsCopy.get(i) * operandsCopy.get(i+1); 
                    }
                    operandsCopy.set(i, result);
                    operandsCopy.remove(i+1);
                    operatorsCopy.remove(i);
                    i = -1;
                }
            }
            answer = Long.max(answer, Math.abs(operandsCopy.get(0)));
        }
        
        return answer;
    }
}