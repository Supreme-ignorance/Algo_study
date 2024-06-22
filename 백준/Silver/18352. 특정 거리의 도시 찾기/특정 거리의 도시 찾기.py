from collections import deque

N, M, K, X = map(int, input().split())
graph = [[] for _ in range(N + 1)]

for _ in range(M):
    start, end = map(int, input().split())
    graph[start].append(end)

# setting
# 모든 도시에 대한 최단거리 초기화
visited = [-1] * (N + 1)
visited[X] = 0

# print(graph)
# print(visited)
queue = deque([X])
while queue:
    now = queue.popleft()
    for next_node in graph[now]:
        if visited[next_node] == -1:
            visited[next_node] = visited[now] + 1
            queue.append(next_node)

flag = False
for i in range(1, N + 1):
    if visited[i] == K:
        print(i)
        flag = True

if not flag:
    print(-1)

# def bfs(idx):
#     queue = deque([idx])
#     
#     while queue:
#         cur_idx = queue.popleft()
#         for next in graph[cur_idx]:
#             if visited[next] == -1:
#                 visited[next] = visited[cur_idx] + 1
#                 queue.append(next)
# 
# 
# bfs(X)