package ma.octo.context.support;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

public class ThreadScope implements Scope {
  private static final ThreadLocal<Map<String, Object>> threadLocal = ThreadLocal.withInitial(HashMap::new);

  @Override
  public Object get(final String name, final ObjectFactory<?> objectFactory) {
    final Map<String, Object> threadObjects = getThreadObjects();
    threadObjects.computeIfAbsent(name, key -> objectFactory.getObject());
    return threadObjects.get(name);
  }

  @Override
  public Object remove(final String name) {
    final Map<String, Object> threadObjects = getThreadObjects();
    return threadObjects.remove(name);
  }

  @Override
  public void registerDestructionCallback(final String s, final Runnable runnable) {
  }

  @Override
  public Object resolveContextualObject(final String s) {
    return null;
  }

  @Override
  public String getConversationId() {
    return "thread";
  }
  
  private Map<String, Object> getThreadObjects() {
    return threadLocal.get();
  }
}
