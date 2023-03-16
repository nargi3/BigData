import java.util.Objects;

class Number {
    private int numerator;
    private int denominator;

    public Number(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return numerator == number.numerator && denominator == number.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}

class SimpleFraction extends Number {
    public SimpleFraction(int numerator, int denominator) {
        super(numerator, denominator);
    }

    public void display() {
        System.out.println("Fraction: " + this.getNumerator() + "/" + this.getDenominator());
    }

    public SimpleFraction addition(SimpleFraction fraction) {
        int numerator = this.getNumerator() * fraction.getDenominator() + fraction.getNumerator() * this.getDenominator();
        int denominator = this.getDenominator() * fraction.getDenominator();
        return new SimpleFraction(numerator, denominator);
    }

    public SimpleFraction subtraction(SimpleFraction fraction) {
        int numerator = this.getNumerator() * fraction.getDenominator() - fraction.getNumerator() * this.getDenominator();
        int denominator = this.getDenominator() * fraction.getDenominator();
        return new SimpleFraction(numerator, denominator);
    }

    public SimpleFraction multiplication(SimpleFraction fraction) {
        int numerator = this.getNumerator() * fraction.getNumerator();
        int denominator = this.getDenominator() * fraction.getDenominator();
        return new SimpleFraction(numerator, denominator);
    }

    public SimpleFraction division(SimpleFraction fraction) {
        int numerator = this.getNumerator() * fraction.getDenominator();
        int denominator = this.getDenominator() * fraction.getNumerator();
        return new SimpleFraction(numerator, denominator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SimpleFraction that = (SimpleFraction) o;
        return this.getNumerator() == that.getNumerator() && this.getDenominator() == that.getDenominator();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        SimpleFraction fraction1 = new SimpleFraction(2, 3);
        SimpleFraction fraction2 = new SimpleFraction(3, 4);

        System.out.println("Fraction 1: " + fraction1.getNumerator() + "/" + fraction1.getDenominator());
        System.out.println("Fraction 2: " + fraction2.getNumerator() + "/" + fraction2.getDenominator());

        SimpleFraction resultAdd = fraction1.addition(fraction2);
        System.out.println("Add: " + resultAdd.getNumerator() + "/" + resultAdd.getDenominator());
        SimpleFraction resultSub = fraction1.subtraction(fraction2);
        System.out.println("Sub: " + resultSub.getNumerator() + "/" + resultSub.getDenominator());
        SimpleFraction resultMul = fraction1.multiplication(fraction2);
        System.out.println("Multip: " + resultMul.getNumerator() + "/" + resultMul.getDenominator());
        SimpleFraction resultDiv = fraction1.division(fraction2);
        System.out.println("Div: " + resultDiv.getNumerator() + "/" + resultDiv.getDenominator());


        System.out.println("Equals: " + resultAdd.equals(resultSub));
        System.out.println("HashCode: " + resultAdd.hashCode());
        System.out.println("ToString: " + resultAdd.toString());
    }
}