class Solution {
    int ans = 0; 
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, 0, 0, numbers.length,target);
        answer = ans; 
        return answer;
    }
    
    //dfs를 이용해서 +,- 연산을 순차적으로 모든 경우의 수를 다 시도한다.
    public void dfs(int[] numbers, int sum,int depth, int n,int target) {
        if(depth == n) {
            if(sum == target) {
                System.out.println("입장");
                ans++;
            }
            return;
        }
        
        dfs(numbers, sum + numbers[depth], depth + 1, n, target);
        dfs(numbers, sum - numbers[depth], depth + 1, n, target);
    }
}