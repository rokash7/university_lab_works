# Sukurkite masyvą dydžio 8 x 8, kur 1 ir 0 išdėlioti šachmatine tvarka

import numpy as np

matrix = np.zeros((8,8), dtype=int)

matrix[::2, ::2] = 1
matrix[1::2, 1::2] = 1

print(matrix)