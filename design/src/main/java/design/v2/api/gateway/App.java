package design.v2.api.gateway;

import design.v2.api.gateway.image.ImageClientImpl;
import design.v2.api.gateway.product.ProductClientImpl;

/**
 * @author: cg1
 * @date: 2022-10-05 02:42
 **/
public class App {

    public static void main(String[] args) {
        ImageClientImpl imageClient = new ImageClientImpl();

        ProductClientImpl productClient = new ProductClientImpl();

        ApiGateway apiGateway = new ApiGateway(imageClient, productClient);

        Object desktopProduct = apiGateway.getDesktopProduct();

        System.out.println(desktopProduct);


    }
}
