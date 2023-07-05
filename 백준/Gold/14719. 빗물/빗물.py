h,w=map(int,input().split())
a=list(map(int,input().split()))
ans=0
for i in range(1,w-1):
    left_max=max(a[:i])
    right_max=max(a[i+1:])    
    
    compare = min(left_max,right_max)

    if compare>a[i]:
        ans+=compare-a[i]

print(ans)

