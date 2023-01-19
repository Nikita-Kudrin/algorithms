package com.neon.algorithm.leetcode;


import org.apache.commons.lang3.tuple.Pair;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/submissions/
 *
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * Evaluate the expression. Return an integer that represents the value of the expression.
 *
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 */
public class EvaluateReversePolishNotation {
    private Pair<Integer, Integer> popLastTwoNumbersFromStack(Stack<String> stack) {
        var secondNumber = Integer.valueOf(stack.pop());
        var firstNumber = Integer.valueOf(stack.pop());

        return Pair.of(firstNumber, secondNumber);
    }

    public int evalRPN(String[] tokens) {
        var stack = new Stack<String>();

        Integer previousSymbol = null;

        for (String token : tokens) {
            switch (token) {
                case "+": {
                    var pair = popLastTwoNumbersFromStack(stack);
                    stack.push(String.valueOf(pair.getKey() + pair.getValue()));
                    break;
                }
                case "-": {
                    var pair = popLastTwoNumbersFromStack(stack);
                    stack.push(String.valueOf(pair.getKey() - pair.getValue()));
                    break;
                }
                case "*": {
                    var pair = popLastTwoNumbersFromStack(stack);
                    stack.push(String.valueOf(pair.getKey() * pair.getValue()));
                    break;
                }
                case "/": {
                    var pair = popLastTwoNumbersFromStack(stack);
                    stack.push(String.valueOf(pair.getKey() / pair.getValue()));
                    break;
                }
                default:
                    stack.push(token);
            }
        }

        return Integer.valueOf(stack.pop());
    }
}

