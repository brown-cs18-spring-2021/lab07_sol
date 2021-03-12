import tester.Tester

class NamesTest {

  val names = List("Carrie", "Erick", "Isaac", "Evan")
  val duplicateNames = List("Carrie", "Erick", "Erick", "Isaac", "Erick")
  val noNames = List("Carrie", "Isaac")
  val empty = List()

  def testNames(t: Tester) {
    val names1 = new Names(names.toArray)
    names1.clear("Erick")

    t.checkExpect(names1, new Names(Array("Carrie", "CLEARED", "Isaac", "Evan")))

    val duplicateNames1 = new Names(duplicateNames.toArray)
    duplicateNames1.clear("Erick")

    t.checkExpect(duplicateNames1, new Names(Array("Carrie", "CLEARED", "CLEARED", "Isaac", "CLEARED")))

    val noNames1 = new Names(noNames.toArray)
    noNames1.clear("Erick")

    t.checkExpect(noNames1, new Names(Array("Carrie", "Isaac")))

    val emptyNames1 = new Names(empty.toArray)
    emptyNames1.clear("Erick")
    t.checkExpect(emptyNames1, new Names(List().toArray))
  }

  def testNames2(t: Tester) {
    val names2 = new Names2(names)
    names2.clear("Erick")

    t.checkExpect(names2, new Names2(List("Carrie", "CLEARED", "Isaac", "Evan")))

    val duplicateNames2 = new Names2(duplicateNames)
    duplicateNames2.clear("Erick")

    t.checkExpect(duplicateNames2, new Names2(List("Carrie", "CLEARED", "CLEARED", "Isaac", "CLEARED")))

    val noNames2 = new Names2(noNames)
    noNames2.clear("Erick")

    t.checkExpect(noNames2, new Names2(List("Carrie", "Isaac")))
  }

  def testNames3(t: Tester) {
    val names3 = new Names3(names)
    val newNames3 = names3.clear("Erick")

    t.checkExpect(names3, new Names3(List("Carrie", "Erick", "Isaac", "Evan")))
    t.checkExpect(newNames3, new Names3(List("Carrie", "CLEARED", "Isaac", "Evan")))

    val duplicateNames3 = new Names3(duplicateNames)
    val newDuplicateNames3 = duplicateNames3.clear("Erick")

    t.checkExpect(duplicateNames3, new Names3(List("Carrie", "Erick", "Erick", "Isaac", "Erick")))
    t.checkExpect(newDuplicateNames3, new Names3(List("Carrie", "CLEARED", "CLEARED", "Isaac", "CLEARED")))

    val noNames3 = new Names3(noNames)
    val newNoNames3 = noNames3.clear("Erick")

    t.checkExpect(noNames3, new Names3(List("Carrie", "Isaac")))
    t.checkExpect(newNoNames3, new Names3(List("Carrie", "Isaac")))
  }

}

object NamesTest {

  def main(args: Array[String]) {
    Tester.run(new NamesTest())
  }
}
