package design.v2.architectural.api.gateway.image;

import design.v2.architectural.api.gateway.Client;
import design.v2.architectural.api.gateway.Request;
import design.v2.architectural.api.gateway.Response;

/**
 * @author: cg1
 * @date: 2022-10-05 02:22
 **/
public interface ImageClient<T extends Request, R extends Response> extends Client<T, R> {

    /**
     * 获取图片
     *
     * @param t
     * @return
     */
    R getImage(T t);
}
