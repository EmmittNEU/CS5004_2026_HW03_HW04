package student;

public class PayStub implements IPayStub {
    @Override
    public double getPay() {
        return 0;
    }

    @Override
    public double getTaxesPaid() {
        return 0;
    }

    @Override
    public String toCSV() {
        return "";
    }
}
