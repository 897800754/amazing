package design.v2.architectural.api.gateway;

import design.v2.architectural.api.gateway.image.ImageClient;
import design.v2.architectural.api.gateway.image.ImageRequest;
import design.v2.architectural.api.gateway.product.ProductClient;
import design.v2.architectural.api.gateway.product.ProductRequest;

/**
 * @author: cg1
 * @date: 2022-10-05 02:23
 **/
public class ApiGateway {

    private final ImageClient imageClient;

    private final ProductClient productClient;

    public ApiGateway(ImageClient imageClient, ProductClient productClient) {
        this.imageClient = imageClient;
        this.productClient = productClient;
    }


    public Object getDesktopProduct() {

        Response image = imageClient.getImage(new ImageRequest());

        Response product = productClient.getProduct(new ProductRequest());

        return combo(image, product);

    }

    private Object combo(Response image, Response product) {
        return "success merge image & product";
    }


}
