import scala.collection.mutable

/**
  * Created by halleyfroeb on 10/19/16.
  */
trait Employee {
  val name: String
  val title: String

  override def toString: String = (s"My name is: $name ($title)")
}

class Manager extends Employee {
  override val name: String = ""
  val title = "Mgr"
}

class Worker extends Employee {
  override val name: String = ""
  val title = "Wkr"
}

object Main {
  def main(args: Array[String]): Unit = {
    val employees: mutable.MutableList[Employee] = mutable.MutableList[Employee]()

    val bob: Employee = new Employee {
      override val name = "Bob"
      val title = "Bldr"
    }
    val charlie: Employee = new Manager {
      override val name = "Charlie"
    }
    val joe: Employee = new Worker {
      override val name = "Joe"
    }
    employees += (bob, charlie, joe)

    val e = mutable.HashMap[String, String]()

    employees.foreach(x => {
      e += (x.name -> x.toString)
    })

    e.foreach(x => {
      println(x._2 + "\n")
    })

  }

}

