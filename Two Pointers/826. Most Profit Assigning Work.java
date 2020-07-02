
class Solution {
    
    class Job {
        int d;
        int p;
        Job(int difficulty, int profit){
            this.d = difficulty;
            this.p = profit;
        }
    }
    
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int N = difficulty.length;
        Job[] jobs = new Job[N];
        for (int i = 0; i < N; ++i)
            jobs[i] = new Job(difficulty[i], profit[i]);
        Arrays.sort(jobs, (a, b) -> a.d - b.d);
        Arrays.sort(worker);
        int res = 0, i = 0, best = 0;
        for (int skill: worker) {
            while (i < N && skill >= jobs[i].d)
                best = Math.max(best, jobs[i++].p);
            res += best;
        }

        return res;
    }
}
