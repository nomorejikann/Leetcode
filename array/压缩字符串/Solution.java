	/**
	 * 给定一组字符，使用原地算法将其压缩。 压缩后的长度必须始终小于或等于原数组长度。 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
	 * 在完成原地修改输入数组后，返回数组的新长度。
	 * 
	 * @param chars
	 * @return
	 */
class Solution {
    public int compress(char[] chars) {
        if (chars.length < 1)
			return 0;
		if (chars.length == 1)
			return 1;
		char pre = chars[0];
		int count = 1;
		int idx = 0;
		for (int i = 1; i < chars.length; i++) {
			if (pre != chars[i]) {
				chars[idx++] = pre;
				if (count > 1) {
					for(char c : String.valueOf(count).toCharArray())
						chars[idx++] = c;
				}
				count = 0;
				pre = chars[i];
			}
			count++;
		}
		chars[idx++] = pre;
		if (count > 1) {
			for(char c : String.valueOf(count).toCharArray())
				chars[idx++] = c;
		}
		return idx;
    }
}
