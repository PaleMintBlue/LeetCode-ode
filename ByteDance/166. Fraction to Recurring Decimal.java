class Solution{
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) return "";
        StringBuilder stb = new StringBuilder();
        long num = (long)numerator;
        long den = (long)denominator;
        if(num * den < 0) stb.append("-");
        HashMap<Long, Integer> map = new HashMap<>();
        
        num = Math.abs(num);
        den = Math.abs(den);
        long n = num / den;
        long remain = num % den;
        stb.append(n);
        if(remain == 0) return stb.toString();
        stb.append(".");
        
        while(remain > 0 && !map.containsKey(remain)){
            map.put(remain, stb.length());
            remain *= 10;
            n = remain / den;
            remain = remain % den;
            stb.append(n);
        }
        
        if(remain == 0) return stb.toString();
        stb.insert(map.get(remain), "(");
        stb.append(")");
        return stb.toString();
    }
}
