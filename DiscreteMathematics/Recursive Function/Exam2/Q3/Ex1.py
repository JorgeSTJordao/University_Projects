def rec(list_, i):
    a = list_[i] + 3
    b = list_[i] * 2
    list_.append(a)
    list_.append(b)
    if a > 19 and b > 19:
        return list_
    else:
        list_c = set(list_)
        list_ = list(list_c)
        list_.sort()
        return rec(list_, i + 1)
def main():
    i = 0
    list_ = [2]
    list_w = [6, 7, 19, 12]
    list_f = rec(list_, i)
    print(list_f)

    for i in list_f:
        if i in list_w:
            print(f"O valor {i} está na array")
main()