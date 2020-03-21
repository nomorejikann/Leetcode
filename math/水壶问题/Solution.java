/**
有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？

如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水
*/
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z)
          return false;
        if(x == 0 || y == 0)
          return z == 0 || x+y==z;
         
          return  z % gcd(x,y) == 0;
    }

    public int gcd(int a, int b){
        if(b == 0)
          return a;
        return gcd(b, a%b);
    }
}
