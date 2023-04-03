
class Vector {
    private double[] elements;

    public Vector(double[] elements) {
        this.elements = elements;
    }

    public Vector(int dimension) {
        elements = new double[dimension];
    }

    public double modulus() {
        double sumOfSquares = 0.0;
        for (double element : elements) {
            sumOfSquares += element * element;
        }
        return Math.sqrt(sumOfSquares);
    }

    public double scalarProduct(Vector other) {
        double result = 0.0;
        for (int i = 0; i < elements.length; i++) {
            result += elements[i] * other.elements[i];
        }
        return result;
    }

    public Vector add(Vector other) {
        if (elements.length != other.elements.length) {
            throw new IllegalArgumentException("Vectors must have the same dimension");
        }
        double[] result = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            result[i] = elements[i] + other.elements[i];
        }
        return new Vector(result);
    }

    public Vector subtract(Vector other) {
        if (elements.length != other.elements.length) {
            throw new IllegalArgumentException("Vectors must have the same dimension");
        }
        double[] result = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            result[i] = elements[i] - other.elements[i];
        }
        return new Vector(result);
    }

    // Method for multiplying a vector by a constant
    public Vector multiply(double constant) {
        double[] result = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            result[i] = elements[i] * constant;
        }
        return new Vector(result);
    }

    // Method for determining whether two vectors are collinear or orthogonal
    public String determineRelationship(Vector other) {
        if (elements.length != other.elements.length) {
            throw new IllegalArgumentException("Vectors must have the same dimension");
        }
        double scalarProduct = scalarProduct(other);
        if (scalarProduct == 0) {
            return "The vectors are orthogonal";
        } else if (scalarProduct == modulus() * other.modulus()) {
            return "The vectors are collinear";
        } else {
            return "The vectors are neither collinear nor orthogonal";
        }
    }
    public static void main(String[] args) {
        Vector[] vectors = new Vector[4];
        vectors[0] = new Vector(new double[] {-2.0, -2.0, 3.0});
        vectors[1] = new Vector(new double[] {4.0, 5.0, 6.0});
        vectors[2] = new Vector(new double[] {8.0, 8.0, 12.0});
        vectors[3] = new Vector(new double[] {4.0, 4.0, 6.0});

        Vector sum = vectors[0].add(vectors[1]);
        System.out.println("The sum of vectors[0] and vectors[1] is " + sum);

        Vector difference = vectors[1].subtract(vectors[2]);
        System.out.println("The difference of vectors[1] and vectors[2] is " + difference);

        Vector product = vectors[2].multiply(2.0);
        System.out.println("The product of vectors[2] and 2.0 is " + product);

        System.out.println("The modulus of vectors[0] is " + vectors[0].modulus());
        System.out.println("The scalar product of vectors[0] and vectors[1] is " + vectors[0].scalarProduct(vectors[1]));

        System.out.println("The relationship between vectors[0] and vectors[1] is " + vectors[0].determineRelationship(vectors[1]));
        System.out.println("The relationship between vectors[1] and vectors[2] is " + vectors[1].determineRelationship(vectors[2]));
        System.out.println("The relationship between vectors[0] and vectors[2] is " + vectors[0].determineRelationship(vectors[2]));
        System.out.println("The relationship between vectors[0] and vectors[2] is " + vectors[2].determineRelationship(vectors[3]));
    }

    // toString method for printing
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("(");
        for (int i = 0; i < elements.length; i++) {
            stringBuilder.append(elements[i]);
            if (i != elements.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
