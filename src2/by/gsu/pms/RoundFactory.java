package by.gsu.pms;

public enum RoundFactory {

    ROUND{
        protected double roundFunction(double value){

            return Math.round(value);
        }
    },
    FLOOR{
        final protected double roundFunction(double value){

            return Math.floor(value);
        }
    };

    abstract double roundFunction(double value);

    public final int round(double value, int degree){

        int tenPow = pow10(degree);
        return (int)roundFunction(value / tenPow) * tenPow;
    }

    private static int pow10(int degree){

        int result = 1;
        for (int deg = 0; deg < degree; deg++){
            result *= 10;
        }
        return result;
    }
}