package lesson5;

class Power {
    static double pow(double number, int power) {
        if (number == 0 && power <= 0)
            throw new ArithmeticException("/ by zero");

        if (power == 0)
            return 1;
        else if (power == 1)
            return number;
        else if (power == -1)
            return 1 / number;

        if (power < 1)
            return number * pow(number, power + 1);
        else
            return number * pow(number, power - 1);
    }
}
