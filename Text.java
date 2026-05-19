/**
 * Клас, що представляє текст як масив речень.
 *
 * @author Student
 * @version 1.0
 */
public class Text {

    /** Масив речень, що утворюють текст */
    private final Sentence[] sentences;

    /**
     * Конструктор для створення тексту з рядка.
     * Замінює послідовності пробілів і табуляцій одним пробілом,
     * розбиває на речення за '.', '!', '?'.
     *
     * @param rawText рядок тексту
     */
    public Text(String rawText) {
        String normalized = rawText.trim().replaceAll("[ \\t]+", " ");
        this.sentences = parseSentences(normalized);
    }

    private Sentence[] parseSentences(String normalized) {
        int count = 0;
        for (int i = 0; i < normalized.length(); i++) {
            char c = normalized.charAt(i);
            if (c == '.' || c == '!' || c == '?') count++;
        }

        if (count == 0) {
            return new Sentence[]{new Sentence(normalized)};
        }

        Sentence[] result = new Sentence[count];
        int idx = 0;
        int start = 0;

        for (int i = 0; i < normalized.length(); i++) {
            char c = normalized.charAt(i);
            if (c == '.' || c == '!' || c == '?') {
                String raw = normalized.substring(start, i + 1).trim();
                if (!raw.isEmpty()) {
                    result[idx++] = new Sentence(raw);
                }
                start = i + 1;
            }
        }

        if (idx < result.length) {
            Sentence[] trimmed = new Sentence[idx];
            System.arraycopy(result, 0, trimmed, 0, idx);
            return trimmed;
        }

        return result;
    }

    /**
     * Повертає кількість речень у тексті.
     *
     * @return кількість речень
     */
    public int size() {
        return sentences.length;
    }

    /**
     * Повертає речення за індексом.
     *
     * @param index індекс речення
     * @return об'єкт Sentence
     */
    public Sentence getSentence(int index) {
        return sentences[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            if (sb.length() > 0) sb.append(' ');
            sb.append(sentence.toString());
        }
        return sb.toString();
    }
}
