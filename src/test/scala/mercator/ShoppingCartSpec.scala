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
    ShoppingCart.checkout("Orange", "Orange", "Orange", "Apple", "Apple") shouldBe 1.10
  }

  it should "return total price when both offers applied on multiple items" in {
    ShoppingCart.checkout("Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple") shouldBe 1.95
  }
}
