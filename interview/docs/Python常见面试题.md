# Python常见面试题

## `Python` 基础

#### 1，新式类和旧式类（

> - 在 `Python` 里凡是继承了 `object` 的类，都是新式类；
> - `Python3` 里只有新式类；
> - `Python2` 里面继承 `object` 的是新式类，没有写父类的是经典类；
> - 经典类目前在 `Python` 里基本没有应用；
> - 保持 `class` 与 `type` 的统一对新式类的实例执行 `a.__class__` 与 `type(a)` 的结果是一致的，对于旧式类来说不一样；
> - 对于多重继承的属性搜索顺序不一样新式类是采用广度优先搜索，旧式类采用深度优先搜索。

```python
#!/usr/bin/env python
# coding:utf-8


class A:
    def __init__(self):
        pass


if __name__ == '__main__':

    print(type(A))
    print(A.__class__)

# py2.7运行结果：
<type 'classobj'>
Traceback (most recent call last):
  File "/home/projects/demo_django/mysite/int_colde.py", line 13, in <module>
    print(A.__class__)
AttributeError: class A has no attribute '__class__'

# 若继承object（py2.7）
<type 'type'>
<type 'type'>

# py3.7运行结果：  
<class 'type'>
<class 'type'>
```



1）新式类是在创建的时候继承内置 `object` 对象（或者是从内置类型，如 `list,dict` 等），而经典类是直接声明的。新式类是广度优先；旧式类是深度优先。

2）`__new__` 和 `__init__` 的区别：

> ` __new__` 是一个静态方法；而 `__init__` 是一个实例方法；
>
> `__new__` 方法会返回一个创建的实例；而 `__init__` 什么都不返回；
>
> 只有在 `__new__` 返回一个 `cls` 的实例时后面的 `__init__` 才能被调用；
>
> 当创建一个新实例时调用 `__new__`；初始化一个实例时用 `__init__`。

#### 2，单例模式实现的几种方式

1）使用 `__new__` 方法 

```python
class Singleton(object):
    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            orig = super(Singleton, cls)
            cls._instance = orig.__new__(cls, *args, **kwargs)
        
        return cls._instance
    
    
class MyClass(Singleton):
    a = 1
```

2）共享属性： 创建实例时把所有实例的 `__dict__` 指向同一个字典,这样它们具有相同的属性和方法。 

```python
class Singleton(object):
    _state = {}

    def __new__(cls, *args, **kwargs):
        ob = super(Singleton, cls).__new__(cls, *args, **kwargs)
        ob.__dict__ = cls._state
        return ob


class MyClass(Singleton):
    a = 1
```

3）装饰器

```python
def singleton(cls, *args, **kwargs):
    instances = {}

    def getinstance():
        if cls not in instances:
            instances[cls] = cls(*args, **kwargs)
        return instances[cls]
    
    return getinstance

@singleton
class MyClass:
    a = 1
```

   4）`import` 方法： 作为 `python` 的模块是天然的单例模式。

```python
# singleton.py
class Singleton(object):
    def foo(self):
        pass
 
singleton = Singleton()
 
# to use
from singleton import singleton
 
my_singleton.foo()
```

#### 3，Python中变量的作用域？（变量查找顺序)

函数作用域的LEGB顺序

1.什么是LEGB?

L： local 函数内部作用域

E: enclosing 函数内部与内嵌函数之间

G: global 全局作用域

B： build-in 内置作用

python在函数里面的查找分为4种，称之为LEGB，也正是按照这是顺序来查找的









## `Python` 进阶

#### 1，`Python` 协程

由于 `GIL` 的存在，导致 `Python` 多线程性能甚至比单线程更糟。

> `GIL`：全局解释器锁（`Global Interpreter Lock`，缩写 `GIL`），是计算机程序设计语言解释器用于同步线程的一种机制，它使得任何时刻仅有一个线程在执行。即便在多核心处理器上，使用 `GIL` 的解释器也只允许同一时间执行一个线程。

> **协程**：又称微线程，纤程（`Coroutine`），作用是在执行函数 `A` 时，可以随时中断，去执行函数 `B`，然后中断继续执行函数 `A`（可以自由切换）。但这一过程并不是函数调用（没有调用语句），这一整个过程看似像多线程，然而协程只有一个线程执行。

协程由于由程序主动控制切换，没有线程切换的开销，所以执行效率极高。对于 `IO` 密集型任务非常适用，如果是 `cpu` 密集型，推荐 **多进程+协程** 的方式。

`Python` 对协程的支持，是通过 `Generator` 实现的，协程是遵循某些规则的生成器。

- 生成器

```python
#!/usr/bin/env python
# coding:utf-8


"""
生成器示例
@Date:         2020/9/25 16:25 
@Author:       zhangbocheng
@Version:      1.0.0
@Contact:      zhangbocheng189@163.com
@Description:  
"""

def gen():
    print("generator start...")
    n = 1
    while True:
        yield_exp_value = yield n
        print("yield_exp_value = %d" % yield_exp_value)
        n += 1


# 生成器启动或恢复执行一次，将会在yield处暂停。
generator = gen()
print(type(generator))

# 1
# __next__()作用是启动或者恢复generator的执行，相当于send(None)
next_value = generator.__next__()
print("next_value = %d" % next_value)

# 2
# send(value)方法：作用是发送值给yield表达式。启动generator则是调用send(None)
send_value = generator.send(666)
print("send_value = %d" % send_value)


# 消费者/生产者模式
def consumer():
    print("[CONSUMER] start")
    r = 'start'
    while True:
        n = yield r
        if not n:
            print("n is empty")
            continue
        print("[CONSUMER] Consumer is consuming %s" % n)
        r = "200 ok"


def producer(c):
    # 启动generator
    start_value = c.send(None)
    print(start_value)
    n = 0
    while n < 3:
        n += 1
        print("[PRODUCER] Producer is producing %d" % n)
        r = c.send(n)
        print('[PRODUCER] Consumer return: %s' % r)
    # 关闭generator
    c.close()


# 创建生成器
cr = consumer()
# 传入generator
producer(cr)

```

`yield from` 示例：

```python
def gen_children(n):
    """
    子生成器
    :param n:
    :return:
    """

    i = 0
    while i < n:
        yield i
        i += 1


def test_yield_from(n):
    """
    委派生成器
    :param n:
    :return:
    """

    print("test yield_from start...")
    yield from gen_children(n)
    print("test yield_from end.")


for i in test_yield_from(3):
    print(i)
```

- 协程（`Coroutine`）

> `Python3.4` 开始，新增了 `asyncio` 相关的 `API`，语法使用 `@asyncio.coroutine` 和 `yield from` 实现协程；
>
> > 标记了 `@asyncio.coroutine` 装饰器的函数称为 **协程函数**，`iscoroutinefunction()` 方法返回 `True`；
> >
> > 调用协程函数返回的对象称为 **协程对象**，`iscoroutine()` 函数返回 `True`。
>
> `Python3.5` 中引入 `async`/`await` 语法，参见 [PEP492](https://www.python.org/dev/peps/pep-0492/) 。
>
> > `async`/`await` 实际上只是`@asyncio.coroutine`和`yield from`的语法糖：
> >
> > > 把`@asyncio.coroutine`替换为`async`；
> > >
> > > 把`yield from`替换为 `await` 即可。
>

```python
# @asyncio.coroutines 源码
def coroutine(func):
    """Decorator to mark coroutines.

    If the coroutine is not yielded from before it is destroyed,
    an error message is logged.
    """
    if inspect.iscoroutinefunction(func):
        # In Python 3.5 that's all we need to do for coroutines
        # defined with "async def".
        return func

    if inspect.isgeneratorfunction(func):
        coro = func
    else:
        @functools.wraps(func)
        def coro(*args, **kw):
            res = func(*args, **kw)
            if (base_futures.isfuture(res) or inspect.isgenerator(res) or
                    isinstance(res, CoroWrapper)):
                res = yield from res
            else:
                # If 'res' is an awaitable, run it.
                try:
                    await_meth = res.__await__
                except AttributeError:
                    pass
                else:
                    if isinstance(res, collections.abc.Awaitable):
                        res = yield from await_meth()
            return res

    coro = types.coroutine(coro)
    if not _DEBUG:
        wrapper = coro
    else:
        @functools.wraps(func)
        def wrapper(*args, **kwds):
            w = CoroWrapper(coro(*args, **kwds), func=func)
            if w._source_traceback:
                del w._source_traceback[-1]
            # Python < 3.5 does not implement __qualname__
            # on generator objects, so we set it manually.
            # We use getattr as some callables (such as
            # functools.partial may lack __qualname__).
            w.__name__ = getattr(func, '__name__', None)
            w.__qualname__ = getattr(func, '__qualname__', None)
            return w

    wrapper._is_coroutine = _is_coroutine  # For iscoroutinefunction().
    return wrapper

```

协程示例：

```python
#!/usr/bin/env python
# coding:utf-8


import asyncio


@asyncio.coroutine
def compute(x, y):
    """

    :param x:
    :param y:
    :return:
    """

    print("Compute {0} + {1} ...".format(x, y))
    yield from asyncio.sleep(1)
    return x + y


@asyncio.coroutine
def print_compute(x, y):
    """

    :param x:
    :param y:
    :return:
    """

    result = yield from compute(x, y)
    print("{0} + {1} = {2}".format(x, y, result))


loop = asyncio.get_event_loop()
print("Coroutine start...")
loop.run_until_complete(print_compute(1, 2))
print("Coroutine end.")
loop.close()
```

```python
#!/usr/bin/env python
# coding:utf-8


import asyncio


async def compute(x, y):
    """

    :param x:
    :param y:
    :return:
    """

    print("Compute {0} + {1} ...".format(x, y))
    await asyncio.sleep(1)
    return x + y


async def print_compute(x, y):
    """

    :param x:
    :param y:
    :return:
    """

    result = await compute(x, y)
    print("{0} + {1} = {2}".format(x, y, result))


loop = asyncio.get_event_loop()
print("Coroutine start...")
loop.run_until_complete(print_compute(1, 2))
print("Coroutine end.")
loop.close()
```

```python
#!/usr/bin/env python
# coding:utf-8

import asyncio


future = asyncio.Future()


async def cor_1():
    print("Wait one second.")
    await asyncio.sleep(1)
    print("Set result.")
    future.set_result("data")


async def cor_2():
    result = await future
    print(result)


loop = asyncio.get_event_loop()
loop.run_until_complete(asyncio.wait([
    cor_2(),
    cor_1()
]))

loop.close()
```

#### 2，`Python` 性能分析

`Python` 在性能问题上有所有动态解释型高级语言的通病：

> 解释性语言：
>
> > 先编译后解释；
> >
> > 持久化 `pyc` 字节码
>
> `GIL` 锁：
>
> > 一个解释器只有一个线程在执行；
> >
> > 线程安全
>
> 动态语言：
>
> > 内存访问低效；
> >
> > 检查和转换类型耗时；
> >
> > 不必声明类型
>
> 语法高级抽象：
>
> > 数据结构高级；
> >
> > 包容性高；
> >
> > 语法抽象，实现复杂
>

`Python` 内置了丰富的性能分析工具，能够描述程序运行时候的性能，并提供各种统计帮助用户定位程序的性能瓶颈。常见的 `profilers:cProfile`，`profile`，`line_profile`，`pprofile` 以及 `hotshot` 等，当然一些 `IDE` 比如 `pycharm` 中也继承了完善的 `profiling`。

1）利用装饰器实现函数耗时统计打点

> 缺点：**在协程中，更一般地说在生成器函数中**，因为 `yield` 会释放当前线程，耗时统计执行到 `yield` 处就会中断返回，导致统计的失效。

2）函数级性能分析工具 `cprofile`

> （1）针对单个文件的性能分析

```bash
(/anaconda3) ☁  mysite [master] ⚡   python -m cProfile -s tottime int_colde.py 
4
         11 function calls in 0.000 seconds

   Ordered by: internal time

   ncalls  tottime  percall  cumtime  percall filename:lineno(function)
        1    0.000    0.000    0.000    0.000 {built-in method builtins.print}
        1    0.000    0.000    0.000    0.000 int_colde.py:5(longestIncreasingContinuousSubsequence)
        1    0.000    0.000    0.000    0.000 int_colde.py:5(<module>)
        1    0.000    0.000    0.000    0.000 {built-in method builtins.exec}
        4    0.000    0.000    0.000    0.000 {built-in method builtins.max}
        2    0.000    0.000    0.000    0.000 {built-in method builtins.len}
        1    0.000    0.000    0.000    0.000 {method 'disable' of '_lsprof.Profiler' objects}
```

> （2）针对某个方法的性能分析

```python
import cProfile

cProfile.run('longestIncreasingContinuousSubsequence(A)')
```

> （3）项目中针对实时服务的性能分析

```python
 # 一般需要绑定在服务框架的钩子函数中来实现，如下两个方法分别放在入口和出口钩子中；pstats格式化统计信息，并根据需要做排序分析处理。

 def _start_profile(self):
     import cProfile
     self.pr = cProfile.Profile()
     self.pr.enable()
     
 def _print_profile_result(self):
     if not self.pr:
         return
      
     self.pr.disable()
     import pstats
     import StringIO
     s = StringIO.StringIO()
     stats = pstats.Stats(self.pr, stream=s).strip_dirs().sort_stats('tottime')
     stats.print_stats(50)
```

3）行级分析工具 `pprofile/line_profile`

`Python` 优化思路：

> 从服务架构和 `CPU` 效率层面，**将 `CPU` 密集型向 `IO` 密集型优化**。从代码执行和 `CPU` 利用率层面，**要提高代码性能以及多核利用率**。
>
> 代码优化：
>
> > 代码逻辑和算法
> >
> > 数据结构
> >
> > > 使用字典/集合等 `hash` 等数据结构：检索、去重、交集、并集、差集；
> > >
> > > 使用生成器代替可迭代对象；
> > >
> > > 尝试 `pandas` 和 `numpy` 中的数据结构。
> > >
> > > > 一个 `NumPy` 数组基本上是由元数据（维数、形状、数据类型等）和实际数据构成。数据存储在一个均匀连续的内存块中，该内存在系统内存（随机存取存储器，或 `RAM`）的一个特定地址处，被称为 **数据缓冲区**。这是和 `list` 等纯 `Python` 结构的主要区别，`list` 的元素在系统内存中是分散存储的。这是使 `NumPy` 数组如此高效的决定性因素。
> >
> > 减少循环和冗余
> >
> > > i） 在循环中不要做和迭代对象无关的事。将无关代码提到循环上层；
> > > ii） 使用列表解析和生成器表达式；
> > > iii） 对于 `and`，应该把满足条件少的放在前面；对于 `or`，把满足条件多的放在前面；
> > > iv） 迭代器中的字符串操作：是有 `join` 不要使用 `+`；
> > > v） 尽量减少嵌套循环，不要超过三层，否则考虑优化代码逻辑、优化数据格式、使用 `dataframe` 代替循环等方式。
> >
> > 多进程、多线程、协程
> >
> > > 多进程：
> > >
> > > > 多进程 `multiprocessing` 的目的是为了提高多核利用率，适用于 `cpu` 密集的代码。需要注意，`Python` 的普通变量**不是进程安全**的，考虑同步互斥时，要使用共享变量类型；**协程中可以包含多进程，但是多进程中不能包含协程**，因为多进程中协程会在 `yield` 处释放 `cpu` 直接返回，导致该进程无法再恢复。从另一个角度理解，协程本身的特点也是在单进程中实现 `cpu` 调度。
> > > > （1）进程通信、共享变量
> > > >
> > > > > `Python` 多进程提供了基本所有的共享变量类型，常用的包括：共享队列、共享字典、共享列表、简单变量等，因此也提供了锁机制。相关模块：`from multiprocessing import Process,Manager,Queue`
> > > >
> > > > （2）分片与合并
> > > >
> > > > > 多进程在优化 `cpu` 密集的操作时，一般需要将列表、字典等进行分片操作，在多进程里分别处理，再通过共享变量 `merge` 到一起，达到利用多核的目的，注意根据具体逻辑来判断是否需要加锁。
> > >
> > > 多线程：
> > >
> > > > `Python` 多线程一般适用于 `IO` 密集型的代码，`IO` 阻塞可以释放 `GIL` 锁，其他线程可以继续执行，并且线程切换代价要小于进程切换。注意： `Python` 中 `time.sleep()` 可以阻塞进程，但不会阻塞线程。
> > >
> > > 协程：**生成器+调度策略**
> > >
> > > > 协程可以简单地理解为一种特殊的程序调用，特殊的是在执行过程中，在子程序内部可中断，然后转而执行别的子程序，在适当的时候再返回来接着执行。
> >
> > `python3/go` 、高性能第三方库
>
> 架构优化：
>
> > 分布式解藕
> >
> > 并行化/异步化
> >
> > 离线计算
> >
> > `pipeline` 实时计算
> >
> > 缓存
>
> 依赖服务优化：
>
> > `hbase`
> >
> > `mysql`
> >
> > `cassandra`
> >
> > `mongodb`	

建议：

> 合理使用 `copy` 与 `deepcopy`；
>
> 使用 `join` 合并迭代器中的字符串；
>
> 使用最佳的反序列化方式 `json > cPickle > eval`；
>
> 不借助中间变量交换两个变量的值（有循环引用造成内存泄露的风险）；
>
> 不局限于 `Python` 内置函数，一些情况下，内置函数的性能，远远不如自己写的。比如 `Python` 的 `strptime` 方法，会生成一个9位的时间元祖，经常需要根据此元祖计算时间戳，该方法性能很差；
>
> 用生成器改写直接返回列表的复杂函数，用列表推导替代简单函数，但是列表推导不要超过两个表达式。生成器 > 列表推导 > ` map/filter`；
>
> 关键代码可以依赖于高性能的扩展包，因此有时候需要牺牲一些可移植性换取性能； 勇于尝试 `Python` 新版本；
>
> 考虑优化的成本，一般先从数据结构和算法上优化，改善时间/空间复杂度，比如使用集合、分治、贪心、动态规划等，最后再从架构和整体框架上考虑。

`Python` 的高性能服务基本都是 **协程和基于 `epoll` 的事件循环** 实现的 `IO` 多路复用框架。`tornado` 依靠强大的 `ioloop` 事件循环和 `gen` 封装的协程，让我们可以用 `yield` 关键字同步式地写出异步代码。

在 `Python3.5+` 中，`Python` 引入原生的异步网络库 `asyncio`，提供了原生的事件循环**`get_event_loop`** 来支持协程。

在 `tornado6.0` 中，`ioloop` 已经已经实现了对 `asyncio` 事件循环的封装。除了标准库 `asyncio` 的事件循环，社区使用 `Cython` 实现了另外一个事件循环**`uvloop`**。用来取代标准库。

#### 参考文献

- [理解Python的协程(Coroutine)](https://juejin.im/post/6844903737257885704)

- [python性能优化](https://segmentfault.com/a/1190000023923199)