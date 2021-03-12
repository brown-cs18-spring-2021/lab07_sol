class Food(val name: String, val tastiness: Int)

object Foods {

  def goodFood(foods: List[Food]): List[Food] = {
    foods filter (x => x.tastiness > 20)
  }

}
