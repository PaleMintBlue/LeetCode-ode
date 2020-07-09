/*

Algo:
1. Take minval and maxVal amoing first element in all given arrays. Also, capture whihc array holds that in var minK.
2. Have an array (say dp) of size k (given k list) to store the minIndex on all given arrays.
3. while(dp[minK] of any one array is done) then we are done coverig all given array
    Until then, 
        a. Get next value from array minK with index dp[minK]
        b. Compare that value with all K list and update their minIndex in dp accordingly.
        c. Also, capture next minVal, maxVal and minK
*/

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        return helper(nums);
    }
    
    public int[] helper(List<List<Integer>> nums) {
        int k=nums.size();
        if(k == 1) {
            return new int[] {nums.get(0).get(0), nums.get(0).get(0)};
        }
        int[] res = new int[2]; 
        int[] dp = new int[k];
        
        int minK = 0;
        int minVal = nums.get(0).get(0);
        int maxVal = nums.get(0).get(0);
        
        //Find minVal, minIndex sort list and maxVal
        for(int i =0;i<k;i++) {
            int val = nums.get(i).get(0);
            
            if(val< minVal) {
                minVal=val;
                minK = i;
            }
            if(val>maxVal) {
                maxVal = val;
            }
        }
        res = new int[]{minVal, maxVal};
        
        //Do until we cover anyone list completely
        boolean done = false;
        while(!done) {
            List<Integer> nextNums = nums.get(minK);
            dp[minK]++;
            if(dp[minK]==nextNums.size()) {
                done=true;
                continue;
            }
            int next = nextNums.get(dp[minK]);
            minVal=next;
            
            //Check all k list for next minVal and maxVal
            for(int i = 0;i<k ;i++) {
                
                nextNums = nums.get(i);
                int currIdx = dp[i];
                int currSize = nextNums.size();
                while(currIdx<currSize && nextNums.get(currIdx)<=next) {
                    dp[i]=currIdx;
                    currIdx++;
                } 
                int val = nextNums.get(dp[i]);
                if(val< minVal) {
                    minVal=val;
                    minK = i;
                }
                if(val>maxVal) {
                    maxVal = val;
                }
            }
                if((maxVal-minVal)<(res[1]-res[0]))
                    res = new int[]{minVal, maxVal};
        }
        
        return res;
   }
}

//O(min(length of k list) * k)

// class Solution {
//     public int[] smallestRange(List<List<Integer>> nums) {
//         int k = nums.size();
//         int[] map =  new int[k];
//         for (int i = 0; i < k; i++) map[i] = 1;
//         int count = k;
//         int min = Integer.MAX_VALUE, st = 0, end = 0;
//         List<int[]> ls = new ArrayList<>();
        
//         for (int i = 0; i < k; i++) {
//             for (int e : nums.get(i)) {
//                 ls.add(new int[]{e, i});
//             }
//         }
//         Collections.sort(ls, (a,b) -> a[0] - b[0]);
//         int i = 0, j = 0;
//         while (j < ls.size()) {
//             int c = ls.get(j)[1];
//             map[c]--;
//             if (map[c] >= 0)  count--;
//             while (count == 0) {
//                 int t = ls.get(i)[1];
//                 map[t]++;
//                 if (map[t] > 0) count++;
//                 if (ls.get(j)[0] - ls.get(i)[0] < min) {
//                     min = ls.get(j)[0] - ls.get(i)[0];
//                     st = ls.get(i)[0];
//                     end = ls.get(j)[0];
//                 }
//                 i++;
//             }
//             j++;
//         }
//         return new int[]{st, end};
//     }
// }
