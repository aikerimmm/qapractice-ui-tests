package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.EcommercePage;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Epic("QA Practice")
@Feature("E-commerce")
public class EcommerceTests extends BaseTest {

    private final EcommercePage ecommercePage = new EcommercePage();

    @Test
    @Story("Shopping cart")
    @Owner("Aikerim")
    @Severity(CRITICAL)
    @DisplayName("Search and add product to cart")
    void searchAndAddProductToCartTest() {
        ecommercePage
                .openPage()
                .searchProduct("Wireless Mouse")
                .verifyProductDisplayed("Wireless Mouse")
                .addProductToCart("Wireless Mouse")
                .openCart()
                .verifyProductInCart("Wireless Mouse");
    }
}