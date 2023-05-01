/**
 * 43165. 타겟 넘버
 * n개의 음이 아닌 정수들의 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들기
 * 2 <= n <= 20
 * 1 <= numbers[i] <= 50
 * 1 <= target <= 1000
 */

class Solution {
  
    // 이진트리를 그려서 좌측 간선은 해당 노드값을 더하는 경우, 우측 간선은 해당 노드값을 빼는 경우로 생각해보기
    // 좌측부터 깊이 우선 탐색을 진행하기
  
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
                
        dfs(numbers, 0, target, 0); 
        
        return answer;
    }
    
    public void dfs(int[] numbers, int level, int target, int sum) {
        if (level == numbers.length) { // 끝까지 탐색한 경우
            if (target == sum) { // 타겟 넘버와 일치하면 개수 올리기
                answer++;
            }
        } else { // 탐색할 노드가 남아있는 경우
            dfs(numbers, level+1, target, sum + numbers[level]); // 해당 노드 값 더하기
            dfs(numbers, level+1, target, sum - numbers[level]); // 해당 노드 값 빼기
        }
    }
    
}
