package mercator

object ShoppingCart {

  type Item = String

  val itemCost: Map[String, Double] = Map(
    "Apple" -> 0.60,
    "Orange" -> 0.25
  )
  def checkout(items: Item*): Double = items.map(itemCost).sum

}
