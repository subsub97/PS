import java.util.*;

class Solution {
    int answer = 0;
    ArrayList<Integer> num = new ArrayList<>();
    boolean[] check = new boolean[10000000];
    boolean[] selected;
        
    public int solution(String numbers) {
    
        selected = new boolean[numbers.length()];
        int[] number = new int[numbers.length()];
            
        for(int i = 0; i < numbers.length(); i++) {
            number[i] = Integer.parseInt(numbers.substring(i,i+1));
        }
        
        choose(0, number);
        
        return answer;
    }
    
    public void choose(int depth, int[] number) {
        if(isPrime()) {
            for(int i = 0; i < num.size(); i++) {
                System.out.print(num.get(i));
                
            }
            System.out.println();
            answer++;
        }
            
        if(depth == number.length) {
            return;
        }
        
        for(int i = 0; i < number.length; i++) {
            if(selected[i]) continue;
            if(num.size() == 0 && number[i] == 0) continue;
            
            selected[i] = true;
            num.add(number[i]);
            choose(depth+1, number);
            num.remove(num.size() - 1);
            selected[i] = false;
            
        }
    }

    public boolean isPrime() {
        if(num.size() == 0) return false;
        
        String tempNum = "";
            
        for(int i = 0; i < num.size(); i++) {
            tempNum += num.get(i);
        }
        
        int number = Integer.parseInt(tempNum);
        if(number == 1) return false;
        if(check[number]) return false;
        check[number] = true;
        
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i  == 0) return false;
        }
        return true;
    }
    
    
}