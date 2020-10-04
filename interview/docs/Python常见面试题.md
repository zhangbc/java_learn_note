# Python常见面试题

#### 1，`python` 协程

由于 `GIL` 的存在，导致 `Python` 多线程性能甚至比单线程更糟。

> `GIL`：全局解释器锁（`Global Interpreter Lock`，缩写 `GIL`），是计算机程序设计语言解释器用于同步线程的一种机制，它使得任何时刻仅有一个线程在执行。即便在多核心处理器上，使用 `GIL` 的解释器也只允许同一时间执行一个线程。

> **协程**：又称微线程，纤程（Coroutine），作用是在执行函数 `A` 时，可以随时中断，去执行函数 `B`，然后中断继续执行函数 `A`（可以自由切换）。但这一过程并不是函数调用（没有调用语句），这一整个过程看似像多线程，然而协程只有一个线程执行。

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
> `Python3.5` 中引入 `async`/`await` 语法，参见[PEP492](https://www.python.org/dev/peps/pep-0492/) 。
>
> > `async`/`await` 实际上只是`@asyncio.coroutine`和`yield from`的语法糖：
> >
> > > 把`@asyncio.coroutine`替换为`async`；
> > >
> > > 把`yield from`替换为 `await` 即可。
>
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



#### 参考文献

- [理解Python的协程(Coroutine)](https://juejin.im/post/6844903737257885704)