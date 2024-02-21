from distutils.core import setup, Extension
import os

module1 = Extension("perfect_pangram_module", sources=["perfect_pangram_module.c"])
module2 = Extension("rational_module", sources=["rational.c"])

setup(
    name="perfect_pangram_rational",
    version="1.0",
    description="A Python package that provides modules for checking perfect pangrams and performing rational number operations.",
    ext_modules=[
        Extension("perfect_pangram_module", sources=["perfect_pangram_module.c"]),
        Extension("rational_module", sources=["rational.c"], include_dirs=[os.path.abspath(".")])
    ]
)
