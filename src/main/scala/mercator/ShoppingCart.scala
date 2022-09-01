package mercator

object ShoppingCart {

  type Item = String

  val itemCost: Map[Item, Double] = Map(
    "Apple" -> 0.60,
    "Orange" -> 0.25
  )
  def checkout(items: Item*): Double = (buyOneOffer(items) ++ threeForTwoOffer(items)).map(itemCost).sum

  /**
   * Buy one get one free offer on Apples
   * function applies only to apples.
   * It calculates and returns number of apples by counting each pair of apples as one (dividing it by 2)
   * And in case of odd number of apples it adds one to discountedCount (remainder of 2)
   */
  def buyOneOffer(items: Seq[Item]): Seq[String] = {
    val count = items.count(_ == "Apple")
    val discountedCount = count / 2 + count % 2
    Seq.tabulate(discountedCount) {_ => "Apple"}
  }

  /**
   * Three for two offer on Oranges
   * function applies only to oranges.
   * It calculates and return number of oranges by counting three oranges as two (dividing by 3 and multiply by 2)
   * And an remaining oranges that are not divisible by three add it discountedCount (remainder of 3)
   */
  def threeForTwoOffer(items: Seq[Item]): Seq[String] = {
    val count = items.count(_ == "Orange")
    val discountedCount = 2 * (count / 3) + count % 3
    Seq.tabulate(discountedCount) {_ => "Orange"}
  }
}
