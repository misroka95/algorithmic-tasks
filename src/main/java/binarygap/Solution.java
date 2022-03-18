package binarygap;

import static com.google.common.base.Preconditions.checkArgument;

public class Solution {
    public int solution(int N) {
        checkArgument(N > 0, "'N' must be positive");
        if (N < 5) {
            return 0;
        }

        char[] bin = Integer.toBinaryString(N).toCharArray();
        int binaryGap = 0;
        int lastBitOneIndex = 0;

        for (int i = 1; i < bin.length; i++) {
            if (bin[i] == '0' && bin[i - 1] == '1') {
                lastBitOneIndex = i - 1;
            } else if (bin[i] == '1' && bin[i - 1] == '0') {
                binaryGap = Math.max(i - lastBitOneIndex - 1, binaryGap);
            }
        }

        return binaryGap;
    }
}
