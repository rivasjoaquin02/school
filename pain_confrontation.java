import java.util.List;
import java.util.PriorityQueue;

class Soldier implements Comparable<Soldier> {
    protected int strength;
    protected String name;

    Soldier(String name, int strength) {
        this.strength = strength;
        this.name = name;
    }

    @Override
    public int compareTo(Soldier o) {
        return o.strength - this.strength;
    }
}

class Konoha {
    protected List<Soldier> soldierList;

    public Konoha(List<Soldier> soldiers) {
        this.soldierList = soldiers;
    }

    //    O(nlog(m))
    public int defeatPain(int painLife) {
        PriorityQueue<Soldier> pq = new PriorityQueue<>(soldierList);

        int amountAttacks = 0;
        while (painLife >= 0 && !pq.isEmpty()) {
            Soldier soldier = pq.poll();

            while (soldier.strength > 0) {
                amountAttacks++;

                if (painLife - soldier.strength <= 0) {
                    System.out.println("Victory");
                    return amountAttacks;
                }

                painLife -= soldier.strength;
                soldier.strength /= 2;
            }
        }
        System.out.println("Evacuee");
        return -1;
    }

}


public class pain_confrontation {
    public static void main(String[] args) {
        Konoha konoha = new Konoha(
                List.of(
                        new Soldier("naruto", 150),
                        new Soldier("Shikamaru", 200),
                        new Soldier("kakashi", 120)
//                        new Soldado("pakun", 170)
                )
        );

        System.out.println(konoha.defeatPain(1000));
    }
}
