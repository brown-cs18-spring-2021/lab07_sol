import tester.Tester

class FoodTest {

  def testNoFood(t: Tester) {
    val noFood: List[Food] = Nil
    t.checkExpect(Foods.goodFood(noFood), Nil)
  }

  def testOneFoodAt20(t: Tester) {
    val oneFoodAt20: List[Food] = List(new Food("Hot Dog", 20))
    t.checkExpect(Foods.goodFood(oneFoodAt20), Nil)
  }

  def testOneFoodOver20(t: Tester) {
    val oneFoodOver20: List[Food] = List(new Food("Burger", 50))
    t.checkExpect(Foods.goodFood(oneFoodOver20), List(new Food("Burger", 50)))
  }

  def testOneFoodUnder20(t: Tester) {
    val oneFoodUnder20: List[Food] = List(new Food("Bowl of Mustard", 0))
    t.checkExpect(Foods.goodFood(oneFoodUnder20), Nil)
  }

  def testManyFoods(t: Tester) {
    val manyFoods: List[Food] = List(new Food("Hot Dog", 20), new Food("Burger", 50), new Food("Bowl of Mustard", 0))
    t.checkExpect(Foods.goodFood(manyFoods), List(new Food("Burger", 50)))
  }

}

object FoodTest extends App {
    Tester.run(new FoodTest())
}