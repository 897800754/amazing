package cn.cg.spring.retry.callback;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.listener.RetryListenerSupport;

/**
 * @author: cg
 * @date: 2022-12-29 13:42
 **/
public class DefaultListenerSupport extends RetryListenerSupport {

    /**
     * 任务执行结束时(包含重试)调用，只调用一次
     *
     * @param context
     * @param callback
     * @param throwable
     * @param <T>
     * @param <E>
     */
    @Override
    public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        System.err.println("DefaultListenerSupport.close");
        super.close(context, callback, throwable);
    }

    /**
     * 出现错误时回调,每重试一次调用一次
     *
     * @param context
     * @param callback
     * @param throwable
     * @param <T>
     * @param <E>
     */
    @Override
    public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        System.err.println("DefaultListenerSupport.onError");
        super.onError(context, callback, throwable);
    }

    /**
     * 任务开始执行时调用，只调用一次
     *
     * @param context
     * @param callback
     * @param <T>
     * @param <E>
     * @return
     */
    @Override
    public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
        System.err.println("DefaultListenerSupport.open");
        return super.open(context, callback);
    }
}
