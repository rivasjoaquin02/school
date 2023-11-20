from dataclasses import dataclass
import heapq
from queue import PriorityQueue


@dataclass()
class Soldier:
    name: str
    strenght: int

    def __lt__(self, soldier: "Soldier") -> int:
        return soldier.strenght - self.strenght


@dataclass()
class Konoha:
    soldier_list: list[Soldier]

    def derrotarPain(self, pain_life: int) -> int:
        pq = [(-soldier.strenght, soldier) for soldier in self.soldier_list]
        heapq.heapify(pq)

        cant_atacks: int = 0
        while pain_life >= 0 and pq:
            soldier_strenght, soldier = heapq.heappop(pq)

            while soldier_strenght > 0:
                cant_atacks += 1

                if pain_life - soldier_strenght <= 0:
                    print("Victory")
                    return cant_atacks

                pain_life -= soldier_strenght
                soldier_strenght //= 2

        print("Evacue")

        return -1


konoha = Konoha(
    soldier_list=[
        Soldier(name="naruto", strenght=150),
        Soldier(name="shikamaru", strenght=200),
        Soldier(name="kakashi", strenght=120),
        Soldier(name="pakun", strenght=170),
    ]
)

sol = konoha.derrotarPain(1000)
print (sol)