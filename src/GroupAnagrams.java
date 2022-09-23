// #Facebook
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

/**
 * https://leetcode.com/articles/group-anagrams/
 *
 *
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 */

public class GroupAnagrams
{
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0) return new ArrayList();
		Map<String, List> ans = new HashMap<String, List>();
		int[] count = new int[26];
		for (String s : strs) {
			Arrays.fill(count, 0);
			for (char c : s.toCharArray()) count[c - 'a']++;

			StringBuilder sb = new StringBuilder("");
			for (int i = 0; i < 26; i++) {
				sb.append('#');
				sb.append(count[i]);
			}
			String key = sb.toString();
			if (!ans.containsKey(key)) ans.put(key, new ArrayList());
			ans.get(key).add(s);
		}
		return new ArrayList(ans.values());
	}


	public String getAnagramKeyUnicode( String s )
	{
		Map<Character, Integer> histogram = new HashMap<>();
		for ( char ch : s.toCharArray() )
		{
			histogram.put( ch, histogram.getOrDefault( ch, 0) + 1 );
		}
		StringBuilder result = new StringBuilder();
		for ( char i = Character.MIN_VALUE; i <= Character.MAX_VALUE; i++ )
		{
			if ( histogram.containsKey( i ) )
			{
				result.append( i );
				result.append( histogram.get( i ) );
			}
		}
		return result.toString();
	}

	@Test
	public void test()
	{
		System.out.println( groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}) );
	}
}
