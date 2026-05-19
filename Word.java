import java.util.Arrays;

/**
 * Клас, що представляє слово як масив літер.
 *
 * @author Student
 * @version 1.0
 */
public class Word {

    /** Масив літер, що утворюють слово */
    private final Letter[] letters;

    /**
     * Конструктор для створення слова з рядка.
     *
     * @param word рядок, що містить слово
     */
    public Word(String word) {
        this.letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            this.letters[i] = new Letter(word.charAt(i));
        }
    }

    /**
     * Повертає кількість літер у слові.
     *
     * @return довжина слова
     */
    public int length() {
        return letters.length;
    }

    /**
     * Повертає літеру за індексом.
     *
     * @param index індекс літери
     * @return об'єкт Letter
     */
    public Letter getLetter(int index) {
        return letters[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(letters.length);
        for (Letter letter : letters) {
            sb.append(letter.getValue());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Word other = (Word) obj;
        return Arrays.equals(this.letters, other.letters);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(letters);
    }
}
