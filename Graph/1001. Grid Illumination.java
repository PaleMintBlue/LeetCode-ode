class Solution {
    int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}, {0,0}};
    
	public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> rowCnt = new HashMap();       
        Map<Integer, Integer> colCnt = new HashMap();       
        Map<Integer, Integer> dia1Cnt = new HashMap();       
        Map<Integer, Integer> dia2Cnt = new HashMap();     
        Map<Integer, Boolean> illum = new HashMap();       
        
        for(int[] l: lamps){
            int x = l[0], y = l[1];
            rowCnt.put(x, rowCnt.getOrDefault(x, 0) + 1);
            colCnt.put(y, colCnt.getOrDefault(y, 0) + 1);
            dia1Cnt.put(x-y, dia1Cnt.getOrDefault(x-y, 0) + 1);
            dia2Cnt.put(x+y, dia2Cnt.getOrDefault(x+y, 0) + 1);
            illum.put(N*x + y, true);
        }

        int[] ans = new int[queries.length];
        int i = 0;
        for(int[] q: queries){
            int x = q[0], y = q[1];
            
            ans[i] = (rowCnt.getOrDefault(x, 0) > 0 || colCnt.getOrDefault(y, 0) > 0 || dia1Cnt.getOrDefault(x-y, 0) > 0 || dia2Cnt.getOrDefault(x+y, 0) > 0) ? 1 : 0;            
            
            for(int[] d: dir){
                int x1 = x + d[0];
                int y1 = y + d[1];
				if(illum.containsKey(N*x1 + y1) && illum.get(N*x1 + y1)){
                    rowCnt.put(x1, rowCnt.getOrDefault(x1, 1) - 1);
                    colCnt.put(y1, colCnt.getOrDefault(y1, 1) - 1);
                    dia1Cnt.put(x1 - y1, dia1Cnt.getOrDefault(x1 - y1, 1) - 1);
                    dia2Cnt.put(x1 + y1, dia2Cnt.getOrDefault(x1 + y1, 1) - 1);
                    illum.put(N*x1+y1, false);
                }
            }
            i++;
        }
        
        return ans;
    }
}
