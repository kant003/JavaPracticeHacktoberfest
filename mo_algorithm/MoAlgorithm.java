
public class MoAlgorithm {
    public static class Query {
        public int l, r, idx;
        public Query(int l, int r, int idx) { this.l = l; this.r = r; this.idx = idx; }
    }
    public static int[] mosDistinct(int[] arr, Query[] queries) {
        int n = arr.length;
        int q = queries.length;
        int block = (int)Math.max(1, Math.sqrt(n));

        java.util.Arrays.sort(queries, (a, b) -> {
            int ab = a.l / block;
            int bb = b.l / block;
            if (ab != bb) return Integer.compare(ab, bb);
            // Alternate ordering for improved cache behavior
            return ((ab & 1) == 0) ? Integer.compare(a.r, b.r) : Integer.compare(b.r, a.r);
        });

        java.util.Map<Integer, Integer> freq = new java.util.HashMap<>();
        int curL = 0, curR = -1;
        int distinct = 0;
        int[] ans = new int[q];

        for (Query qu : queries) {
            while (curL > qu.l) {
                curL--;
                int v = arr[curL];
                int f = freq.getOrDefault(v, 0) + 1;
                freq.put(v, f);
                if (f == 1) distinct++;
            }
            while (curR < qu.r) {
                curR++;
                int v = arr[curR];
                int f = freq.getOrDefault(v, 0) + 1;
                freq.put(v, f);
                if (f == 1) distinct++;
            }
            while (curL < qu.l) {
                int v = arr[curL];
                int f = freq.get(v);
                if (f == 1) freq.remove(v); else freq.put(v, f - 1);
                if (f == 1) distinct--;
                curL++;
            }
            while (curR > qu.r) {
                int v = arr[curR];
                int f = freq.get(v);
                if (f == 1) freq.remove(v); else freq.put(v, f - 1);
                if (f == 1) distinct--;
                curR--;
            }
            ans[qu.idx] = distinct;
        }

        return ans;
    }
}
