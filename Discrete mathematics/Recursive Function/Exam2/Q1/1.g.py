def rec(t):
    if t == 1:
        return 1
    elif t == 2:
        return 2
    elif t == 3:
        return 3
    else:
        return rec(t - 1) + 2 * rec(t - 2) + 3 * rec(t - 3)

print(rec(5))
