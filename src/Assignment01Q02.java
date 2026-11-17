public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;

        int sumnds = Integer.parseInt(args[0]);
        int denominator = 1;
        for (int i = 0; i < sumnds; i++) {
            approxPi += (1.0 / denominator) * Math.pow(-1, i);
            denominator += 2;
        }
        approxPi *= 4;

        System.out.println(approxPi + " " + actualPi);
    }
}
