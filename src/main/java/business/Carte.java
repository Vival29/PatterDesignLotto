package business;

import java.util.ArrayList;

public class Carte {
    private ArrayList<Integer> range1;
    private ArrayList<Integer> range2;
    private ArrayList<Integer> range3;

    public Carte(){}

    public ArrayList<Integer> getRange1() {
        return range1;
    }

    public void setRange1(ArrayList<Integer> range1) {
        this.range1 = range1;
    }

    public ArrayList<Integer> getRange2() {
        return range2;
    }

    public void setRange2(ArrayList<Integer> range2) {
        this.range2 = range2;
    }

    public ArrayList<Integer> getRange3() {
        return range3;
    }

    public void setRange3(ArrayList<Integer> range3) {
        this.range3 = range3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("carte");
        sb.append("\n");
        for (Integer n: getRange1()
             ) {
            sb.append(n.toString());
            sb.append(" - ");
        }
        sb.append("\n");
        for (Integer n: getRange2()
        ) {
            sb.append(n.toString());
            sb.append(" - ");
        }
        sb.append("\n");
        for (Integer n: getRange3()
        ) {
            sb.append(n.toString());
            sb.append(" - ");
        }

        return sb.toString();
    }

}
