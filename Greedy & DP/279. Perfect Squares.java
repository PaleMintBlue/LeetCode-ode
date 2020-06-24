
// Adrien-Marie Legendre completed the four-square theorem with his three-square theorem, by proving a particular condition that a positive integer can be expressed as the sum of three squares

//n=4^k*(8m+7)

class Solution { 
    public boolean isSquare(int n) {  
        int sqrt = (int)(Math.sqrt(n));  
        return (sqrt*sqrt == n);  
    }
    
    public int numSquares(int n) {
        if(isSquare(n)) return 1;  
        while (n % 4 == 0) n /= 4;  
        if (n % 8 == 7) return 4;
        int sqrt_n = (int)(Math.sqrt(n)); 
        for(int i = 1; i <= sqrt_n; i++)
            if (isSquare(n - i*i)) 
                return 2;  
        return 3;  
    }
}
