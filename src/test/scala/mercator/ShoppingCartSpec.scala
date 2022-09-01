package mercator

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartSpec extends AnyFlatSpec with Matchers {

  "Shopping Cart" should "return total price of zero for empty cart" in {
    ShoppingCart.checkout() shouldBe 0
  }

  "Shopping Cart" should "return total price when given list of items" in {
    ShoppingCart.checkout("Apple", "Orange", "Orange", "Apple", "Apple") shouldBe 2.30
  }
}
