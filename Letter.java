/**
 * Клас, що представляє одну літеру (символ).
 *
 * @author Student
 * @version 1.0
 */
public class Letter {

    /** Символ, що зберігається у цій літері */
    private final char value;

    /**
     * Конструктор для створення літери.
     *
     * @param value символ літери
     */
    public Letter(char value) {
        this.value = value;
    }

    /**
     * Повертає символ літери.
     *
     * @return символ літери
     */
    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Letter other = (Letter) obj;
        return value == other.value;
    }

    @Override
    public int hashCode() {
        return Character.hashCode(value);
    }
}
