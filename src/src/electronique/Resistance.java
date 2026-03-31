package electronique;

public class Resistance extends Composant{

    public static double resistance;

    public Resistance(double resistance) {
        setResistance(resistance);
    }

    @Override
    public double calculerResistance(){
        return getResistance();
    }

    public static double getResistance() {
        return resistance;
    }

    public static void setResistance(double resistance) {
        Resistance.resistance = resistance;
    }
}
