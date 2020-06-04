class Solution {
    public double myPow(double x, int n) {
        boolean neg = false;
        if(n<0) {
            n = -n;
            neg = true;
        }
        return neg ? 1/pow(x,n) : pow(x,n);
        
        
    }
    
    private double pow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        if(n % 2 == 0) {
            double tmp = pow(x,n/2);
            return tmp*tmp;
        } else {
            double tmp = pow(x,n/2);
            return tmp*tmp*x;
        }
    }
}
