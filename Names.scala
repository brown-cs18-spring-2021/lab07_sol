import scala.collection.immutable.List

/**
 * Class containing an array of names as a val.
 */
class Names(nameList: Array[String]) {
  /**
   * Changes instances of a given name to "CLEARED".
   * @param name - the name to be removed
   */
  def clear(name: String) {
    for (i <- 0 until nameList.length) {
      if (nameList(i) == name) nameList(i) = "CLEARED"
    }
  }
}

/**
 * Class containing a list of names as a var.
 */
class Names2(private var nameList: List[String]) {

  /**
   * Changes instances of a given name to "CLEARED".
   * @param name - the name to be removed
   * @return the previous list
   */
  def clear(name: String) {
    nameList = nameList map (x =>
      x match {
        //backticks allow matching parameter
        //could also use an if expression here
        case `name` => "CLEARED"
        case x      => x
      })
  }
}

/**
 * Class containing a list of names as a val.
 */
class Names3(nameList: List[String]) {
  /**
   * Changes instances of a given name to "CLEARED".
   * @param name - the name to be removed
   * @return a new instance of Names3 with an updated list
   */
  def clear(name: String): Names3 = {
    val newList = nameList map (x =>
      x match {
        //backticks allow matching parameter
        //could also use an if expression here
        case `name` => "CLEARED"
        case x      => x
      })
    new Names3(newList)
  }
}
