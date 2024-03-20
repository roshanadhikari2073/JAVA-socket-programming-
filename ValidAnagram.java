// https://leetcode.com/problems/valid-anagram/description/
// https://leetcode.com/problems/valid-anagram/submissions/1208816231/
class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false; 

        int[] letterCount = new int[26];

        for(int i = 0; i < s.length(); i++) {
            letterCount[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < t.length(); i++) {
            if(--letterCount[t.charAt(i) - 'a'] < 0) {
                return false; 
            }
        }
        return true;
    }
}
