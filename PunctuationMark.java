/**
 * Клас, що представляє розділовий знак.
 *
 * @author Student
 * @version 1.0
 */
public class PunctuationMark {

    /** Символ розділового знака */
    private final char symbol;

    /**
     * Конструктор для створення розділового знака.
     *
     * @param symbol символ розділового знака
     */
    public PunctuationMark(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Повертає символ розділового знака.
     *
     * @return символ розділового знака
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Перевіряє, чи є переданий символ розділовим знаком.
     *
     * @param c символ для перевірки
     * @return true, якщо символ є розділовим знаком
     */
    public static boolean isPunctuation(char c) {
        return ".,!?;:-–—()[]{}\"'".indexOf(c) >= 0;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PunctuationMark other = (PunctuationMark) obj;
        return symbol == other.symbol;
    }

    @Override
    public int hashCode() {
        return Character.hashCode(symbol);
    }
}
