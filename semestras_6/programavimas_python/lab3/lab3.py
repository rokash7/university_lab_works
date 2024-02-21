# Rokas Petrauskas eil nr. 10
from doctest import testmod

def is_perfect_pangram(text):
    """
    Patikrina, ar duotas tekstas yra tobuloji pangrama.

    Args:
        text (str): Tekstas, kurį reikia patikrinti.

    Returns:
        bool: True, jei tekstas yra tobuloji pangrama, False - kitu atveju.

    >>> is_perfect_pangram("abcdefghijklmnopqrstuvwxyz")
    True
    >>> is_perfect_pangram("abcde")
    False
    """    

    # apsirasom naudojama abecele
    alphabet = "abcdefghijklmnopqrstuvwxyz"

    # einam pro kiekveina elementa, keiciam i mazaja raide, jei tai tarpelis, ji pradanginam ir patikrinam ar elementas jau buvo pasitaikes
    # jei visos salygos tenkinamos, grazinam true
    for char in alphabet:
        if text.lower().replace(" ", "").count(char) != 1:
            return False

    return True

# Dokumentaciniai testai
print(is_perfect_pangram("abcdefghijklmnopqrstuvwxyz"))  # True (cia naudojama aprasyta alphabet)
print(is_perfect_pangram("abcdefghijklmnopqrstuvwxyz".upper()))  # True (cia naudojama aprasyta alphabet tikrinama su didziosiomis raidemis)
print(is_perfect_pangram("abcdefghijklmnopqrstuvwzyx"))  # True (cia naudojama aprasyta alphabet, taciau sukeistos paskutines 3 raides)
print(is_perfect_pangram("abcdefg hijklmno pqrstu vwxy      z"))  # True (cia naudojama aprasyta alphabet, sukeistos 3 paskutines raides, prideta tarpeliu)
print(is_perfect_pangram("The quick brown fox jumps over the lazy dog"))  # False (t repeats)
print(is_perfect_pangram("abcdefghijklmnopqrstuvwxy")) # False (truksta z)

if __name__ == '__main__':
    testmod(name ='is_perfect_pangram', verbose = True)

# unit testai
import unittest

class Test_is_perfect_pangram(unittest.TestCase):
    def test_tobuloji_pangrama(self):
        # Tikimasi True, nes visos abeceles raides yra
        self.assertTrue(is_perfect_pangram("abcdefghijklmnopqrstuvwxyz"))

        # Tikimasi True, nes visos abeceles raides yra, nors ir didziosios 
        self.assertTrue(is_perfect_pangram("abcdefghijklmnopqrstuvwxyz".upper()))

        # Tikimasi True, nes visos abeceles raides yra, nors ir paskutines 3 sukeistos vietomis
        self.assertTrue(is_perfect_pangram("abcdefghijklmnopqrstuvwzyx"))

        # Tikimasi True, nes visos abeceles raides yra, nors ir yra tarpeliu
        self.assertTrue(is_perfect_pangram("abcdefg hijklmno pqrstu vwxy      z"))

        # Tikimasi False, nes raide t kartojasi 2 kartus
        self.assertFalse(is_perfect_pangram("The quick brown fox jumps over the lazy dog"))

        # Tikimasi False, nes truksta raides z
        self.assertFalse(is_perfect_pangram("abcdefghijklmnopqrstuvwxy"))


if __name__ == '__main__':
    unittest.main()
