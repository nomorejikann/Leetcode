/**
编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
*/
class Solution {
    public String reverseVowels(String s) {
        char[] array=s.toCharArray();
        int first=0;
        int last=array.length-1;

        int length=array.length;
        while(first<last){
            //找到左面的元音字母
            while(first<length&&!isVow(array[first])){
                first++;
            }
            //找到右面的
            while(last>0&&!isVow(array[last])){
                last--;
            }
            if(first>=last)
                return new String(array);
            
            char temp=array[first];
            array[first]=array[last];
            array[last]=temp;
            first++;
            last--;
        }
        return  new String(array);
    }


    public boolean isVow(char a){
        return a=='a'|| a=='e'|| a=='i'|| a=='o'|| a=='u'|| a=='A'|| a=='E'|| a=='I'|| a=='O'|| a=='U';
    }
}
