# Sukonstruokite pasikartojantį masyvą pagal duotą N.
# Duotas masyvas [1, 2, 3, 4] ir N = 3
# Rezultatas [1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4]
# Masyvas gali būti bet kokio dydžio ir atsitiktinai sugeneruojamas.

given_list = [1, 2, 3, 4]
n = 4
new_list = []

for _ in range(n):
    new_list.extend(given_list)
    # new_list += given_list

print(new_list)