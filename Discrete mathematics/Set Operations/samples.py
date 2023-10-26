import sympy as sp
from sympy.polys.specialpolys import random_poly

class sample():

    def __init__(self):
        self.fx = None
        self.gx = None
        self.x = sp.Symbol("x")

    def randomFunction(self, variable, degree, min, max):
        x = sp.Symbol(variable)
        self.fx = random_poly(x, degree, min, max, polys=False)
        self.gx = random_poly(x, degree, min, max, polys=False)

        return self.fx, self.gx



