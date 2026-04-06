class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
          Arrays.sort(asteroids);

          long currmass =mass;
          for(int ast : asteroids){
            if(currmass < ast){
                return false;
            }

            currmass +=ast;
            
          }
          return true;
    }
}