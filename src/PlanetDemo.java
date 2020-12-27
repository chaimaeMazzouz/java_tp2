public class PlanetDemo {

    public enum Planet {
        TERRE(5.976e+24, 6.37814e6),
        MARS(6.421e+23, 3.3972e6),
        VENUS(4.869e+24, 6.0518e6),
        JUPITER(1.9e+27, 7.1492e7),
        SATURN(5.688e+26, 6.0268e7),
        URANUS(8.686e+25, 2.5559e7),
        NEPTUNE(1.024e+26, 2.4746e7),
        MERCURE(3.303e+23, 2.4397e6);

        private final double mass; // in kilograms
        private final double radius; // in meters

        Planet(double masse, double rayon) {
            // TODO Auto-generated constructor stub
            mass = masse;
            radius = rayon;
        }

        public double getMass() {
            return mass;
        }

        public double getRadius() {
            return radius;
        }

        public static final double G = 6.67300E-11;

        double graviteSurface() {
            return G * mass / (radius * radius);
        }

        double poidSurface(double masse) {
            return masse * graviteSurface();
        }

        public static void main(String[] args) {
            if (args.length != 1) {
                System.err.println("E:Le programme necessite un argument pour s'executer!");
                System.exit(-1);
            }
            double poidTerre = Double.parseDouble(args[0]);
            double masse = poidTerre / TERRE.graviteSurface();
            for (Planet p : Planet.values()) {
                System.out.println("Le poid de cet objet sur " + p + " est :" + p.poidSurface(masse));
            }
        }
    }
}
