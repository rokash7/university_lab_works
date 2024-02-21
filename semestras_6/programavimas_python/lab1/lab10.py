# Apskaičiuokite funkcijos e-x apibrėžtinį, intervale [0,1], ir neapibrėžtinį integralus.

import sympy as smp

x = smp.symbols('x')
# f = smp.E**(-x)
f = smp.exp(-x)

neap_integralas_f = smp.integrate(f, x).simplify()

ap_integralas_f = smp.integrate(f, (x, 0, 1))

print("duota funkcija f: \n", f)
print("\nfunkcijos f neapibreztinis integralas:\n", neap_integralas_f)
print("\nfunkcijos f integralas intervale [0, 1]:\n", ap_integralas_f)


