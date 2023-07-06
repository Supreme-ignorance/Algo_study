import java.util.*;

class Solution {
    
    Deque<Character> operations;
    Deque<Long> numbers;
    long max = 0;
    
    public long solution(String expression) {
        
        operations = new ArrayDeque<>();
        numbers = new ArrayDeque<>();
        
        char[] chars = expression.toCharArray();
        
        String temp = "";
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                temp += (chars[i] + "");
            }
            else { //숫자가 아니면
                long value = Long.parseLong(temp);
                numbers.addLast(value);
                temp = "";
                operations.addLast(chars[i]);
            }
        }
        numbers.addLast(Long.parseLong(temp));
        
        System.out.println(numbers);
        System.out.println(operations);
        
        Deque<Character> tempOper = new ArrayDeque<>(operations);
        Deque<Long> tempNumbers = new ArrayDeque<>(numbers);
        System.out.println(tempOper);
        System.out.println(tempNumbers);
        
        getMax();
                
        long answer = max;
        return answer;
    }
    
    public void getMax() {
        long value = 0;
        Deque<Character> tempOper = new ArrayDeque<>(operations);
        Deque<Long> tempNumbers = new ArrayDeque<>(numbers);
        cal('*', tempOper, tempNumbers);
        cal('+', tempOper, tempNumbers);
        cal('-', tempOper, tempNumbers);
        value = Math.abs(tempNumbers.poll());
        if (value > max) {
            max = value;
        }
        
        tempOper = new ArrayDeque<>(operations);
        tempNumbers = new ArrayDeque<>(numbers);
        cal('*', tempOper, tempNumbers);
        cal('-', tempOper, tempNumbers);
        cal('+', tempOper, tempNumbers);
        value = Math.abs(tempNumbers.poll());
        if (value > max) {
            max = value;
        }
        
        tempOper = new ArrayDeque<>(operations);
        tempNumbers = new ArrayDeque<>(numbers);
        cal('+', tempOper, tempNumbers);
        cal('*', tempOper, tempNumbers);
        cal('-', tempOper, tempNumbers);
        value = Math.abs(tempNumbers.poll());
        if (value > max) {
            max = value;
        }
        
        tempOper = new ArrayDeque<>(operations);
        tempNumbers = new ArrayDeque<>(numbers);
        cal('+', tempOper, tempNumbers);
        cal('-', tempOper, tempNumbers);
        cal('*', tempOper, tempNumbers);
        value = Math.abs(tempNumbers.poll());
        if (value > max) {
            max = value;
        }
        
        tempOper = new ArrayDeque<>(operations);
        tempNumbers = new ArrayDeque<>(numbers);
        cal('-', tempOper, tempNumbers);
        cal('+', tempOper, tempNumbers);
        cal('*', tempOper, tempNumbers);
        value = Math.abs(tempNumbers.poll());
        if (value > max) {
            max = value;
        }
        
        tempOper = new ArrayDeque<>(operations);
        tempNumbers = new ArrayDeque<>(numbers);
        cal('-', tempOper, tempNumbers);
        cal('*', tempOper, tempNumbers);
        cal('+', tempOper, tempNumbers);
        value = Math.abs(tempNumbers.poll());
        if (value > max) {
            max = value;
        }
    }
    
    public void cal(char operation, Deque<Character> operations, Deque<Long> numbers) {
        if (operation == '-') {
            int operSize = operations.size();
            for (int i = 0; i < operSize; i++) {
                long first = numbers.pollFirst();
                char op = operations.pollFirst();
                
                if (op == operation) {
                    numbers.addFirst(first - numbers.pollFirst());
                }
                else {
                    numbers.addLast(first);
                    operations.addLast(op);
                }
            }
            long lastNumber = numbers.pollFirst();
            numbers.addLast(lastNumber);
        }
        if (operation == '+') {
            int operSize = operations.size();
            for (int i = 0; i < operSize; i++) {
                long first = numbers.pollFirst();
                char op = operations.pollFirst();
                
                if (op == operation) {
                    numbers.addFirst(first + numbers.pollFirst());
                }
                else {
                    numbers.addLast(first);
                    operations.addLast(op);
                }
            }
            long lastNumber = numbers.pollFirst();
            numbers.addLast(lastNumber);
        }
        if (operation == '*') {
            int operSize = operations.size();
            for (int i = 0; i < operSize; i++) {
                long first = numbers.pollFirst();
                char op = operations.pollFirst();
                
                if (op == operation) {
                    numbers.addFirst(first * numbers.pollFirst());
                }
                else {
                    numbers.addLast(first);
                    operations.addLast(op);
                }
            }
            long lastNumber = numbers.pollFirst();
            numbers.addLast(lastNumber);
        }
        
    }
}