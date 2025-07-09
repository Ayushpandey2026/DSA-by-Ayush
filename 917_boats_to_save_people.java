class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boat= 0;
        int n= people.length;
        Arrays.sort(people);
        int sum =0;
        for(int i = 0;i<n;i++){
          if( i == n-1 && people[i] < limit)  continue;
            if(people[i] == limit) boat++;
            else if(people[i]<limit){
                sum += people[i];
                if(sum > limit) {
                   boat =  boat+2;
                    sum = 0;
                    continue;
                }
            }
        }
        if(sum > 0) return boat+1;
            return boat;
    }
}