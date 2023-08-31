import java.util.Scanner;

public class Lesson5 {
    /**
     * Задание 5
     * |Королю нужно убить дракона, но в его казне мало средств
     * |для покупки армии. Нужно создать программу, используя
     * |методы, которая поможет рассчитать минимальное количество копейщиков, которое необходимо, чтобы убить
     * |дракона. C клавиатуры вводятся данные:
     * |    ■ здоровья дракона;
     * |    ■ атаки дракона;
     * |    ■ здоровье одного копейщика;
     * |    ■ атака одного копейщика.
     * |Защита, меткость и т. п. не учитывать. Копейщики наносят
     * |удар первыми (общий нанесенный урон – это сумма атак
     * |всех живых копейщиков). Если атака дракона превышает
     * |значение жизни копейщика (например, у копейщика жизни – 10, а атака – 15), то умирает несколько копейщиков, а
     * |оставшийся урон идет одному из копейщиков.
     * Например, жизнь дракона – 500, атака – 55, жизнь одного копейщика – 10, атака –10, а количество копейщиков при
     * данных условиях – 20.
     * Лог боя для данного примера должен выглядеть так:
     * Итерация 15
     * Копейщики атакуют (урон 200) – у дракона осталось 300 жизней
     * Дракон атакует – осталось 15 копейщиков, один из которых ранен
     * (осталось 5 жизней)
     * Копейщики атакуют – у дракона осталось 150 жизней
     * Дракон атакует – осталось 9 копейщиков
     * Копейщики атакуют – у дракона осталось 60 жизней
     * Дракон атакует – осталось 4 копейщика, один из которых ранен
     * (осталось 5 жизней)
     * Копейщики атакуют – у дракона осталось 20 жизней
     * Дракон атакует и побеждает
     */

    public static void main(String[] args) {
        Lesson5 lesson5 = new Lesson5();
        lesson5.createDragon();
        lesson5.createSpearman();
        minValueSpearman(lesson5.getDragonDamage(), lesson5.getDragonHP(), lesson5.getSpearmanDamage(), lesson5.getSpearmanHP());
    }
    private int dragonHP;
    private int dragonDamage;
    private int spearmanHP;
    private int spearmanDamage;

    public static int numberSpearman = 1;
    public static int strokeCounter = 1;

    public void setDragonHP(int dragonHP) {
        this.dragonHP = dragonHP;
    }

    public void setDragonDamage(int dragonDamage) {
        this.dragonDamage = dragonDamage;
    }

    public void setSpearmanHP(int spearmanHP) {
        this.spearmanHP = spearmanHP;
    }

    public void setSpearmanDamage(int spearmanDamage) {
        this.spearmanDamage = spearmanDamage;
    }

    public int getDragonDamage() {
        return dragonDamage;
    }

    public int getDragonHP() {
        return dragonHP;
    }

    public int getSpearmanDamage() {
        return spearmanDamage;
    }

    public int getSpearmanHP() {
        return spearmanHP;
    }

    public void createDragon() {
        System.out.println("Введите здоровье дракона:");
        setDragonHP(scanner.nextInt());
        System.out.println("Введите урон дракона:");
        setDragonDamage(scanner.nextInt());
    }

    public void createSpearman() {
        System.out.println("Введите здоровье копейщика:");
        setSpearmanHP(scanner.nextInt());
        System.out.println("Введите урон копейщика:");
        setSpearmanDamage(scanner.nextInt());
    }
    public static void minValueSpearman(int dragonDamage, int dragonHP, int spearmanDamage, int spearmanHP) {
        double HP = spearmanHP * numberSpearman;
        int dragon = dragonHP;
        while (true) {
            int damage = spearmanDamage * ((int) Math.ceil(HP / spearmanHP));
            if (!(strokeCounter % 2 == 0)) {
                if (HP > 0) {
                    dragon -= damage;
                    strokeCounter++;
                }
            } else {
                if (HP > 0 && dragon > 0) {
                    HP -= dragonDamage;
                    strokeCounter++;
                }
            }
            if (HP <= 0) {
                break;
            }
            if (dragon <= 0) {
                System.out.println("минимальное количество копейщиков: " + numberSpearman);
                return;
            }
        }
        numberSpearman++;
        strokeCounter = 1;
        minValueSpearman(dragonDamage, dragonHP, spearmanDamage, spearmanHP);
    }
    public static Scanner scanner = new Scanner(System.in);
}
