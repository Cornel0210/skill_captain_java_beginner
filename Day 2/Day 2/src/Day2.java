public class Day2 {
    public static void main(String[] args) {
        short minShort = Short.MIN_VALUE;
        short maxShort = Short.MAX_VALUE;

        byte minByte = Byte.MIN_VALUE;
        byte maxByte = Byte.MAX_VALUE;

        int minInt = Integer.MIN_VALUE;
        int maxInt = Integer.MAX_VALUE;

        long minLong = Long.MIN_VALUE;
        long maxLong = Long.MAX_VALUE;

        float minF = Float.MIN_VALUE;
        float maxF = Float.MAX_VALUE;

        double minD = Double.MIN_VALUE;
        double maxD = Double.MAX_VALUE;

        char ch = 'A';

        boolean flag = true;

        System.out.println(minShort);
        System.out.println(maxShort);
        System.out.println(minByte);
        System.out.println(maxByte);
        System.out.println(minInt);
        System.out.println(maxInt);
        System.out.println(minLong);
        System.out.println(maxLong);
        System.out.println(minF);
        System.out.println(maxF);
        System.out.println(minD);
        System.out.println(maxD);
        System.out.println(ch);
        System.out.println(flag);


        System.out.println((char) (ch + 1));

        System.out.println((++maxByte) == minByte);
    }
}
