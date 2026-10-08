class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = 0;
        int total = 0;
        int totalGas = 0;
        int tripTotal = 0;

        for(int i = 0 ; i < gas.length ; i++) {
            if(total < 0) {
                total = 0;
                res = i;
            }
            total = total + (gas[i] - cost[i]);
            totalGas += gas[i];
            tripTotal += cost[i];
        }

        if(tripTotal > totalGas) return -1;

        return res;
    }
}
