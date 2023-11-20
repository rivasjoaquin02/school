package priority_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ej7 {
    public static void main(String[] args) {
        DnaSequence s0 = new DnaSequence("ADDA", 0);
        DnaSequence s1 = new DnaSequence("DA", 2);
        DnaSequence s2 = new DnaSequence("DAAD", 10);
        DnaSequence s3 = new DnaSequence("DAADAA", 5);
        DnaSequence s4 = new DnaSequence("AD", 0);

        List<DnaSequence> dnaSequenceList = new ArrayList<>(List.of(s0, s1, s2, s3, s4));
        DnaLaboratory lab = new DnaLaboratory(dnaSequenceList);

        lab.analyzeDnaSequences();
    }
}

class DnaSequence implements Comparable<DnaSequence> {
    protected String sequence;
    protected int timesAnalysed;

    public DnaSequence(String sequence, int timesAnalysed) {
        this.sequence = sequence;
        this.timesAnalysed = timesAnalysed;
    }

    @Override
    public int compareTo(DnaSequence dnaSequence) {
        int sequenceLength1 = this.sequence.length();
        int sequenceLength2 = dnaSequence.sequence.length();

        return sequenceLength1 != sequenceLength2
                ? sequenceLength2 - sequenceLength1
                : this.timesAnalysed - dnaSequence.timesAnalysed;
    }
}

class DnaLaboratory {
    protected List<DnaSequence> dnaSequenceList;

    public DnaLaboratory(List<DnaSequence> dnaSequenceList) {
        this.dnaSequenceList = dnaSequenceList;
    }

    public boolean analyze(DnaSequence sequence) {
        if (sequence.timesAnalysed < 10) {
            sequence.timesAnalysed++;
            return true;
        }
        return false;
    }

    public void analyzeDnaSequences() {
        PriorityQueue<DnaSequence> dnaSequencesWithPriority = new PriorityQueue<>(dnaSequenceList);

        while (!dnaSequencesWithPriority.isEmpty()) {
            DnaSequence dnaSequence = dnaSequencesWithPriority.poll();
            if (analyze(dnaSequence))
                dnaSequencesWithPriority.add(dnaSequence);
        }
    }
}
