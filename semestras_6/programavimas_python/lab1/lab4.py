# Sukurkite masyvą dydžio 10 x 10 iš nulių "įrėmintų" vienetais.
# Užuomina - pad.

import numpy as np

size = 10

def arrGenerator(size):
    arr1 = []
    arr2 = []

    for _ in range(size):
        arr1.append(0)

    for _ in range(size):
        arr2.append(arr1)

    arr2 = np.pad(arr2, (1,1), 'constant', constant_values=(1,1))
    
    return arr2

print(np.matrix(arrGenerator(size)))