//这只是一个 通过代理生成器生成的一个代理类 Demo 
//仅供参考
//生成的代理类继承自Proxy类  实现接口为被代理类的全部接口
public final class ProxySubject extends Proxy implements Subject
{
  //将被代理类 所有的方法生成为静态方法变量
  private static Method m1;
  private static Method m3;
  private static Method m4;
  private static Method m2;
  private static Method m0;
  
  //生成一个构造方法 可以接收 InvocationHandler 
  public ProxySubject(InvocationHandler paramInvocationHandler)
  {
    super(paramInvocationHandler);
  }

  // 因为这个是代理类 所以被代理类所拥有的方法 代理类全部 拥有  包括Object 的自有方法
  public final boolean equals(Object paramObject){
    try
    {
    // 因为 通过构造方法 生成的代理类，所以  其代理类 拥有 InvocationHandler接口的invoke方法 
    // h 就是代表InvocationHandler 属性   .invoke就是调用 h属性的invoke方法
    //往invoke方法中传入当前代理类对象，equals方法，方法的属性，取到返回值
      return ((Boolean)this.h.invoke(this, m1, new Object[] { paramObject })).booleanValue();
    }
    catch (Error|RuntimeException localError)
    {
      throw localError;
    }
    catch (Throwable localThrowable)
    {
      throw new UndeclaredThrowableException(localThrowable);
    }
  }
  
  public final String SayGoodBye()
  {
    try
    {
      return (String)this.h.invoke(this, m3, null);
    }
    catch (Error|RuntimeException localError)
    {
      throw localError;
    }
    catch (Throwable localThrowable)
    {
      throw new UndeclaredThrowableException(localThrowable);
    }
  }
  
  public final String SayHello(String paramString)
  {
    try
    {
      return (String)this.h.invoke(this, m4, new Object[] { paramString });
    }
    catch (Error|RuntimeException localError)
    {
      throw localError;
    }
    catch (Throwable localThrowable)
    {
      throw new UndeclaredThrowableException(localThrowable);
    }
  }
  
  public final String toString()
  {
    try
    {
      return (String)this.h.invoke(this, m2, null);
    }
    catch (Error|RuntimeException localError)
    {
      throw localError;
    }
    catch (Throwable localThrowable)
    {
      throw new UndeclaredThrowableException(localThrowable);
    }
  }
  
  public final int hashCode()
  {
    try
    {
      return ((Integer)this.h.invoke(this, m0, null)).intValue();
    }
    catch (Error|RuntimeException localError)
    {
      throw localError;
    }
    catch (Throwable localThrowable)
    {
      throw new UndeclaredThrowableException(localThrowable);
    }
  }
  //初始化静态代码块，在该类被加载时 给静态属性赋值
  static
  {
    try
    {
      m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[] { Class.forName("java.lang.Object") });
      //通过反射 获取Subject类的SayGoodBye方法  
      m3 = Class.forName("jiankunking.Subject").getMethod("SayGoodBye", new Class[0]);
      m4 = Class.forName("jiankunking.Subject").getMethod("SayHello", new Class[] { Class.forName("java.lang.String") });
      m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
      m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new NoSuchMethodError(localNoSuchMethodException.getMessage());
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
    }
  }
}