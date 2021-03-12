import scala.math

/**
  * Currying is an object for students to practice currying functions.
  *
  * @author cs18tas
  */
object Currying {
  /**
    * tastinessPred takes in an number and a food and tells you if
    * the food's tastiness value is larger than the number
    *
    * @param num - the number to compare to
    * @param food - the Food whose tastiness value you are comparing
    * @return - a boolean, false if the food isn't tasty enough, true otherwise
    */
  def tastinessPred(num: Int, food: Food) = food.tastiness >= num

  /**
    * minTastiness filters foods, keeping only Foods with tastiness >= num
    *
    * @param foods - a list of foods to filter
    * @param num - the minimum tastiness
    * @return - a filtered list of foods
    */
  def minTastiness(num: Int)(foods: List[Food]): List[Food] = foods.filter(x => tastinessPred(num, x))

  /**
    * Calls minTastiness with a minimum tastiness score of 20.
    */
  def tastinessOver20 = minTastiness(20)_

  /**
    * Returns the original list if total tastiness >= num, otherwise
    * returns an empty list.
    *
    * @param num - an int that the sum of tastiness must be larger than
    * @param foods - the input list of foods
    * @return - a list of Food, empty if the sum of foods < num,
    *           otherwise, the original input list
    */
  def sumTastiness(num: Int)(foods: List[Food]): List[Food] = {
    val proteinSum = foods.foldLeft(0)((b, a) => a.tastiness + b)
    if (proteinSum > num) foods else List[Food]()
  }

  /**
    * Calls sumTastiness with a minimum sum of 50
    */
  def sumTastinessOver50 = sumTastiness(50)_
}
