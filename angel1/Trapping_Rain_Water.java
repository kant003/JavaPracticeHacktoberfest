class Trapping_Rain_Water {
    public int trap(int[] arr) {

        int result = 0, n = arr.length;
        int[] lMax = new int[n];
        int[] rMax = new int[n];

        lMax[0] = arr[0];
        rMax[n-1] = arr[n-1];

        for(int i=1; i<n; i++) lMax[i] = Math.max(arr[i], lMax[i-1]);

        for(int i=n-2; i>=0; i--) rMax[i] = Math.max(arr[i], rMax[i+1]);

        for(int i=0; i<n; i++)
        {
            result += Math.min(lMax[i],rMax[i]) - arr[i];
        }

        return result;
    }
}