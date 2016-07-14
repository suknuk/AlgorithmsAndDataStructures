package hashMap;


public class test {

	public static void main(String[] args) {
		HashMap table = new HashMap();
		String e1 = "hello";
		String e2 = "my";
		String e3 = "dear";
		table.put(e1.hashCode(), e1);
		table.put(e2.hashCode(), e2);
		table.put(e3.hashCode(), e3);
		
		String e22 = "double";
		int e22_key = 44;
		
		table.put(e22_key, e22);
		
		System.out.println(table.get(e2.hashCode()));
		System.out.println(table.get(e22_key));
	}

}
