n=int(input())
ma=[]
all_people=0
for i in range(n):
    a,b=map(int,input().split())
    ma.append((a,b))
    all_people+=b

ma.sort(key=lambda x: x[0])
count=0
for i in range(n):
    count+=ma[i][1]
    if count >= all_people/2:
        print(ma[i][0])
        break