def solution(record):
    answer = []
    chat=dict()
    for r in record:
        li=r.split(" ")
        if li[0]=="Enter":
            chat[li[1]]=li[2]
        elif li[0]=="Change":
            chat[li[1]]=li[2]
    for i in record:
        li=i.split(" ")
        if li[0]=="Enter":
            answer.append("{}님이 들어왔습니다.".format(chat[li[1]]))
        elif li[0]=="Leave":
            answer.append("{}님이 나갔습니다.".format(chat[li[1]]))
    
    return answer