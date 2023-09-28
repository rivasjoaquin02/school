import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Assassin implements Comparable<Assassin> {
    protected String name;
    protected int strength;
    protected int skill;

    public Assassin(String name, int strength, int skill) {
        this.name = name;
        this.strength = strength;
        this.skill = skill;
    }

    @Override public int compareTo(Assassin assassin) {
        return (assassin.strength + assassin.skill) - (this.strength + this.skill);
    }
}

class Simulation {
    protected List<Assassin> assassinList;
    protected int totalStrengthTemplar;

    public Simulation(List<Assassin> assassinList, int totalStrengthTemplar) {
        this.assassinList = assassinList;
        this.totalStrengthTemplar = totalStrengthTemplar;
    }

    public int defeatTemplar() {
        Queue<Assassin> assassins = new PriorityQueue<>(assassinList);

        int amountAttacks = 0;
        while (totalStrengthTemplar > 0 && !assassins.isEmpty()) {
            Assassin assassin = assassins.poll();
            while (assassin.strength > 0 && assassin.skill >= 5) {
                amountAttacks++;

                this.totalStrengthTemplar -= (assassin.strength + assassin.skill);
                if (this.totalStrengthTemplar <= 0) return amountAttacks;

                assassin.strength /= 2;
                assassin.skill -= 10;
            }
        }

        if (this.totalStrengthTemplar < 0) return amountAttacks;
        return -1;
    }
}

public class assassins_creed {
    public static void main(String[] args) {
        Simulation s0 = new Simulation(
                List.of(
                        new Assassin("Ezio", 150, 100),
                        new Assassin("Altair", 100, 200),
                        new Assassin("Desmond", 60, 350),
                        new Assassin("Rebecca", 100, 120),
                        new Assassin("Daniel ", 210, 210)
                ),
                10050
        );

        System.out.println(s0.defeatTemplar());
    }
}
