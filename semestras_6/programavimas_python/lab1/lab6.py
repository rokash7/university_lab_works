# Sukurkite masyvą dydžio n×n , kurio (i,j)-oji pozicija lygi i+j.

import numpy as np

n = int(input("enter the matrix size: "))

def sum_ij(i, j):
    return i + j

matrix = np.fromfunction(sum_ij, (n, n), dtype=int)

print(matrix)