package com.instance;

import java.util.*;

/**
 * Java集合
 * @author zhangbocheng
 * @version 1.0
 * @date 2019/3/14 16:32
 */
public class CollectionInstance {
    public static void main(String[] args) {
        System.out.println("Java集合实例！");
    }
}


/**
 * 数组转集合：
 * 使用Java Util类的Arrays.asList(name)方法将数组转换为集合.
 */
class ArrayToCollection {
    public static void main(String[] args) {
        int size = 5;
        String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            names[i] = String.valueOf(i);
        }

        List<String> list = Arrays.asList(names);
        System.out.println("数组转集合为：");
        for (String item: list) {
            System.out.print(item + " ");
        }
    }
}


/**
 * 集合比较：
 * 使用Collection类的Collection.min()和Collection.max()来比较集合中的元素.
 */
class CollectionCompare {
    public static void main(String[] args) {
        String[] coins = {"Penny", "nickel", "dime", "Quarter", "dollar"};
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < coins.length; i++) {
            set.add(coins[i]);
        }

        System.out.println("最小元素为（区分大小写）：" + Collections.min(set));
        System.out.println("最小元素为：" + Collections.min(set, String.CASE_INSENSITIVE_ORDER));
        System.out.println("=================================================");
        System.out.println("最大元素为（区分大小写）：" + Collections.max(set));
        System.out.println("最大元素为：" + Collections.max(set, String.CASE_INSENSITIVE_ORDER));
    }
}


/**
 * HashMap遍历：
 * 使用Collection类的iterator()方法来遍历集合.
 */
class HashMapErgodic {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("one", "first");
        hashMap.put("two", "second");
        hashMap.put("three", "third");
        Collection cl = hashMap.values();
        Iterator iters = cl.iterator();

        System.out.println("HashMap遍历：");
        while (iters.hasNext()) {
            System.out.print(iters.next() + " ");
        }
    }
}


/**
 * 集合长度：
 * 使用Collections类的collection.add()来添加数据并使用collection.size()来计算集合的长度.
 */
 class CollectionLength {
     public static void main(String[] args) {
         System.out.println("集合实例！");
         int size;
         HashSet collection = new HashSet();
         String[] strArray = {"Yellow", "White", "Green", "Blue"};
         Iterator iterator;
         for (String str: strArray) {
          collection.add(str);
         }

         System.out.print("集合数据：");
         iterator = collection.iterator();
         while (iterator.hasNext()) {
             System.out.print(iterator.next() + " ");
         }

         size = collection.size();
         if (collection.isEmpty()) {
             System.out.print("\n集合是空的！");
         } else {
             System.out.print("\n集合长度：" + size);
         }
     }
 }


/**
 * 集合打乱顺序：
 * 使用Collections类Collections.shuffle()方法来打乱集合元素的顺序.
 */
class CollectionDisorder {
     public static void main(String[] args) {
         List<Integer> list = new ArrayList<>();
         int size = 10;
         for (int i = 0; i < size; i++) {
             list.add(i);
         }
         System.out.println("集合顺序打乱前：" + list);

         for (int i = 1; i <= size / 2; i++) {
             System.out.println("第" + i + "次打乱：");
             Collections.shuffle(list);
             System.out.println(list);
         }
     }
 }


/**
 * 集合遍历
 */
class CollectionErgodic {
     public static void main(String[] args) {
         // Set集合的遍历
         setErgodic();
         // List集合的遍历
         listErgodic();
     }

     private static void setErgodic() {
         Set<String> set = new HashSet<>();
         set.add("JAVA");
         set.add("C");
         set.add("C++");
         set.add("JAVASCRIPT");
         // 重复元素添加失败
         set.add("JAVA");

         Iterator<String> it = set.iterator();
         // 使用iterator遍历set集合
         System.out.println("使用iterator遍历set集合：");
         while (it.hasNext()) {
             String value = it.next();
             System.out.print(value + " ");
         }

         // 使用增强for循环遍历set集合
         System.out.println("\n使用增强for循环遍历set集合：");
         for (String str: set) {
             System.out.print(str + " ");
         }
     }

     private static void listErgodic() {
         List<String> list = new ArrayList<>();
         list.add("菜");
         list.add("鸟");
         list.add("教");
         list.add("程");
         list.add("www.runoob.com");

         Iterator<String> it = list.iterator();
         // 使用iterator遍历list集合
         System.out.println("\n使用iterator遍历list集合：");
         while (it.hasNext()) {
             String value = it.next();
             System.out.print(value + " ");
         }

         // 使用增强for循环遍历list集合
         System.out.println("\n使用for循环遍历list集合：");
         for (int i = 0; i < list.size(); i++) {
             System.out.print(list.get(i) + " ");
         }

         // 使用增强for循环遍历list集合
         System.out.println("\n使用增强for循环遍历list集合：");
         for (String str: list) {
             System.out.print(str + " ");
         }
     }
 }


/**
 * 集合反转：
 * 使用Collection和ListIterator类的listIterator()
 * 和collection.reverse()方法来反转集合中的元素.
 */
class CollectionReverse {
     public static void main(String[] args) {
         String[] coins = {"A", "B", "C", "D", "E"};
         List list = new ArrayList();
         for (int i = 0; i < coins.length; i++) {
             list.add(coins[i]);
         }

         ListIterator liter = list.listIterator();
         System.out.println("集合反转前：");
         while (liter.hasNext()) {
             System.out.print(liter.next() + " ");
         }

         Collections.reverse(list);
         liter = list.listIterator();
         System.out.println("\n集合反转后：");
         while (liter.hasNext()) {
             System.out.print(liter.next() + " ");
         }
     }
 }


/**
 * 删除集合中指定元素：
 * 使用Collection类的collection.remove()方法来删除集合中的指定的元素.
 */
class CollectionDelete {
     public static void main(String[] args) {
         HashSet collection = new HashSet();
         String[] strArray = {"Yellow", "White", "Green", "Blue"};
         Iterator iterator;
         for (String str: strArray) {
             collection.add(str);
         }

         System.out.print("删除前，集合数据：");
         iterator = collection.iterator();
         while (iterator.hasNext()) {
             System.out.print(iterator.next() + " ");
         }

         collection.remove("Yellow");
         System.out.println("\n删除[Yellow]之后...");
         System.out.print("\n删除后，集合数据：");
         iterator = collection.iterator();
         while (iterator.hasNext()) {
             System.out.print(iterator.next() + " ");
         }

         System.out.println("\n集合大小：" + collection.size());
     }
 }


/**
 * 只读集合：
 * 使用Collection类的Collections.unmodifiableList()方法来设置集合为只读.
 */
class CollectionReadOnly {
    public static void main(String[] args) {
        List stuff = Arrays.asList(new String[]{"a", "b"});
        List list = new ArrayList(stuff);
        list = Collections.unmodifiableList(list);
        try {
            list.set(0, "new value");
        } catch (UnsupportedOperationException ue) {
            // ue.printStackTrace();
            System.out.println("集合为只读模式，不可修改！");
        }

        Set set = new HashSet(stuff);
        set = Collections.unmodifiableSet(set);
        // set.add("A");

        Map map = new HashMap();
        map = Collections.unmodifiableMap(map);
        // map.put(3, "A");
        System.out.println("集合现在已设置为只读模式！");
    }
 }


/**
 * 集合输出：
 * 使用Java Util类的tMap.keySet(),tMap.values()和tMap.firstKey()方法将集合元素输出.
 */
class CollectionOutput {
    public static void main(String[] args) {
        System.out.println("TreeMap实例！");
        TreeMap tMap = new TreeMap();
        tMap.put(1, "Sunday");
        tMap.put(2, "Monday");
        tMap.put(3, "Tuesday");
        tMap.put(4, "Wednesday");
        tMap.put(5, "Thursday");
        tMap.put(6, "Friday");
        tMap.put(7, "Saturday");

        System.out.printf("TreeMap键：%s\n", tMap.keySet());
        System.out.printf("TreeMap值：%s\n\n", tMap.values());

        System.out.printf("TreeMap键为5的值是：%s\n", tMap.get(5));
        System.out.printf("TreeMap第一个键是：%s，值是：%s\n",
                tMap.firstKey(), tMap.get(tMap.firstKey()));
        System.out.printf("TreeMap最后一个键是：%s，值是：%s\n",
                tMap.lastKey(), tMap.get(tMap.lastKey()));

        System.out.printf("TreeMap移除第一个数据：%s\n",
                tMap.remove(tMap.firstKey()));
        System.out.printf("TreeMap移除最后一个数据：%s\n",
                tMap.remove(tMap.lastKey()));

        System.out.printf("现在TreeMap键：%s\n", tMap.keySet());
        System.out.printf("现在TreeMap值：%s", tMap.values());
    }
}


/**
 * 集合转数组：
 * 使用Java Util类的list.add()和list.toArray()方法将集合转为数组.
 */
class CollectionToArray {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("菜");
        list.add("鸟");
        list.add("教");
        list.add("程");
        list.add("www.runoob.com");

        String[] strArray = list.toArray(new String[0]);
        for (int i = 0; i < strArray.length; i++) {
            System.out.print(strArray[i] + " ");
        }
    }
}


/**
 * List循环移动元素：
 * 使用Collections类的rotate()来循环移动元素，
 * 方法第二个参数指定了移动的起始位置.
 */
class ListMoveLoop {
    public static void main(String[] args) {
        List list = Arrays.asList("one two three four five six".split(" "));
        System.out.println("List：" + list);
        Collections.rotate(list, 3);
        System.out.println("Rotate：" + list);
    }
}


/**
 * 查找List中的最大最小值：
 * 使用Collections类的max()和min()方法来获取List中最大最小值.
 */
class ListMaxMinItem {
    public static void main(String[] args) {
        List list = Arrays.asList("one two three four five six".split(" "));
        System.out.println("List" + list + "最大值为：" + Collections.max(list));
        System.out.println("List" + list + "最小值为：" + Collections.min(list));
    }
}


/**
 * 遍历HashTable的键值：
 * 使用Hashtable类的keys()方法来遍历输出键值.
 */
class HashTableErgodic {
    public static void main(String[] args) {
        Hashtable ht = new Hashtable();
        ht.put("1", "One");
        ht.put("2", "Two");
        ht.put("3", "Three");

        Enumeration enums = ht.keys();
        System.out.println("遍历HashTable的键值：");
        while (enums.hasMoreElements()) {
            System.out.print(enums.nextElement() + " ");
        }
    }
}


/**
 * 使用Enumeration遍历HashTable：
 * 使用Enumeration类的hasMoreElements和nextElement方法来遍历输出HashTable中的内容.
 */
class HashTableErgodicByEnum {
    public static void main(String[] args) {
        Hashtable ht = new Hashtable();
        ht.put("1", "One");
        ht.put("2", "Two");
        ht.put("3", "Three");

        Enumeration enums = ht.elements();
        System.out.println("使用Enumeration遍历HashTable：");
        while (enums.hasMoreElements()) {
            System.out.print(enums.nextElement() + " ");
        }
    }
}


/**
 * 集合中添加不同类型元素
 */
class CollectionAddItem {
    public static void main(String[] args) {
        List lnkList = new LinkedList();
        lnkList.add("element1");
        lnkList.add("element2");
        lnkList.add("element3");
        lnkList.add("element4");
        displayAll("LinkedList遍历: ", lnkList);

        List arrayList = new ArrayList();
        arrayList.add("X");
        arrayList.add("Y");
        arrayList.add("Z");
        arrayList.add("W");
        displayAll("ArrayList遍历: ", arrayList);

        Set hashSet = new HashSet();
        hashSet.add("set1");
        hashSet.add("set2");
        hashSet.add("set3");
        hashSet.add("set4");
        displayAll("HashSet遍历: ", hashSet);

        SortedSet treeSet = new TreeSet();
        treeSet.add("treeSet1");
        treeSet.add("treeSet2");
        treeSet.add("treeSet3");
        treeSet.add("treeSet4");
        displayAll("TreeSet遍历: ", treeSet);

        LinkedHashSet lnkHashSet = new LinkedHashSet();
        lnkHashSet.add("one");
        lnkHashSet.add("two");
        lnkHashSet.add("three");
        lnkHashSet.add("four");
        displayAll("LinkedHashSet遍历: ", lnkHashSet);

        Map map = new HashMap();
        map.put("key1", "J");
        map.put("key2", "K");
        map.put("key3", "L");
        map.put("key4", "M");
        displayAll("Map的键遍历: ", map.keySet());
        displayAll("Map的值遍历: ", map.values());

        SortedMap sortedMap = new TreeMap();
        sortedMap.put("key1", "JS");
        sortedMap.put("key2", "KS");
        sortedMap.put("key3", "LS");
        sortedMap.put("key4", "MS");
        displayAll("TreeMap的键遍历: ", sortedMap.keySet());
        displayAll("TreeMap的值遍历: ", sortedMap.values());

        LinkedHashMap lnkHashMap = new LinkedHashMap();
        lnkHashMap.put("key1", "JL");
        lnkHashMap.put("key2", "KL");
        lnkHashMap.put("key3", "LL");
        lnkHashMap.put("key4", "ML");
        displayAll("LinkedHashMap的键遍历: ", lnkHashMap.keySet());
        displayAll("LinkedHashMap的值遍历: ", lnkHashMap.values());
    }

    static void displayAll(String msg, Collection collection) {
        System.out.println(msg);
        Iterator its = collection.iterator();
        while (its.hasNext()) {
            System.out.print(its.next() + " ");
        }
        System.out.println();
    }
}


/**
 * List元素替换：
 * 使用Collections类的replaceAll()来替换List中所有的指定元素.
 */
class ListReplaceItem {
    public static void main(String[] args) {
        List list = Arrays.asList("one two three four five six one".split(" "));
        System.out.println("List：" + list);
        Collections.replaceAll(list, "one", "hundrea");
        System.out.println("replaceAll：" + list);
    }
}


/**
 * List元素截取：
 * 使用Collections类的indexOfSubList()和lastIndexOfSubList()方法来查看子列表是否在列表中，
 * 并查看子列表在列表中所在的位置.
 */
class ListSubList {
    public static void main(String[] args) {
        List list = Arrays.asList("one two three four five six one three four".split(" "));
        System.out.println("List：" + list);
        List subList = Arrays.asList("three four".split(" "));
        System.out.println("子列表：" + subList);
        System.out.println("indexOfSubList：" +
                Collections.indexOfSubList(list, subList));
        System.out.println("lastIndexOfSubList：" +
                Collections.lastIndexOfSubList(list, subList));
    }
}
