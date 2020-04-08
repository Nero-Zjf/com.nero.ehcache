import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class PersistentTest {
    public static void main(String[] args) {
        // 1. 创建缓存管理器
        CacheManager cacheManager = CacheManager.create(Test.class.getClassLoader().getResource("ehcache.xml"));

        // 2. 获取缓存对象
        Cache cache = cacheManager.getCache("PersistentCache");
        // 如果第一次运行打印0，第二运行打印2表示持久化成功。
        System.out.println("当前缓存的容量："+cache.getSize());

        cache.put(new Element("k1", "value1"));
        cache.put(new Element("k2", "value2"));

        // 7. 刷新缓存
        cache.flush();

        // 8. 关闭缓存管理器
        cacheManager.shutdown();
    }
}
