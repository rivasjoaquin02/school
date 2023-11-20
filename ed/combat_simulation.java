import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Monster implements Comparable<Monster> {
    protected String name;
    protected int life;

    public Monster(String name, int life) {
        this.name = name;
        this.life = life;
    }

    public String toString(){
        return name;
    }

    @Override
    public int compareTo(Monster monster) {
        return monster.life - this.life;
    }
}

class Spell implements Comparable<Spell> {
    protected int damage;
    protected int mana;

    public Spell(int damage, int mana) {
        this.damage = damage;
        this.mana = mana;
    }

    public void castSpell() {
        this.mana += 10;
    }

    @Override
    public int compareTo(Spell spell) {
        return (spell.damage / spell.mana) - (this.damage / this.mana);
    }
}

class CombatSimulation {
    protected List<Spell> spells;
    protected List<Monster> monsters;
    protected int availableMana;
    private final int initialMana;

    public CombatSimulation(List<Spell> spells, List<Monster> monsters, int initialMana) {
        this.spells = spells;
        this.monsters = monsters;
        this.availableMana = this.initialMana = initialMana;
    }

    private void restoreMana() {
        this.availableMana = this.initialMana;
    }

    public List<Monster> rotation() {
        PriorityQueue<Spell> spellPriorityQueue = new PriorityQueue<>(this.spells);
        PriorityQueue<Monster> monsterPriorityQueue = new PriorityQueue<>(this.monsters);
        List<Monster> noDefeatedMonsters = new ArrayList<>();

        while (!spellPriorityQueue.isEmpty() && !monsterPriorityQueue.isEmpty()) {
            Spell spell = spellPriorityQueue.poll();
            Monster monster = monsterPriorityQueue.poll();

            restoreMana();

            while (monster.life > 0 && this.availableMana > 0) {
                spell.castSpell();
                monster.life -= spell.damage;
                this.availableMana -= spell.mana;
            }

            //        se acabo el mana y el monstruo vive
            if (this.availableMana <= 0 && monster.life > 0) {
                noDefeatedMonsters.add(monster);
            }
        }
        return noDefeatedMonsters;
    }
}

public class combat_simulation {
    public static void main(String[] args) {
        CombatSimulation s0 = new CombatSimulation(
                List.of(
                        new Spell(100, 100),
                        new Spell(200, 200),
                        new Spell(90, 100)
                ),
                List.of(
                        new Monster("a", 100),
                        new Monster("b", 200),
                        new Monster("c", 1000)
                ),
                500
        );

        List <Monster> ans = s0.rotation();
        for (Monster monster : ans)
            System.out.println(monster);
    }
}
