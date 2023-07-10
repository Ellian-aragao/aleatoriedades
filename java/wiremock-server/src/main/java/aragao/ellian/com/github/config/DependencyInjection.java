package aragao.ellian.com.github.config;

import com.google.inject.Guice;
import com.google.inject.Injector;

public abstract class DependencyInjection {
    public static final Injector injector;

    static  {
        injector = Guice.createInjector();
    }

    public static <T> T getInstanceOf(Class<T> clazz) {
        return injector.getInstance(clazz);
    }
}
