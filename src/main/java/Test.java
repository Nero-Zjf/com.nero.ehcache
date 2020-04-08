import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class Test {
    public static void main(String[] args) {
        // 1. 创建缓存管理器
        CacheManager cacheManager = CacheManager.create(Test.class.getClassLoader().getResource("ehcache.xml"));

        // 2. 获取缓存对象
        Cache cache = cacheManager.getCache("HelloWorldCache");

        // 3. 创建元素
        Element element = new Element("key1", "value1");

        // 4. 将元素添加到缓存
        cache.put(element);

        // 5. 获取缓存
        Element value = cache.get("key1");
        System.out.println(value);
        System.out.println(value.getObjectValue());

        // 6. 删除元素
        cache.remove("key1");

        Person p1 = new Person("小明", 18, "杭州");
        Element element1 = new Element("xm", p1);
        cache.put(element1);
        Element element2 = cache.get("xm");
        System.out.println(element2.getObjectValue());

        // 打印当前缓存的容量
        System.out.println(cache.getSize());

        // 7. 刷新缓存
        cache.flush();

        // 8. 关闭缓存管理器
        cacheManager.shutdown();
    }
}
