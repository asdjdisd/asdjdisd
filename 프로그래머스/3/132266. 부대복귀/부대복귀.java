import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        // 인접 리스트 초기화
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Integer>());
        }
        
        // 도로 정보를 인접 리스트에 추가
        for (int q = 0; q < roads.length; q++) {
            list.get(roads[q][0]).add(roads[q][1]);
            list.get(roads[q][1]).add(roads[q][0]);
        }
        
        // 각 source에 대해 최단 거리 계산
        for (int q = 0; q < sources.length; q++) {
            if (sources[q] == destination) {
                answer[q] = 0;
                continue;
            }
            
            // BFS를 위한 큐와 방문 집합
            Queue<Integer> que = new LinkedList<>();
            boolean[] visited = new boolean[n + 1];
            que.add(sources[q]);
            visited[sources[q]] = true;
            int count = 0;
            
            boolean found = false;
            while (!que.isEmpty() && !found) {
                int size = que.size();
                count++;
                
                for (int i = 0; i < size; i++) {
                    int current = que.poll();
                    for (int neighbor : list.get(current)) {
                        if (!visited[neighbor]) {
                            if (neighbor == destination) {
                                answer[q] = count;
                                found = true;
                                break;
                            }
                            que.add(neighbor);
                            visited[neighbor] = true;
                        }
                    }
                    if (found) break;
                }
            }
            
            if (!found) {
                answer[q] = -1;
            }
        }
        return answer;
    }
}
