###线程的实现方式

####继承Thread类

1、线程的执行顺序是需要看CPU 的心情，是随机进行执行的。

注意：

  1、如果多次的调用start()的方法，则会出现异常，Excepiton in thread "main" java.lang.IllegalThreadStareExcetion.
  2、执行start()方法的顺序不代表线程启动的顺序。
  
####实现Runnable接口


如果欲创建的线程类已经有一个父类了，这时就不能在继承Thread的类了，所以就要实现Runnable 接口来应对这种情况。











