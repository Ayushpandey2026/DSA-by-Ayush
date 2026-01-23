class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        
        int rowcost=0,colcost=0;
        if(startPos[0]<homePos[0]){
        for(int i=startPos[0];i<homePos[0];i++){
            rowcost +=rowCosts[i+1];
        }
        }
        else{
        for(int i=startPos[0];i>homePos[0];i--){
            rowcost +=rowCosts[i-1];
        }
        }

        if(startPos[1]<homePos[1]){
         for(int i=startPos[1];i<homePos[1];i++){
            colcost +=colCosts[i+1];
        }
        }
        else{
        for(int i=startPos[1];i>homePos[1];i--){
            colcost +=colCosts[i-1];
        }
        }
        return rowcost + colcost;

    }
}