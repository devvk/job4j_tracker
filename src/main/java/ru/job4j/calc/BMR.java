package ru.job4j.calc;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Basal metabolic rate (BMR)
 * <p>
 * Рассчёт базового обмена веществ по формуле Дрейера.
 * Рассчёт процентного отклонения.
 * Контанта для женского пола: GENDER_FEMALE = new BigDecimal("0.1229");
 */
public class BMR {
    public static final BigDecimal WEIGHT = new BigDecimal("73").multiply(new BigDecimal(1000));
    public static final BigDecimal AGE = new BigDecimal("42");
    public static final double EXPONENT = 0.1333;
    public static final BigDecimal GENDER_MALE = new BigDecimal("0.1015");

    public static void main(String[] args) {
        MathContext mc = new MathContext(10);
        BigDecimal h1 = WEIGHT.sqrt(mc);
        BigDecimal result = BigDecimal.valueOf(Math.pow(AGE.doubleValue(), EXPONENT));
        BigDecimal h2 = GENDER_MALE.multiply(result);
        BigDecimal bmr = h1.divide(h2, mc);
        System.out.println("BMR: " + bmr.intValue() + " kcal.");

        BigDecimal po = getPO(new BigDecimal(106), new BigDecimal(67), new BigDecimal(66));
        System.out.print("Процентное отклонение: " + po.setScale(2, RoundingMode.HALF_UP) + "% = ");
        BigDecimal poKcal = bmr.multiply(po.abs()).divide(new BigDecimal(100),
                RoundingMode.HALF_UP);
        System.out.println(getSign(po.signum()) + poKcal.intValue() + " kcal");

    }

    /**
     * Рассчёт процентного отклонения.
     * Если ПО больше 10%, то нарушен обмен веществ!!!
     *
     * @param sys       верхнее давление
     * @param dia       нижнее давление
     * @param heartRate частота сердечных сокражений
     * @return po       процентное отклонение
     */
    private static BigDecimal getPO(BigDecimal sys, BigDecimal dia, BigDecimal heartRate) {
        // ПД = SYS - DIA
        BigDecimal pd = sys.subtract(dia);
        // ПО = 0.75 (ЧСС + ПД * 0.74) - 72
        BigDecimal po1 = pd.multiply(new BigDecimal("0.74")).add(heartRate);
        BigDecimal po2 = new BigDecimal("0.75").multiply(po1);
        return po2.subtract(new BigDecimal(72));
    }

    private static String getSign(int signum) {
        if (signum == 0) {
            return "0";
        } else if (signum < 0) {
            return "-";
        } else {
            return "+";
        }
    }
}
