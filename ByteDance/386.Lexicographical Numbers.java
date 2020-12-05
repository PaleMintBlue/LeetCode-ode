class Solution {
    ArrayList<Integer>  res;
    public List<Integer> lexicalOrder(int n) {
        res = new ArrayList<>();
       
        for(int i = 1; i < 10; i++){
            if(i > n) break;
            res.add(i);
            dfs(i,n);
        }
        
        return res;
    }
    
    
    public void dfs(int prefix, int n){
        prefix *= 10;
        
        for(int i = 0; i < 10; i++){
            int num = prefix + i;
            if(num > n) break;
            res.add(num);
            dfs(num,n);
        }
    }
}
