def rec(l, j):
    i = l[j - 1]
    if j == 1:
        return l
    else:
        return(l, )


def main():
    i = 0
    l = [3, 7, 4, 2, 6]
    print(rec(l, 5))
main ()