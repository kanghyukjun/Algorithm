# https://ywtechit.tistory.com/79 참고
import sys
input = sys.stdin.readline

n,m = map(int,input().split())
arr = list(map(int,input().split()))
sum = [0]
tmp = 0

for i in arr:
    tmp+=i
    sum.append(tmp)

for i in range(m):
    i,j=map(int,input().split())
    print(sum[j]-sum[i-1])