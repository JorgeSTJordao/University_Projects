def rec(w):
    if w == 1:
        return 2
    elif w == 2:
        return 5
    else:
        return rec(w - 1) * rec(w - 2)

print(rec(4))