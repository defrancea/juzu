package org.juzu.impl.spi.inject.resolvebeans;

import org.junit.Test;
import org.juzu.impl.spi.inject.AbstractInjectManagerTestCase;
import org.juzu.impl.spi.inject.InjectImplementation;
import org.juzu.impl.utils.Tools;

import java.util.ArrayList;
import java.util.HashSet;

/** @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a> */
public class ResolvableBeansTestCase<B, I> extends AbstractInjectManagerTestCase<B, I>
{

   public ResolvableBeansTestCase(InjectImplementation di)
   {
      super(di);
   }

   @Test
   public void test() throws Exception
   {
      init();
      bootstrap.declareBean(Bean1.class, null, null, null);
      bootstrap.declareBean(Bean2.class, null, null, null);
      boot();

      //
      ArrayList<B> beans = Tools.list(mgr.resolveBeans(AbstractBean.class));
      assertEquals(2, beans.size());
      HashSet<Class<?>> classes = new HashSet<Class<?>>();
      for (B bean : beans)
      {
         I instance = mgr.create(bean);
         Object o = mgr.get(bean, instance);
         classes.add(o.getClass());
      }
      assertEquals(Tools.<Class<?>>set(Bean1.class, Bean2.class), classes);
   }
}
