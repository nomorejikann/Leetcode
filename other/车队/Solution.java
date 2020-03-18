/**

N  辆车沿着一条车道驶向位于 target 英里之外的共同目的地。

每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。

一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。

此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。

车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。

即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
*/
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        quickSort(position,speed,0,position.length-1);
        //从后向前遍历
        int count=0;
        double time=0;
        for(int i=position.length-1;i>=0;i--){
            double temptime=(double)(target-position[i])/speed[i];
            if(temptime>time){
                time=temptime;
                count++;
            }
        }
        return count;

    }

    public void quickSort(int[] position,int[] speed, int start, int end){
       
        int i=start,j=end;
        if(i<j){
            int tempPosition=position[start], tempSpeed=speed[start];
            while(i!=j){
                while(i<j && position[j]>=tempPosition){
                    j--;
                }
                if(i<j){
                    position[i]=position[j];
                    speed[i]=speed[j];
                    i++;
                }
                while(i<j && position[i]<tempPosition){
                    i++;
                }
                if(i<j){
                    position[j]=position[i];
                    speed[j]=speed[i];
                    j--;
                }
            }
            position[i]=tempPosition;
            speed[i]=tempSpeed;
            quickSort(position,speed,start,i-1);
            quickSort(position,speed,i+1,end);
        }
    }


    public void swap(int[] array,int a, int b){
        int temp=array[a];
        array[a]=array[b];
        array[b]=array[a];
    }
}
