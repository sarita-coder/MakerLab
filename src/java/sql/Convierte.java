package sql;

public class Convierte {

    public static Integer aInteger(String s) {
        Integer result = null;

        try {
            result = Integer.valueOf(s);
        } catch (NumberFormatException ex) {
        }

        return result;
    }

    public static Double aDouble(String s) {
        Double result = null;

        try {
            result = Double.valueOf(s);
        } catch (NumberFormatException ex) {
        }

        return result;
    }

    public Convierte() {
    }
}