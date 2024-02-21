#  Sugeneruokite masyvą iš 1000 atsitiktinių skaičių, pasiskirsčiusių pagal normalųjį dėsnį su duotais vidurkiu V ir dispersija D. Nupieškite jų histogramą.

import numpy as np
import matplotlib.pyplot as plt

# Parametrai
V = int(input("iveskite vidurkio reiksme: "))  # bandom 500         Vidurkis
D = int(input("iveskite dispersijos reiksme: "))  #Dispersija

# generuojam skaicius
random_numbers = np.random.normal(V, np.sqrt(D), 1000)

# piesiam histograma
plt.hist(random_numbers, bins=30, edgecolor='black')
plt.xlabel('Skaičiai')
plt.ylabel('Dažnis')
plt.title('Histograma')
plt.show()
