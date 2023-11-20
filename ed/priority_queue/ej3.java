package priority_queue;

import java.util.List;
import java.util.PriorityQueue;

class Attack {
    protected int damage;
    protected int consume;
    protected int priority;

    public Attack(int damage, int consume, int priority) {
        this.damage = damage;
        this.consume = consume;
        this.priority = priority;
    }
}

class Pokymon implements Comparable<Pokymon> {
    protected String name;
    protected int fisic;
    protected int special;
    protected int speed;
    List<Attack> posiblesAttacks;
    Attack choosedAttack;

    public Pokymon(String name, int fisic, int special, int speed, List<Attack> posiblesAttacks, Attack choosedAttack) {
        this.name = name;
        this.fisic = fisic;
        this.special = special;
        this.speed = speed;
        this.posiblesAttacks = posiblesAttacks;
        this.choosedAttack = choosedAttack;
    }

    @Override public int compareTo(Pokymon pokymon) {
        return this.choosedAttack.priority == pokymon.choosedAttack.priority
                ? pokymon.speed - this.speed
                : pokymon.choosedAttack.priority - this.choosedAttack.priority;
    }
}

class Combat {
    List<Pokymon> pokymonList;

    public Combat(List<Pokymon> pokymonList) {
        this.pokymonList = pokymonList;
    }

//    public Pokymon firstToAttack(List<Attack> attackList) {
//        PriorityQueue<Pokymon> pokymonWithPriority = new PriorityQueue<>(pokymonList);
//
//        return
//    }
}

public class ej3 {
    public static void main(String[] args) {

    }
}
