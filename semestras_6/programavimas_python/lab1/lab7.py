# Sukurkite atsitiktinį masyvą dydžio 5×5 naudodami np.random.rand(5, 5). Surūšiuokite eilutes pagal antrąjį stulpelį. 
# Užuominos - slicing, argsort, indexing.

import numpy as np

matrix = np.random.rand(5, 5)

sorted_matrix = matrix[matrix[:,1].argsort()]

print(matrix)
print(sorted_matrix)