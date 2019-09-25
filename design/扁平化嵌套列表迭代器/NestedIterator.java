/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<Integer> s=new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        init(nestedList);
    }
    public void init(List<NestedInteger>  list){
        for(int i=list.size()-1;i>=0;i--){
            NestedInteger nest=list.get(i);
            if(nest.getInteger()!=null)
                s.push(nest.getInteger());
        else
            init(nest.getList());
        }
    }

    @Override
    public Integer next() {
        
        return s.pop();
    }

    @Override
    public boolean hasNext() {
    
        return !s.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
