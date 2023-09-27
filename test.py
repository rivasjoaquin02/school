from dataclasses import dataclass
from typing import Generic, TypeVar

T = TypeVar("T", 'Persona', 'Animal')

@dataclass
class Persona:
    nombre: str
    edad: int

    def compareTo(self, b: 'Persona') -> int:
        return self.edad - b.edad


@dataclass
class Animal: 
    nombre: str
    edad: int
    cant_gente_mordida: int

    def compareTo(self, b: 'Animal') -> int:
        return self.cant_gente_mordida - b.cant_gente_mordida


def compare(a: T, b: T) -> int:
    return a.compareTo(b)


lin = Persona("Lin", 19)
str = Persona("Strange", 20)

# print (compare(lin, str))


class Papa:
    def __init__(self, num):
        self.num = num

    def __lt__(self, otra_papa: 'Papa') -> int:
        return self.num - otra_papa.num
    

a = Papa(2)
b = Papa(5)
c = Papa(2)

print (a < b)
print (a > b)
print (a <  c)