package org.example;

public class Recursion_Combination {
    public static void main(String[] args) {
        System.out.println(recursionCombination_caseNum(5, 3));
    }

    // 재귀 함수 구현
    // 조합으로 뽑는 경우의 수 구하기
    public static int recursionCombination_caseNum(int left, int right){
        if(left == right || right == 0){
            return 1;
        }
        else{
            return recursionCombination_caseNum(left-1, right-1) + recursionCombination_caseNum(left-1, right);
        }
    }
}
