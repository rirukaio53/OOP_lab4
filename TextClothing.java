/**
 * Клас, що представляє одяг із мінімум 5 полями.
 * Рядкові поля зберігаються як об'єкти Text.
 * Реалізує Comparable для сортування за ціною.
 *
 * @author Student
 * @version 1.0
 */
public class TextClothing implements Comparable<TextClothing> {

    private Text name;
    private Text size;
    private Text color;
    private double price;
    private Text material;
    private Text brand;

    /**
     * Конструктор. Всі рядкові поля нормалізуються через клас Text
     * (зайві пробіли та табуляції замінюються одним пробілом).
     *
     * @param name     назва одягу
     * @param size     розмір
     * @param color    колір
     * @param price    ціна
     * @param material матеріал
     * @param brand    бренд
     */
    public TextClothing(String name, String size, String color,
                        double price, String material, String brand) {
        this.name     = new Text(name);
        this.size     = new Text(size);
        this.color    = new Text(color);
        this.price    = price;
        this.material = new Text(material);
        this.brand    = new Text(brand);
    }

    /** @return назва одягу */
    public String getName()     { return name.toString(); }

    /** @return розмір одягу */
    public String getSize()     { return size.toString(); }

    /** @return колір одягу */
    public String getColor()    { return color.toString(); }

    /** @return ціна одягу */
    public double getPrice()    { return price; }

    /** @return матеріал одягу */
    public String getMaterial() { return material.toString(); }

    /** @return бренд одягу */
    public String getBrand()    { return brand.toString(); }

    /** @param name нова назва */
    public void setName(String name)         { this.name     = new Text(name); }

    /** @param size новий розмір */
    public void setSize(String size)         { this.size     = new Text(size); }

    /** @param color новий колір */
    public void setColor(String color)       { this.color    = new Text(color); }

    /** @param price нова ціна */
    public void setPrice(double price)       { this.price    = price; }

    /** @param material новий матеріал */
    public void setMaterial(String material) { this.material = new Text(material); }

    /** @param brand новий бренд */
    public void setBrand(String brand)       { this.brand    = new Text(brand); }

    /**
     * Сортування за ціною (зростання).
     *
     * @param other інший об'єкт
     * @return результат порівняння
     */
    @Override
    public int compareTo(TextClothing other) {
        return Double.compare(this.price, other.price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TextClothing other = (TextClothing) obj;
        return Double.compare(other.price, price) == 0
                && getName().equals(other.getName())
                && getSize().equals(other.getSize())
                && getColor().equals(other.getColor())
                && getMaterial().equals(other.getMaterial())
                && getBrand().equals(other.getBrand());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getSize().hashCode();
        result = 31 * result + getColor().hashCode();
        result = 31 * result + Double.hashCode(price);
        result = 31 * result + getMaterial().hashCode();
        result = 31 * result + getBrand().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format(
                "TextClothing{name='%s', size='%s', color='%s', price=%.2f грн, material='%s', brand='%s'}",
                getName(), getSize(), getColor(), price, getMaterial(), getBrand());
    }
}
