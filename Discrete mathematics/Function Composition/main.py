# Author: Jorge Samuel Teixeira Jordão
# Date: 21/09/2023
# Country: Brazil
# Purpose: this is a code capable of create composite functions e find their solutions

from samples import sample
import sympy as sp

def call():

    decision = input("Would you like to create your own functions? Y/N: ")

    if decision.upper() == "Y":
        x = sp.Symbol('x')
        fx = input("Type the function f(x): ")
        gx = input("Type the function g(x): ")
        function(fx, gx, x)
    else:
        functionCreater = sample()
        # Parameters: variable, polynomial degree, min_values of coefficients, max_values of coefficients
        # Here can change the numbers
        fx, gx = functionCreater.randomFunction("x", 2, 1, 3)
        function(fx, gx, functionCreater.x)


def function(fx, gx, x):
    print(f"f(x) = {fx}", f"g(x) = {gx}", sep="\n")

    if str(fx).isnumeric() or str(gx).isnumeric():
        print("Some of the functions is just a constant value")
        print(f"f(x)= {fx}")
        print(f"g(x)= {gx}")
    else:
        compose_fg = sp.compose(fx, gx)
        compose_ff = sp.compose(fx, fx)
        compose_gf = sp.compose(gx, fx)
        compose_gg = sp.compose(gx, gx)

        print("All possible combinations")
        print(f"f(x) o g(x): {compose_fg}", f"f(x) o f(x): {compose_ff}", f"g(x) o f(x): {compose_gf}",
              f"g(x) o g(x): {compose_gg}", sep="\n")

        xf = int(input("Type the x value: "))

        print(25 * "-")
        print(f"The user chose {xf} as value of x")

        order = [compose_fg.subs(x, xf), compose_ff.subs(x, xf), compose_gf.subs(x, xf), compose_gg.subs(x, xf)]
        print(f"f(x) o g(x): {order[0]}", f"f(x) o f(x): {order[1]}", f"g(x) o f(x): {order[2]}",
              f"g(x) o g(x): {order[3]}", sep="\n")

# -----------------------------------------------------------------------------
# START
calls = int(input("How many times would u like to call the functions: "))

if calls > 1:
    for i in range(calls):
        print(f"\n Programa {i + 1}")
        print(25 * "-")
        call()
else:
    call()

#---------------------------------------------------------------
# END