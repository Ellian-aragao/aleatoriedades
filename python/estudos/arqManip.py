import re

palavra = 'Python or Cython, maybe Jython'
texto = re.findall('[A-Za-z]y',palavra)
print(texto)