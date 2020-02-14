/**
在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。

例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。

我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。

最终结果按照字典顺序输出。
*/
class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        int c=1;
        int pre=0;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<S.length();i++){
           if(S.charAt(pre)==S.charAt(i)){
                c++;
            }else{
                if(c>=3){
                    List<Integer> l=new ArrayList<>();
                    l.add(pre);
                    l.add(i-1);
                    ans.add(l);
                }
            pre=i;
            c=1;
            }


        }
        if(c>=3){
            List<Integer> l=new ArrayList<>();
            l.add(pre);
            l.add(S.length()-1);
            ans.add(l);
        }
        return ans;
    }
}
