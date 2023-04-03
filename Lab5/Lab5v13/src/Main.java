import java.util.Arrays;
class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector() {
        this(0, 0, 0);
    }

    public double modulus() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double scalarProduct(Vector v) {
        return x * v.x + y * v.y + z * v.z;
    }

    public Vector add(Vector v) {
        return new Vector(x + v.x, y + v.y, z + v.z);
    }

    public Vector subtract(Vector v) {
        return new Vector(x - v.x, y - v.y, z - v.z);
    }

    public Vector multiply(double k) {
        return new Vector(k * x, k * y, k * z);
    }

    public boolean isCollinear(Vector v) {
        return x / v.x == y / v.y && y / v.y == z / v.z;
    }

    public boolean isOrthogonal(Vector v) {
        return scalarProduct(v) == 0;
    }


    public boolean intersects(Vector v) {
        return !isOrthogonal(v);
    }

    public boolean equals(Vector v) {
        return x == v.x && y == v.y && z == v.z;
    }

    public int compareTo(Vector v) {
        double modulus1 = modulus();
        double modulus2 = v.modulus();
        if (modulus1 == 0) {
            throw new IllegalArgumentException("Vector1 has 0 module");
        }
        if (modulus2 == 0) {
            throw new IllegalArgumentException("Vector2 has 0 module");
        }
        if (modulus1 < modulus2) {
            return -1;
        } else if (modulus1 > modulus2) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public static void main(String[] args) {
        int m = 3;
        Vector[] vectors = new Vector[m];
        for (int i = 0; i < m; i++) {
            vectors[i] = new Vector();
        }
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(2, 4, 6);
        Vector v3 = new Vector(2, -1, 0);
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    if (isCoplanar(vectors[i], vectors[j], vectors[k])) {
                        System.out.println("Vectors are coplanar.");
                    }
                }
            }
        }

        // Example usage of methods


        // Check orthogonality
        System.out.println("v1 and v2 are orthogonal: " + v1.isOrthogonal(v2));
        System.out.println("v1 and v3 are orthogonal: " + v1.isOrthogonal(v3));

        System.out.println("v1 and v3 are collinear: " + v1.isCollinear(v2));

        // Check intersection
        System.out.println("v1 and v2 intersect: " + v1.intersects(v2));
        System.out.println("v1 and v3 intersect: " + v1.intersects(v3));

        // Compare vectors
        System.out.println("v1 compared to v2: " + v1.compareTo(v2));
        System.out.println("v2 compared to v1: " + v2.compareTo(v1));
        System.out.println("v1 compared to v3: " + v1.compareTo(v3));

    }

    public static boolean isCoplanar(Vector v1, Vector v2, Vector v3) {
        return v1.scalarProduct(v2.crossProduct(v3)) == 0;
    }

    public Vector crossProduct(Vector v) {
        return new Vector(y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y * v.x);
    }

}