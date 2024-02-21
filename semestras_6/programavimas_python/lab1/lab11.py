# Pasinaudodami polinėmis koordinatėmis nupieškite kardioidę.

import matplotlib.pyplot as plt
import numpy as np

t = np.linspace(0, 2*np.pi, 200) # Nustatome laiko parametrą t nuo 0 iki 2pi.
r = 1 + np.cos(t)               # Apskaičiuojame r koordinatę.

x = r * np.cos(t)               # Apskaičiuojame x ir y koordinates naudodami polines koordinates.
y = r * np.sin(t)

fig, ax = plt.subplots()        # Sukuriame naują figūrą ir ašį.
ax.plot(x, y, color='black')     # Piešiame kardioidę.
ax.set_aspect(1)                # Nustatome x ir y skalę vienodai.
ax.set_title('Kardioide')       # Pridedame pavadinimą.
plt.show()                      # Rodome grafiką.