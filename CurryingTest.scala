import tester.Tester

/**
  * CurryingTest is a tester class for the Currying object.
  * @author cs18tas
  */
class CurryingTest {
  /**
    * Tests for minTastiness
    */
  def testminTastiness(t: Tester) {
    t.checkExpect(Currying.minTastiness(20)(List(new Food("Bacon", 0))), List[Food]())
    t.checkExpect(Currying.minTastiness(21)(List(new Food("Bacon", 23), new Food("Steak", 22), new Food("Lettuce", 0))),
      List(new Food("Bacon", 23), new Food("Steak", 22)))
    t.checkExpect(Currying.minTastiness(-1)(List(new Food("Bacon", 23), new Food("Steak", 22), new Food("Lettuce", 0))),
      List(new Food("Bacon", 23), new Food("Steak", 22), new Food("Lettuce", 0)))
  }

  /**
    * Tests for sumTastiness
    */
  def testSumTastiness(t: Tester) {
    t.checkExpect(Currying.sumTastiness(40)(List(new Food("Steak", 12), new Food("Protein Shake", 3), new Food("Lettuce", 0))),
      List[Food]())

    t.checkExpect(Currying.sumTastiness(40)(
      List(new Food("Bacon", 13),
        new Food("Celery", 31),
        new Food("Steak", 12),
        new Food("Protein Shake", 3),
        new Food("Lettuce", 0))),
      List(new Food("Bacon", 13),
        new Food("Celery", 31),
        new Food("Steak", 12),
        new Food("Protein Shake", 3),
        new Food("Lettuce", 0)))

    t.checkExpect(Currying.sumTastiness(80)(
      List(new Food("Bacon", 13),
        new Food("Celery", 31),
        new Food("Steak", 12),
        new Food("Protein Shake", 3),
        new Food("Lettuce", 0))),
      List())
  }

  /**
    * Tests for tastinessOver20
    */
  def testTastinessOver20(t: Tester) {
    t.checkExpect(Currying.tastinessOver20(List(new Food("A", 50), new Food("B", 5))), List(new Food("A", 50)))
    t.checkExpect(Currying.tastinessOver20(List(new Food("A", 10), new Food("B", 5))), List[Food]())
  }

  /**
    * Tests for sumTastinessOver50
    */
  def testSumTastinessOver50(t: Tester) {
    t.checkExpect(Currying.sumTastinessOver50(List(new Food("A", 50), new Food("B", 5))), List(new Food("A", 50), new Food("B", 5)))
    t.checkExpect(Currying.sumTastinessOver50(List(new Food("A", 10), new Food("B", 5))), List[Food]())
  }
}

object CurryingTest {

  def main(args: Array[String]) {
    Tester.run(new CurryingTest)
  }
}
