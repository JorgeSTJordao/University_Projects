def rec(A):
    if A == 1:
        return 2
    else:
        return rec(A-1)**(-1)

print(rec(4))