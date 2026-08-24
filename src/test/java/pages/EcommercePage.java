package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class EcommercePage {

    private final SelenideElement searchInput = $("[data-testid='ecom-search']");
    private final SelenideElement cartButton = $("[data-testid='ecom-cart-button']");

    @Step("Open E-commerce page")
    public EcommercePage openPage() {
        open("/practice-ecommerece-website");

        searchInput.shouldBe(visible);

        return this;
    }

    @Step("Search product: {productName}")
    public EcommercePage searchProduct(String productName) {
        searchInput
                .shouldBe(visible)
                .setValue(productName);

        return this;
    }

    @Step("Verify product is displayed: {productName}")
    public EcommercePage verifyProductDisplayed(String productName) {
        $$(".card")
                .findBy(text(productName))
                .shouldBe(visible);

        return this;
    }

    @Step("Add product to cart: {productName}")
    public EcommercePage addProductToCart(String productName) {
        SelenideElement productCard = $$(".card")
                .findBy(text(productName));

        productCard
                .shouldBe(visible)
                .$x(".//button[contains(text(), 'Add to Cart')]")
                .click();

        return this;
    }

    @Step("Open cart")
    public EcommercePage openCart() {
        cartButton
                .shouldBe(visible)
                .click();

        return this;
    }
    @Step("Verify product is present in cart: {productName}")
    public EcommercePage verifyProductInCart(String productName) {
        $$(".list-group-item")
                .findBy(text(productName))
                .shouldBe(visible);

        return this;
    }
}