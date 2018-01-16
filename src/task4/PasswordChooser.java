package task4;

import java.util.*;

public class PasswordChooser {
	private Map<String, Integer> map = new HashMap<>();

	public void addPassword(String password) {
		if (password != null) {
			if (map.get(password) != null) {
				map.replace(password, map.get(password) + 1);
			} else {
				map.put(password, 1);
			}
		}
	}

	public List<String> getTop10Pwd() {
		int i = 0;
		Set<Map.Entry<String, Integer>> set = new TreeSet<>((o1, o2) -> {
			int equality = o2.getValue().compareTo(o1.getValue());
			return equality != 0 ? equality : 1;
		});
		set.addAll(map.entrySet());

		List<String> passwords = new ArrayList<>();
		for (Map.Entry<String, Integer> item: set) {
			passwords.add(item.getKey());
			i++;
			if (i > 10) {
				break;
			}
		}
		return passwords;
	}
}
