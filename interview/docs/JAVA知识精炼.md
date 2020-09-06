# JAVA知识汇集

> 学习地址：https://snailclimb.gitee.io/javaguide/#/?id=java
>
> 本文`jdk`版本：`jdk1.8.0_131`

## Java基础

#### 1. Java 和 C++的区别?

- 都是面向对象的语言，都支持封装、继承和多态；

- Java 不提供指针来直接访问内存，程序内存更加安全；
- Java 的类是单继承的，C++ 支持多重继承；虽然 Java 的类不可以多继承，但是接口可以多继承；
- Java 有自动内存管理机制，不需要程序员手动释放无用内存；
- 在 C 语言中，字符串或字符数组最后都会有一个额外的字符‘\0’来表示结束。

#### 2. Java泛型了解么？什么是类型擦除？介绍一下常用的通配符？

Java 泛型（`generics`）是 `JDK 5` 中引入的一个新特性, 泛型提供了编译时类型安全检测机制，该机制允许程序员在编译时检测到非法的类型。泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数。

**Java的泛型是伪泛型，这是因为Java在编译期间，所有的泛型信息都会被擦掉，这也就是通常所说类型擦除 。** 

实例一：原始类型相等

```java
package com.team.algorithm;

import java.util.ArrayList;

/**
 * 类型擦除-原始类型相等
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/6/3 15:02
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<String> listStr = new ArrayList<>();
        ArrayList<Integer> listInt = new ArrayList<>();
        listStr.add("abc");
        listInt.add(123);
        // true
        System.out.println(listStr.getClass() == listInt.getClass());
    }
}

```

实例二：通过反射添加其它类型元素

```java
package com.team.algorithm;

import java.util.ArrayList;

/**
 * 类型擦除-通过反射添加其它类型元素
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/6/3 15:02
 */
public class Test {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.getClass().getMethod("add", Object.class).invoke(integers, "abc");
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }
}
```

**常用的通配符为： T，E，K，V，？**

- `？ 表示不确定的 `java` 类型
- `T (type)` 表示具体的一个 `java` 类型
- `K V (key value)` 分别代表java键值中的 `Key Value`
- `E (element)` 代表 `Element`

#### 3. hashCode()与 equals()

`hashCode()` 的作用是获取哈希码，也称为散列码，实际上是返回一个 `int` 整数，**其作用是确定该对象在哈希表中的索引位置**，大大减少了 `equals` 的次数，相应就大大提高了执行速度。`hashCode()` 定义在 `JDK` 的 `Object` 类中，这就意味着 `Java` 中的任何类都包含有 `hashCode()` 函数。另外需要注意的是： `Object` 的 `hashcode` 方法是本地方法，也就是用 `c` 语言或 `c++` 实现的，该方法通常用来将对象的内存地址转换为整数之后返回。

散列表的**本质**是通过数组实现的。当我们要获取散列表中的某个“值”时，实际上是要获取数组中的某个位置的元素。而数组的位置，就是通过“键”来获取的；更进一步说，数组的位置，是通过“键”对应的散列码计算得到的。

- `hashCode()` 源码：

```java
public native int hashCode();
```

`== `:  **判断两个对象的地址是不是相等**， 即判断两个对象是不是同一个对象。

`equals()` : **判断两个对象是否相等。**但它一般有两种使用情况：

> 1）类没有覆盖 `equals()` 方法。则通过 `equals()` 比较该类的两个对象时，等价于通过“`==`”比较这两个对象；
>
> 2）类覆盖了 `equals()` 方法。通常的做法是：若两个对象的内容相等，则 `equals()` 方法返回 `true`；否则，返回 `fasle`。

- `equals()` 源码：

```java
public boolean equals(Object obj) {
        return (this == obj);
}
```

因为 `hashCode()` 所使用的杂凑算法也许刚好会让多个对象传回相同的杂凑值。越糟糕的杂凑算法越容易碰撞，但这也与数据值域分布的特性有关（所谓**碰撞**也就是指的是不同的对象得到相同的 `hashCode`。

#### 4. 自动装箱与拆箱

- **装箱**：将基本类型用它们对应的引用类型包装起来；
- **拆箱**：将包装类型转换为基本数据类型。

测试代码举例1：

```java
public class Test {
    public static void main(String[] args) {
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        // true
        System.out.println(i1 == i2);  
        // false
        System.out.println(i3 == i4);
        // true
        System.out.println(i1.equals(i2));
        // true
        System.out.println(i3.equals(i4));
    }
}
```

源码解析：

```java
public boolean equals(Object obj) {
        if (obj instanceof Integer) {
            return value == ((Integer)obj).intValue();
        }
        return false;
}
```

```java
private static class IntegerCache {
    static final int low = -128;
    static final int high;
    static final Integer cache[];

    static {
        // high value may be configured by property
        int h = 127;
        String integerCacheHighPropValue =
            sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
        if (integerCacheHighPropValue != null) {
            try {
                int i = parseInt(integerCacheHighPropValue);
                i = Math.max(i, 127);
                // Maximum array size is Integer.MAX_VALUE
                h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
            } catch( NumberFormatException nfe) {
                // If the property cannot be parsed into an int, ignore it.
            }
        }
        high = h;

        cache = new Integer[(high - low) + 1];
        int j = low;
        for(int k = 0; k < cache.length; k++)
            cache[k] = new Integer(j++);

        // range [-128, 127] must be interned (JLS7 5.1.7)
        assert IntegerCache.high >= 127;
    }

    private IntegerCache() {}
}


public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
}
```

测试代码举例2：

```java
public class Test {
    public static void main(String[] args) {
        Double i1 = 100.0;
        Double i2 = 100.0;
        Double i3 = 200.0;
        Double i4 = 200.0;

        // false
        System.out.println(i1 == i2);
        // false
        System.out.println(i3 == i4);
        // true
        System.out.println(i1.equals(i2));
        // true
        System.out.println(i3.equals(i4));
    }
}
```

源码解析：

```java
public static Double valueOf(double d) {
    return new Double(d);
}
```

```java
public boolean equals(Object obj) {
        return (obj instanceof Double)
               && (doubleToLongBits(((Double)obj).value) ==
                      doubleToLongBits(value));
}
```

测试代码举例3：

```java
public class Test {
    public static void main(String[] args) {
        Boolean i1 = false;
        Boolean i2 = false;
        Boolean i3 = true;
        Boolean i4 = true;

        // true
        System.out.println(i1 == i2);
        // true
        System.out.println(i3 == i4);
        // true
        System.out.println(i1.equals(i2));
        // true
        System.out.println(i3.equals(i4));
    }
}
```

源码解析：

```java
public static final Boolean TRUE = new Boolean(true);
public static final Boolean FALSE = new Boolean(false);

public static Boolean valueOf(boolean b) {
        return (b ? TRUE : FALSE);
}
```

```java
public boolean equals(Object obj) {
        if (obj instanceof Boolean) {
            return value == ((Boolean)obj).booleanValue();
        }
        return false;
}
```

**Java 基本类型的包装类的大部分都实现了常量池技术，即 Byte,Short,Integer,Long,Character,Boolean；前面 4 种包装类默认创建了数值[-128，127] 的相应类型的缓存数据，Character创建了数值在[0,127]范围的缓存数据，Boolean 直接返回True Or False。如果超出对应范围仍然会去创建新的对象。**

#### 5. 重载和重写的区别

> 重载：发生在同一个类中，方法名必须相同，参数类型不同、个数不同、顺序不同，方法返回值和访问修饰符可以不同；
>
> 重写：发生在运行期，是子类对父类的允许访问的方法的实现过程进行重新编写。
>
> 1. > 1）返回值类型、方法名、参数列表必须相同，抛出的异常范围小于等于父类，访问修饰符范围大于等于父类；
>    >
>    > 2）如果父类方法访问修饰符为 `private/final/static` 则子类就不能重写该方法，但是被 `static` 修饰的方法能够被再次声明；
>    >
>    > 3）构造方法无法被重写。

| 区别点     | 重载方法 | 重写方法                                       |
| ---------- | -------- | ---------------------------------------------- |
| 发生范围   | 同一个类 | 子类中                                         |
| 参数列表   | 必须修改 | 一定不能修改                                   |
| 返回类型   | 可修改   | 一定不能修改                                   |
| 异常       | 可修改   | 可以减少或删除，一定不能抛出新的或者更广的异常 |
| 访问修饰符 | 可修改   | 一定不能做更严格的限制（可以降低限制）         |
| 发生阶段   | 编译期   | 运行期                                         |

#### 6. String StringBuffer 和 StringBuilder 的区别是什么? String 为什么是不可变的?

`String` 类中使用 final 关键字修饰字符数组来保存字符串，`private final char value[]`，所以`String` 对象是不可变的。

源码如下：

```java
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence {
    /** The value is used for character storage. */
    private final char value[];

    /** Cache the hash code for the string */
    private int hash; // Default to 0
	..........
}
```

而 `StringBuilder` 与 `StringBuffer` 都继承自 `AbstractStringBuilder` 类，在 `AbstractStringBuilder` 中也是使用字符数组保存字符串`char[]value` 但是没有用 `final` 关键字修饰，所以这两种对象都是可变的。

`StringBuilder` 与 `StringBuffer` 的构造方法都是调用父类构造方法也就是`AbstractStringBuilder` 实现的。

源码如下：

```java
abstract class AbstractStringBuilder implements Appendable, CharSequence {
    /**
     * The value is used for character storage.
     */
    char[] value;

    /**
     * The count is the number of characters used.
     */
    int count;
    .............
    /**
     * The maximum size of array to allocate (unless necessary).
     * Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in
     * OutOfMemoryError: Requested array size exceeds VM limit
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    .............
}
```

![StringBuilder](images/java_20200603235613.png)

![StringBuffer](images/java_20200604000905.png)

`String` 中的对象是不可变的，也就可以理解为常量，线程安全。`AbstractStringBuilder` 是 `StringBuilder` 与 `StringBuffer` 的公共父类，定义了一些字符串的基本操作，如 `expandCapacity`、`append`、`insert`、`indexOf` 等公共方法。`StringBuffer` 对方法加了同步锁或者对调用的方法加了同步锁，所以是线程安全的。`StringBuilder` 并没有对方法进行加同步锁，所以是非线程安全的。

相关源码如下：

```java
/**
* A cache of the last value returned by toString. Cleared
* whenever the StringBuffer is modified.
*/
private transient char[] toStringCache;

@Override
public synchronized StringBuffer insert(int offset, Object obj) {
    toStringCache = null;
    super.insert(offset, String.valueOf(obj));
    return this;
}
```

#### 7. 成员变量与局部变量的区别有哪些？

> 1）从**语法形式**上看，成员变量属于类，而局部变量是在方法中定义的变量或是方法的参数；成员变量可以被  `public,private,static` 等修饰符所修饰，而局部变量不能被访问控制修饰符及 `static` 所修饰；但是，成员变量和局部变量都能被 `final` 所修饰；
>
> 2）从变量在内存中的 **存储方式** 来看：如果成员变量是使用 `static` 修饰的，那么这个成员变量属于类，如果没有使用`static`修饰，这个成员变量属于实例。而对象存在于 **堆** 内存，局部变量则存在于 **栈** 内存；
>
> 3）从变量在内存中的 **生存时间** 上看：成员变量是对象的一部分，它随着对象的创建而存在，而局部变量随着方法的调用而自动消失；
>
> 4）成员变量如果没有被赋初值，则会自动以类型的默认值而赋值（一种情况例外：被 `final` 修饰的成员变量也必须显式地赋值），而局部变量则不会自动赋值。

#### 8. final,static,this,super 关键字

`final` 关键字，意思是最终的、不可修改的，最见不得变化，用来修饰类、方法和变量，具有以下特点：

> `final` 修饰的类不能被继承，`final` 类中的所有成员方法都会被隐式的指定为 `final` 方法；
>
> `final` 修饰的方法不能被重写；
>
> `final` 修饰的变量是常量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；如果是引用类型的变量，则在对其初始化之后便不能让其指向另一个对象。

`static` 关键字主要有以下四种使用场景：

> **修饰成员变量和成员方法:** 被 `static` 修饰的成员属于类，不属于单个这个类的某个对象，被类中所有对象共享，可以并且建议通过类名调用。被 `static` 声明的成员变量属于静态成员变量，静态变量存放在 `Java` 内存区域的方法区。调用格式：`类名.静态变量名` `类名.静态方法名()`；
>
> **静态代码块:** 静态代码块定义在类中方法外, 静态代码块在非静态代码块之前执行(静态代码块—>非静态代码块—>构造方法)。 该类不管创建多少对象，静态代码块只执行一次；
>
> **静态内部类（static修饰类的话只能修饰内部类）：** 静态内部类与非静态内部类之间存在一个最大的区别: 非静态内部类在编译完成之后会隐含地保存着一个引用，该引用是指向创建它的外围类，但是静态内部类却没有。没有这个引用就意味着：1. 它的创建是不需要依赖外围类的创建。2. 它不能使用任何外围类的非static成员变量和方法；
>
> **静态导包(用来导入类中的静态资源，1.5之后的新特性):** 格式为：`import static` 这两个关键字连用可以指定导入某个类中的指定静态资源，并且不需要使用类名调用类中静态成员，可以直接使用类中静态成员变量和成员方法。

`this` 关键字用于引用类的当前实例。

`super` 关键字用于从子类访问父类的变量和方法。 

> `this`、`super` 不能用在 `static` 方法中。

#### 9. Object 类

`Object` 类是一个特殊的类，是所有类的父类。它主要提供了以下 11 个方法：

```java
//native方法，用于返回当前运行时对象的Class对象，使用了final关键字修饰，故不允许子类重写。
public final native Class<?> getClass();
//native方法，用于返回对象的哈希码，主要使用在哈希表中，比如JDK中的HashMap。
public native int hashCode();
//用于比较两个个对象的内存地址是否相等，String类对该方法进行了重写用户比较字符串的值是否相等。
public boolean equals(Object obj) {
    return (this == obj);
}
//naitive方法，用于创建并返回当前对象的一份拷贝。一般情况下，对于任何对象 x，表达式 x.clone() != x 为true，x.clone().getClass() == x.getClass() 为true。Object本身没有实现Cloneable接口，所以不重写clone方法并且进行调用的话会发生CloneNotSupportedException异常。
protected native Object clone() throws CloneNotSupportedException;
//返回类的名字@实例的哈希码的16进制的字符串。建议Object所有的子类都重写这个方法。
public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
}
//native方法，并且不能重写。唤醒一个在此对象监视器上等待的线程(监视器相当于就是锁的概念)。如果有多个线程在等待只会任意唤醒一个。
public final native void notify();
//native方法，并且不能重写。跟notify一样，唯一的区别就是会唤醒在此对象监视器上等待的所有线程，而不是一个线程。
public final native void notifyAll();
//native方法，并且不能重写。暂停线程的执行。注意：sleep方法没有释放锁，而wait方法释放了锁 。timeout是等待时间。
public final native void wait(long timeout) throws InterruptedException;
//多了nanos参数，这个参数表示额外时间（以毫微秒为单位，范围是 0-999999）。 所以超时的时间还需要加上nanos毫秒。
public final void wait(long timeout, int nanos) throws InterruptedException {
    if (timeout < 0) {
        throw new IllegalArgumentException("timeout value is negative");
    }

    if (nanos < 0 || nanos > 999999) {
        throw new IllegalArgumentException(
            "nanosecond timeout value out of range");
    }

    if (nanos > 0) {
        timeout++;
    }

    wait(timeout);
}
//跟之前的wait方法一样，只不过该方法一直等待，没有超时时间这个概念
public final void wait() throws InterruptedException {
    wait(0);
}
//实例被垃圾回收器回收的时候触发的操作
protected void finalize() throws Throwable { };
```

#### 10. Java 序列化中如果有些字段不想进行序列化，怎么办？

对于不想进行序列化的变量，使用 `transient` 关键字修饰。

`transient` 关键字的作用是：阻止实例中那些用此关键字修饰的的变量序列化；当对象被反序列化时，被 `transient` 修饰的变量值不会被持久化和恢复。`transient` 只能修饰变量，不能修饰类和方法。

参考：https://baijiahao.baidu.com/s?id=1636557218432721275&wfr=spider&for=pc

演示代码：

```java
package com.team.algorithm;

import java.io.Serializable;

/**
 * transient 关键字
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/6/4 01:02
 */
public class User implements Serializable {
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static final long serialVersionUID = 123456344567L;
    private transient int age;
    private String name;
    
    @Override
    public String toString() {
        return String.format("name=[%s], age=[%d]", name, age);
    }
}
```

```java
package com.team.algorithm;

import java.io.*;

/**
 * transient 关键字
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/6/4 01:09
 */
class UserTest {
    public static void main(String[] args) throws Exception {
        serializeUser();
        deSerializeUser();
    }

    /**
     * 序列化
     * @throws FileNotFoundException FileNotFoundException
     * @throws IOException IOException
     * @throws ClassNotFoundException ClassNotFoundException
     */
    private static void serializeUser() throws IOException, ClassNotFoundException {
        User user = new User();
        user.setName("Json, CEO");
        user.setAge(30);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("template"));
        oos.writeObject(user);
        oos.close();
        System.out.println("Add transient key serialize：" + user.toString());
    }

    /**
     * 反序列化
     * @throws IOException IOException
     * @throws ClassNotFoundException ClassNotFoundException
     */
    private static void deSerializeUser() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("template"));
        User user = (User) ois.readObject();
        System.out.println("Add transient key deserialize：" + user.toString());
    }
} 
```

1）`transient` 底层实现原理是什么？

> `Java` 的 `serialization` 提供了一个非常棒的存储对象状态的机制，即 `serialization` 把对象的状态存储到硬盘上去，等需要的时候就可以再把它读出来使用。如上述示例中，`transient` 修饰的 `age` 字段，他的生命周期仅仅在内存中，不会被写到磁盘中。

2）被 `transient` 关键字修饰过得变量真的不能被序列化？

`Java` 序列化提供两种方式：

> （1）实现 `Serializable` 接口
>
> （2）实现 `Exteranlizable` 接口，需要重写 `writeExternal` 和 `readExternal` 方法，它的效率比 `Serializable` 高一些，并且可以决定哪些属性需要序列化（即使被 `transient` 修饰），但是对大量对象，或者重复对象，则效率低。

演示代码：

```java
package com.team.algorithm;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Externalizable 关键字
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/6/4 21:53
 */
public class UserExternal implements Externalizable {
    private transient String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
    }
    
    @Override
    public String toString() {
        return String.format("name=[%s]", name);
    }
}
```

```java
package com.team.algorithm;

import java.io.*;

/**
 * Externalizable 关键字
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/6/4 21:56
 */
class UserExternalTest {
    public static void main(String[] args) throws Exception {
        serializeUser();
        deSerializeUser();
    }

    /**
     * 序列化
     * @throws FileNotFoundException FileNotFoundException
     * @throws IOException IOException
     * @throws ClassNotFoundException ClassNotFoundException
     */
    private static void serializeUser() throws IOException, ClassNotFoundException {
        UserExternal user = new UserExternal();
        user.setName("Json, CEO");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("template"));
        oos.writeObject(user);
        oos.close();
        System.out.println("Add Externalizable key serialize：" + user.toString());
    }

    /**
     * 反序列化
     * @throws IOException IOException
     * @throws ClassNotFoundException ClassNotFoundException
     */
    private static void deSerializeUser() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("template"));
        UserExternal user = (UserExternal) ois.readObject();
        System.out.println("Add Externalizable key deserialize：" + user.toString());
    }
}
```

3）静态变量能被序列化吗？没被 `transient` 关键字修饰之后呢？

静态变量是不会被序列化的，即使没有 `transient` 关键字修饰。

#### 11. Java 异常类层次结构图

![Java 异常类层次结构图](images/java_20200605163431.png)

面对必须要关闭的资源，我们总是应该优先使用 `try-with-resources` 而不是`try-finally`。随之产生的代码更简短，更清晰，产生的异常对我们也更有用。

#### 12. 有哪些集合是线程不安全的？怎么解决呢？

我们常用的 `Arraylist` ,`LinkedList`,`Hashmap`,`HashSet`,`TreeSet`,`TreeMap`，`PriorityQueue` 都不是线程安全的。解决办法很简单，可以使用线程安全的集合来代替。

如果要使用线程安全的集合的话， `java.util.concurrent` 包中提供了很多并发容器供你使用：

> `ConcurrentHashMap`：可以看作是线程安全的 `HashMap`；
>
> `CopyOnWriteArrayList`：可以看作是线程安全的 `ArrayList`，在读多写少的场合性能非常好，远远好于 `Vector`；
>
> `ConcurrentLinkedQueue`：高效的并发队列，使用链表实现。可以看做一个线程安全的 `LinkedList`，这是一个非阻塞队列；
>
> `BlockingQueue`：这是一个接口，JDK 内部通过链表、数组等方式实现了这个接口。表示阻塞队列，非常适合用于作为数据共享的通道；
>
> `ConcurrentSkipListMap` ：跳表的实现。这是一个`Map`，使用跳表的数据结构进行快速查找。

## JAVA面试知识点整理

#### 1，关于 `Object o = new Object()`

> 1）请解释一下对象的创建过程？（半初始化）
>
> 2）DCL与volatile问题？（指令重排）
>
> 3）对象在内存中的存储布局？（对象与数组的存储不同）
>
> 4）对象头具体包括什么？（markword klasspointer）
>
> ​	 synchronized锁信息
>
> 5）对象怎么定位？（直接/间接）
>
> 6）对象怎么分配？（栈上-线程本地-Eden-old）
>
> 7） `Object o = new Object()` 在内存中占用多少字节？
>
> 8）class对象是在堆还是方法区？

- 几种反编译文件的方式

方法一：命令行

```java
☁  leetcode_zh [master] ⚡  javap -c target.classes.com.team.offer.NewObject
警告: 文件 ./target/classes/com/team/offer/NewObject.class 不包含类 target.classes.com.team.offer.NewObject
Compiled from "NewObject.java"
public class com.team.offer.NewObject {
  public com.team.offer.NewObject();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: new           #2                  // class java/lang/Object
       3: dup
       4: invokespecial #1                  // Method java/lang/Object."<init>":()V
       7: astore_1
       8: ldc           #3                  // String 张三
      10: astore_2
      11: ldc           #4                  // String 李四
      13: astore_2
      14: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
      17: aload_2
      18: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      21: return
}
```

方法二：字节码分析插件 —> `jclasslib Bytecode viewer`

![jclasslib](images/java_20200719010457.png)

关于`Object o = new Object()` 字节码如下：

```java
0 new #2 <java/lang/Object>
3 dup
4 invokespecial #1 <java/lang/Object.<init>>
7 astore_1
8 return
```

对象创建过程举例分析：

![对象创建过程举例](images/java_20200719014741.png)

`volatile` 基本作用：

> 1）保证此变量对所有的线程的可见性，即当一个线程修改了这个变量的值，`volatile` 保证了新值能立即同步到主内存，以及每次使用前立即从主内存刷新；
>
> 2）禁止指令重排序优化。有`volatile`修饰的变量，赋值后多执行了一个“`load addl $0x0, (%esp)`”操作，这个操作相当于一个**内存屏障**（指令重排序时不能把后面的指令重排序到内存屏障之前的位置），只有一个`CPU`访问内存时，并不需要内存屏障；（指令重排序是指CPU采用了允许将多条指令不按程序规定的顺序分开发送给各相应电路单元处理）。

## 参考文献

- [你还在为怎么查看字节码指令而担忧吗？](https://blog.csdn.net/u010979642/article/details/106055368)