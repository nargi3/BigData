import java.util.Arrays;

class OneDimensionalArray {
    private int[] array;

    public OneDimensionalArray(int[] array) {
        this.array = array;
    }

    public OneDimensionalArray(int length) {
        this.array = new int[length];
    }

    public void fillRandom() {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = (int) (Math.random() * 100);
        }
    }

    public void output() {
        System.out.println(Arrays.toString(this.array));
    }

    public static OneDimensionalArray add(OneDimensionalArray a1, OneDimensionalArray a2) {
        OneDimensionalArray result = new OneDimensionalArray(a1.array.length);
        for (int i = 0; i < a1.array.length; i++) {
            result.array[i] = a1.array[i] + a2.array[i];
        }
        return result;
    }

    public static OneDimensionalArray subtract(OneDimensionalArray a1, OneDimensionalArray a2) {
        OneDimensionalArray result = new OneDimensionalArray(a1.array.length);
        for (int i = 0; i < a1.array.length; i++) {
            result.array[i] = a1.array[i] - a2.array[i];
        }
        return result;
    }

    public OneDimensionalArray multiply(int constant) {
        OneDimensionalArray result = new OneDimensionalArray(this.array.length);
        for (int i = 0; i < this.array.length; i++) {
            result.array[i] = this.array[i] * constant;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OneDimensionalArray that = (OneDimensionalArray) o;
        return Arrays.equals(array, that.array);
    }

    // Override the hashCode() method
    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    // Override the toString() method
    @Override
    public String toString() {
        return "OneDimensionalArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    // Example usage
    public static void main(String[] args) {
        OneDimensionalArray a1 = new OneDimensionalArray(new int[]{1, 2, 3});
        OneDimensionalArray a2 = new OneDimensionalArray(new int[]{4, 5, 6});
        OneDimensionalArray sum = add(a1, a2);
        OneDimensionalArray difference = subtract(a1, a2);
        OneDimensionalArray product = a1.multiply(2);
        System.out.println(sum); // Output: OneDimensionalArray{array=[5, 7, 9]}
        System.out.println(difference); // Output: OneDimensionalArray{array=[-3, -3, -3]}
        System.out.println(product); // Output: OneDimensionalArray{array=[2, 4, 6]}
    }
}