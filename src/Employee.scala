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
  val name: String = ""
  val title = "Mgr"
}

class Worker extends Employee {
  val name: String = ""
  val title = "Wkr"
}

object Main {
  def main(args: Array[String]): Unit = {

    val employees: mutable.MutableList[Employee] = mutable.MutableList[Employee]()

    val bob = new Worker {override val name = "Bob"}
    val charlie = new Manager {override val name = "Charlie"}
    val joe = new Worker {override val name = "Joe"}

    employees += (bob, charlie, joe)

    val employeeMap = mutable.HashMap[String, String]()

    employees.foreach(x => {
      employeeMap += (x.name -> x.toString)
    })

    employeeMap.foreach(x => {
      println(x._2 + "\n")
    })

//optional
    println("Choose a title: worker[Wkr] or manager[Mgr]")
    val response: String = io.StdIn.readLine()

    val employeesByTitle = employees.filter(x => x.title.equalsIgnoreCase(response))
    employeesByTitle.foreach(x => {
      println(x.toString)
    })





  }

}

