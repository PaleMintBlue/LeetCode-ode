class Solution {
    // allocate houses to nearest heaters, then find the max distance 
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int j = 0,radius = 0;
        for(int i=0; i<houses.length; i++) {
            while(j<heaters.length-1 && Math.abs(heaters[j+1]-houses[i])<=Math.abs(heaters[j]-houses[i])) j++;   
            radius = Math.max(radius, Math.abs(heaters[j]-houses[i]));   
        }
        return radius;
    }
}
