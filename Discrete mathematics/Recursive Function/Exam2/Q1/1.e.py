def rec(D):
    if D == 1:
        return 3
    elif D == 2:
        return 5
    else:
        return (D - 1) * rec(D - 1) + (D - 2) * rec(D - 2)

print(rec(3))