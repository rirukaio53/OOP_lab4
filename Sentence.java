/**
 * Клас, що представляє речення як масив слів та розділових знаків.
 *
 * @author Student
 * @version 1.0
 */
public class Sentence {

    /**
     * Елемент речення — або слово, або розділовий знак.
     */
    public static class SentenceElement {

        private final Word word;
        private final PunctuationMark punctuationMark;

        /** Конструктор для елемента-слова */
        public SentenceElement(Word word) {
            this.word = word;
            this.punctuationMark = null;
        }

        /** Конструктор для елемента-розділового знака */
        public SentenceElement(PunctuationMark punctuationMark) {
            this.punctuationMark = punctuationMark;
            this.word = null;
        }

        /** @return true, якщо елемент є словом */
        public boolean isWord() {
            return word != null;
        }

        /** @return слово або null */
        public Word getWord() {
            return word;
        }

        /** @return розділовий знак або null */
        public PunctuationMark getPunctuationMark() {
            return punctuationMark;
        }

        @Override
        public String toString() {
            return isWord() ? word.toString() : punctuationMark.toString();
        }
    }

    /** Масив елементів речення */
    private final SentenceElement[] elements;

    /**
     * Конструктор для створення речення з рядка.
     * Замінює послідовності пробілів і табуляцій одним пробілом.
     *
     * @param rawSentence рядок речення
     */
    public Sentence(String rawSentence) {
        String normalized = rawSentence.trim().replaceAll("[ \\t]+", " ");
        this.elements = parse(normalized);
    }

    private SentenceElement[] parse(String normalized) {
        int count = 0;
        int i = 0;
        while (i < normalized.length()) {
            char c = normalized.charAt(i);
            if (c == ' ') { i++; continue; }
            if (PunctuationMark.isPunctuation(c)) {
                count++; i++;
            } else {
                int start = i;
                while (i < normalized.length()
                        && normalized.charAt(i) != ' '
                        && !PunctuationMark.isPunctuation(normalized.charAt(i))) {
                    i++;
                }
                if (i > start) count++;
            }
        }

        SentenceElement[] result = new SentenceElement[count];
        int idx = 0;
        i = 0;
        while (i < normalized.length()) {
            char c = normalized.charAt(i);
            if (c == ' ') { i++; continue; }
            if (PunctuationMark.isPunctuation(c)) {
                result[idx++] = new SentenceElement(new PunctuationMark(c));
                i++;
            } else {
                int start = i;
                while (i < normalized.length()
                        && normalized.charAt(i) != ' '
                        && !PunctuationMark.isPunctuation(normalized.charAt(i))) {
                    i++;
                }
                result[idx++] = new SentenceElement(new Word(normalized.substring(start, i)));
            }
        }
        return result;
    }

    /**
     * Повертає кількість елементів у реченні.
     *
     * @return кількість елементів
     */
    public int size() {
        return elements.length;
    }

    /**
     * Повертає елемент речення за індексом.
     *
     * @param index індекс
     * @return елемент речення
     */
    public SentenceElement getElement(int index) {
        return elements[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (SentenceElement el : elements) {
            if (el.isWord()) {
                if (sb.length() > 0) sb.append(' ');
                sb.append(el.toString());
            } else {
                sb.append(el.toString());
            }
        }
        return sb.toString();
    }
}
