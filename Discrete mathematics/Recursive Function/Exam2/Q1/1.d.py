def rec(P):
    if P == 1:
        return 1
    else:
        return (P**2 * rec(P-1) + P - 1)

print(rec(4))