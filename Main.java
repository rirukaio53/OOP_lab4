import java.util.Arrays;
import java.util.Comparator;

public class Main {

    /**
     * Точка входу в програму.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {

        // ─── 1. Створення масиву об'єктів TextClothing ───────────────────────
        TextClothing[] clothes = {
            new TextClothing("Футболка",  "M",  "Біла",      450.00, "Бавовна",   "Zara"),
            new TextClothing("Джинси",    "L",  "Синя",     1200.00, "Деним",     "Levi's"),
            new TextClothing("Куртка",    "XL", "Чорна",    3500.00, "Поліестер", "Nike"),
            new TextClothing("Светр",     "S",  "Сіра",      890.00, "Вовна",     "H&M"),
            new TextClothing("Сорочка",   "M",  "Блакитна",  650.00, "Льон",      "Zara"),
            new TextClothing("Спідниця",  "S",  "Червона",   780.00, "Шовк",      "Mango"),
            new TextClothing("Пальто",    "L",  "Бежева",   4200.00, "Кашемір",   "Massimo Dutti"),
            new TextClothing("Шорти",     "M",  "Зелена",    350.00, "Бавовна",   "Adidas"),
        };

        // ─── 2. Демонстрація нормалізації пробілів і табуляцій ───────────────
        System.out.println("=== Демонстрація нормалізації пробілів і табуляцій ===");
        TextClothing example = new TextClothing(
                "Футболка  з  принтом",
                "M",
                "Біла\tта\tчорна",
                299.00,
                "Бавовна   95%",
                "No  Name"
        );
        System.out.println("Після нормалізації: " + example);

        // ─── 3. Вивід початкового масиву ─────────────────────────────────────
        System.out.println("\n=== Початковий масив ===");
        printArray(clothes);

        // ─── 4. Сортування за ціною (зростання) — Comparable ─────────────────
        Arrays.sort(clothes);
        System.out.println("\n=== Сортування за ціною (зростання) ===");
        printArray(clothes);

        // ─── 5. Сортування за брендом (спадання) — Comparator ────────────────
        Arrays.sort(clothes, Comparator.comparing(TextClothing::getBrand).reversed());
        System.out.println("\n=== Сортування за брендом (спадання) ===");
        printArray(clothes);

        // ─── 6. Пошук ідентичного об'єкта ────────────────────────────────────
        TextClothing target = new TextClothing(
                "Футболка", "M", "Біла", 450.00, "Бавовна", "Zara");
        System.out.println("\n=== Пошук ідентичного об'єкта ===");
        System.out.println("Шукаємо: " + target);

        int foundIndex = findIdentical(clothes, target);
        if (foundIndex >= 0) {
            System.out.println("Знайдено на індексі " + foundIndex + ": " + clothes[foundIndex]);
        } else {
            System.out.println("Об'єкт не знайдено в масиві.");
        }

        // ─── 7. Демонстрація структури Text → Sentence → Word → Letter ───────
        System.out.println("\n=== Структура Text → Sentence → Word → Letter ===");
        demonstrateTextStructure("Massimo Dutti");
    }

    /**
     * Виводить усі елементи масиву.
     *
     * @param clothes масив об'єктів TextClothing
     */
    private static void printArray(TextClothing[] clothes) {
        for (int i = 0; i < clothes.length; i++) {
            System.out.printf("[%d] %s%n", i, clothes[i]);
        }
    }

    /**
     * Знаходить перший ідентичний об'єкт у масиві.
     *
     * @param clothes масив для пошуку
     * @param target  зразок
     * @return індекс або -1
     */
    private static int findIdentical(TextClothing[] clothes, TextClothing target) {
        for (int i = 0; i < clothes.length; i++) {
            if (clothes[i].equals(target)) return i;
        }
        return -1;
    }

    /**
     * Виводить ієрархічну структуру тексту: речення → слова → літери.
     *
     * @param rawText рядок для демонстрації
     */
    private static void demonstrateTextStructure(String rawText) {
        Text text = new Text(rawText);
        System.out.printf("Текст: \"%s\" (%d речень)%n", text, text.size());

        for (int s = 0; s < text.size(); s++) {
            Sentence sentence = text.getSentence(s);
            System.out.printf("  Речення [%d]: \"%s\" (%d елементів)%n",
                    s, sentence, sentence.size());

            for (int e = 0; e < sentence.size(); e++) {
                Sentence.SentenceElement el = sentence.getElement(e);
                if (el.isWord()) {
                    Word word = el.getWord();
                    System.out.printf("    Слово [%d]: \"%s\" (%d літер) → ", e, word, word.length());
                    for (int l = 0; l < word.length(); l++) {
                        System.out.print("'" + word.getLetter(l) + "'");
                        if (l < word.length() - 1) System.out.print(", ");
                    }
                    System.out.println();
                } else {
                    System.out.printf("    Розділовий знак [%d]: '%s'%n",
                            e, el.getPunctuationMark());
                }
            }
        }
    }
}
