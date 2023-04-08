package MimeType;

import java.util.*;

public class Solution {

    private static Map<String, String> MMETypes = new HashMap<>();
    private static List<String> files = new ArrayList<>();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        in.nextLine();


        for (int i = 0; i < N; i++) {
            String[] input = in.nextLine().split(" ");
            MMETypes.put(input[0].toLowerCase(), input[1]);
        }

        for (int i = 0; i < Q; i++) {
            files.add(in.nextLine().toLowerCase());
        }

        for (String file : files) {
            String result = equals(file);
            System.out.println(result == null ? "UNKNOWN" : result);
        }

    }

    public static String equals(String file) {
        if (file.matches(".*\\W$")) return null;
        String[] fileArr = file.split("\\.");
        if (fileArr.length <= 1) return null;

        return MMETypes.getOrDefault(fileArr[fileArr.length - 1], null);
    }
}
