package UsefulClasses;

// Vector Lab

import java.util.Random;
import java.util.StringJoiner;

/**
 * A class representing a mathematical vector.
 */
public class MathVector {
    private final int[] array;

    /**
     * Private constructor. {@code array} is set to an empty array of the given size.
     *
     * @param size the size of the array
     */
    private MathVector(int size) {
        this.array = new int[size];
    }

    /**
     * Creates a MathVector instance backed by the given array.
     *
     * @param source the array to use
     */
    public MathVector(int[] source) {
        this.array = source;
    }

    /**
     * Static method to create a new MathVector instance with the specified {@code size}, with each element set to the specified {@code value}.
     *
     * @param size  the number of elements in the new vector
     * @param value the value to set each element to
     * @return a new MathVector instance
     */
    public static MathVector filled(int size, int value) {
        var result = new MathVector(size);
        for (int i = 0; i < size; i++) {
            result.array[i] = value;
        }
        return result;
    }

    /**
     * Static method to create a new MathVector instance with the specified {@code size}, with each element set to a random value in the range [min, max).
     *
     * @param size the number of elements in the new vector
     * @return a new MathVector instance
     */
    public static MathVector random(int size, int min, int max) {
        var result = new MathVector(size);
        var rng = new Random();

        for (int i = 0; i < size; i++) {
            result.array[i] = rng.nextInt(max - min + 1) + min;
        }
        return result;
    }

    /**
     * Static method to create a new MathVector instance from the String {@code s}, whose format should be "x1,x2,x3,...", where xi is the ith element.
     *
     * @param s the string to parse
     * @return a new MathVector instance
     */
    public static MathVector parse(String s) {
        var split = s.split(",");

        var result = new MathVector(split.length);

        for (int i = 0; i < split.length; i++) {
            result.array[i] = Integer.parseInt(split[i]);
        }

        return result;
    }

    /**
     * Returns the element at the specified index.
     *
     * @param index the index of the element to return
     * @return the element at the specified index
     */
    public int at(int index) {
        return array[index];
    }

    /**
     * Returns the euclidean distance of this vector.
     *
     * @return the euclidean distance of this vector
     */
    public double magnitude() {
        double sum = 0;
        for (var e : array) {
            sum += Math.pow(e, 2);
        }
        return Math.sqrt(sum);
    }

    /**
     * Returns a new MathVector instance that is the sum of this vector and the specified vector. (ie, each element is added together)
     *
     * @param other the other vector
     * @return a new MathVector instance that is the sum of this vector and the specified vector
     */
    public MathVector add(MathVector other) {
        var result = new MathVector(array.length);
        for (int i = 0; i < array.length; i++) {
            result.array[i] = array[i] + other.array[i];
        }
        return result;
    }

    /**
     * Returns a String representation of this vector. The String should be in the format "[1, 2, 3]"
     *
     * @return a String representation of this vector
     * @apiNote **DO NOT** use the built-in {@code Arrays.toString()} method.
     */
    @Override
    public String toString() {
        var sj = new StringJoiner(", ", "[", "]");
        for (var e : array) {
            sj.add(String.valueOf(e));
        }

        return sj.toString();
    }
}
