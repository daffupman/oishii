package io.daff.oishii.common.context;



import io.daff.web.entity.R;

import java.io.Serializable;

/**
 * @author daffupman
 * @since 2021/4/2
 */
@SuppressWarnings("rawtypes")
public class ApiBodyContext implements Serializable {

    private static final ThreadLocal<R> apiBodyThreadLocal = new ThreadLocal<>();

    public static R get() {
        return apiBodyThreadLocal.get();
    }

    public static void set(R apiBody) {
        apiBodyThreadLocal.set(apiBody);
    }

    public static void remove() {
        apiBodyThreadLocal.remove();
    }
}
