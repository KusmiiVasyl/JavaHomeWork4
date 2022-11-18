package task3;

import java.util.Objects;

public class Fine {
    private String typeOfFine;
    private double sum;

    public Fine(String typeOfFine, double sum) {
        this.typeOfFine = typeOfFine;
        this.sum = sum;
    }

    public String getTypeOfFine() {
        return typeOfFine;
    }

    public double getSum() {
        return sum;
    }

    public void setTypeOfFine(String typeOfFine) {
        this.typeOfFine = typeOfFine;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void showFine() {
        System.out.println("Type of fine: \"" + this.typeOfFine + "\".");
        System.out.println("\tSum of fine = " + this.sum + " грн.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fine fine = (Fine) o;

        if (Double.compare(fine.sum, sum) != 0) return false;
        return Objects.equals(typeOfFine, fine.typeOfFine);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = typeOfFine != null ? typeOfFine.hashCode() : 0;
        temp = Double.doubleToLongBits(sum);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
