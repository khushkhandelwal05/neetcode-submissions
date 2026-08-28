class Solution {

    class Pair {

    }
    public int leastInterval(char[] tasks, int n) {

        // Step 1: count frequencies of each task
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }

        // Step 2: find max frequency and how many tasks have that frequency
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        int countMax = 0;
        for (int f : freq) {
            if (f == maxFreq) countMax++;
        }

        // Step 3: apply formula
        int frameLength = (maxFreq - 1) * (n + 1) + countMax;

        // Step 4: final answer is max(totalTasks, frameLength)
        return Math.max(tasks.length, frameLength);
    }
}
