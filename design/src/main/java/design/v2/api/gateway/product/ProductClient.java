package design.v2.api.gateway.product;

import design.v2.api.gateway.Client;
import design.v2.api.gateway.Request;
import design.v2.api.gateway.Response;

/**
 * @author: cg1
 * @date: 2022-10-05 02:22
 **/
public interface ProductClient<R extends Request, T extends Response> extends Client<R, T> {
    /**
     * 获取product
     *
     * @param r
     * @return
     */
    T getProduct(R r);
}
