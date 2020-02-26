import re

palavra = 'Python, Cython or Jython'
texto = re.findall('[A-Za-z]y[A-Za-z]+',palavra)
print(texto)