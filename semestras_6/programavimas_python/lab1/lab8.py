# 	Apskaičiuokite matricos tikrines reikšmes ir tikrinį vektorių

import numpy as np

matrixA = np.random.random_integers(low=1, high=8, size=(2,2))
# matrixA = np.array([[1,2], [3,4]])

eigenvalue_of_matrixA, eigenvector_of_matrixA = np.linalg.eig(matrixA)


print("pradine matrica: \n", matrixA)
print("matricos tikrines reiksmes \n", eigenvalue_of_matrixA)
print("matricos tikrinis vektorius: \n", eigenvector_of_matrixA)

