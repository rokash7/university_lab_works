# Rokas Petrauskas
# eiles numeris 10

# 10. patikrinti ar duotas tekstas yra tobuloji pangrama
# 10. Racionalus_skaičius su specialiuoju metodu __add__(a, b).

# to generate: gcc -shared -o perfect_pangram_module.pyd perfect_pangram_module.c -I C:\ProgramData\Anaconda3\include -L C:\ProgramData\Anaconda3\libs -lpython39

import sys
import os
import perfect_pangram_module
import rational

text = "Abcd efghijklm nop.qrstuvwxzy"
error = perfect_pangram_module.is_perfect_pangram(text) 

if error is not None:
    print("Error:", str(error))
else:
    print("Is it a perfect pangram? Yes")


rat1 = rational.newrat(5, 3)
rat2 = rational.newrat(4, 9)
resultRat = rational.__add__(rat1, rat2)
rational.showrat(resultRat)


