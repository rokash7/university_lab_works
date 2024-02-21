# Apskaičiuokite funkcijos 0.5*x**2 + 5 * x + 4 išvestines su numpy ir sympy paketais.
# Užuominos - poly1d, deriv, diff

from sympy import *

x = symbols ('x')

f = 0.5*x**2 + 5 *x + 4

df = diff(f, x)

print("duta funkcija f(x): \n", f)
print("\nfunckijos f(x) isvestine: \n", df)