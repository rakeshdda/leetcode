class Solution {
    public int characterReplacement(String s, int k) {
      
		 HashMap<Character, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;

        int maxlength = 0;
        int maxfrequency = 0;

        while (j < s.length()) {

            char ch = s.charAt(j);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxfrequency = Math.max(maxfrequency, map.get(ch));

            //window is valid, if 
            if ((j - i + 1) - maxfrequency <= k) {
                maxlength = Math.max(maxlength, j - i + 1);
            }

            //window is not valid
            while ((j - i + 1) - maxfrequency > k) {

                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);

                i++;
            }

            j++;
        }
        return maxlength;
	}
}
  
