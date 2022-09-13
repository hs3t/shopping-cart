package mercator

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartSpec extends AnyFlatSpec with Matchers {

  behavior of "Shopping Cart"

  it should "return total price of zero for empty cart" in {
    ShoppingCart.checkout() shouldBe 0
  }

  it should "return total price when given the list of items" in {
    ShoppingCart.checkout("Orange", "Apple", "Orange") shouldBe 1.10
  }

  it should "return total price when buy one get one free Apple offer applied" in {
    ShoppingCart.checkout("Apple", "Apple", "Orange", "Apple") shouldBe 1.45
  }

  it should "return total price when three for two Oranges offer applied" in {
    ShoppingCart.checkout("Orange", "Orange", "Orange", "Apple") shouldBe 1.10
  }

  it should "return total price when both offers applied" in {
    ShoppingCart.checkout("Orange", "Orange", "Orange", "Apple", "Apple", "Banana") shouldBe 1.10
  }

  it should "return total price when both offers applied for both Apples and Banana" in {
    ShoppingCart.checkout("Orange", "Orange", "Orange", "Apple", "Apple", "Banana", "Banana") shouldBe 1.10
  }

  it should "return total price when both offers applied when we have more Bananas in price" in {
    ShoppingCart.checkout("Orange", "Orange", "Orange",
      "Apple", "Apple",
      "Banana", "Banana", "Banana", "Banana", "Banana", "Banana", "Banana", "Banana") shouldBe 1.30
  }

  it should "return total price when both offers applied when we have equal Bananas in price" in {
    ShoppingCart.checkout("Orange", "Orange", "Orange",
      "Apple", "Apple",
      "Banana", "Banana", "Banana", "Banana", "Banana", "Banana") shouldBe 1.10
  }
    it should "return total price when both offers applied on multiple items" in {
    ShoppingCart.checkout("Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple") shouldBe 1.95
  }
}
