def rec(B):
    if B == 1:
        return 1

    else:
        return rec(B - 1) + B**2

print(rec(3))
