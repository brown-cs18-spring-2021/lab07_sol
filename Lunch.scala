class Lunch(ingredients: List[String]) {
  def makeSandwich = ingredients
}

trait PeanutButter extends Lunch {
  override def makeSandwich = "Peanut Butter" :: super.makeSandwich
}

trait Bread extends Lunch {
  override def makeSandwich = "Bread" :: super.makeSandwich ::: List("Bread")
}

trait HoldTheAnchovies extends Lunch {
  override def makeSandwich = super.makeSandwich filter (_ != "Anchovies")
}

trait DoubleIngredients extends Lunch {
  override def makeSandwich =
    super.makeSandwich.foldRight(List[String]())({ (x, y) => x :: x :: y })
}

object Lunch {
  val myList = List("Anchovies", "Cream Cheese", "Pickles")
  val sunday = new Lunch(List()) with PeanutButter
  val saturday = new Lunch(List("Cream Cheese", "Pikachu")) with HoldTheAnchovies

  // students only need the below ones, and any two of their choice
  val monday = new Lunch(myList) with Bread
  val tuesday = new Lunch(myList) with DoubleIngredients with Bread
  val wednesday = new Lunch(myList) with Bread with DoubleIngredients with HoldTheAnchovies
  val thursday = new Lunch(myList) with PeanutButter with HoldTheAnchovies
  val friday = new Lunch(myList) with HoldTheAnchovies with PeanutButter with DoubleIngredients with Bread
}
