package th.ac.ku.cakeRunnerWeb;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import th.ac.ku.cakeRunnerWeb.controller.CakesController;
import th.ac.ku.cakeRunnerWeb.controller.OrderController;
import th.ac.ku.cakeRunnerWeb.model.Cakes;
import th.ac.ku.cakeRunnerWeb.model.Cart;
import th.ac.ku.cakeRunnerWeb.service.CakesService;
import th.ac.ku.cakeRunnerWeb.service.OrderService;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class BuyStepdefs {
    private CakesService catalog;
    private OrderService order;

    @Given("the store is ready to service customers")
    public void the_store_is_ready_to_service_customers() {
        catalog = new CakesService();
        order = new OrderService();
    }

    @Given("a product {string} is {string} with weight {int}, price {int}, and stock of {int} exists")
    public void a_product_exists(String id, String name, int weight, int price, int amount) {
        catalog.addProduct1(UUID.fromString(id), name, weight, price, amount);
    }

    //ให้ UUID เปลี่ยนเป็น String ก่อน ละค่อยเอาเข้าเทส
    @When("I buy {string} with quantity {int}")
    public void i_buy_with_quantity(String name, int quantity) {
        Cakes cake = catalog.getProduct(name);
        order.addItem(cake, quantity);
    }

    @Then("total should be {int}")
    public void total_should_be(int total) {
        assertEquals(total, order.getTotal());
    }
}
