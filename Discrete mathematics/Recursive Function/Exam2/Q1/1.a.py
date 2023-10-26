def rec(s):
    if s == 1:
        return 10
    else:
        return rec(s - 1) + 10

print(rec(2))