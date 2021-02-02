import scala.util.{Success, Failure}
import scala.concurrent.ExecutionContext.Implicits.global

object Hello extends App{

import DataBase._

val db = DataBase

db.add(1,"prod1",12.30)
db.add(2,"prod2",50.01)
db.add(3,"prod3",78.30)
db.add(3,"prod4",69.30)

db.getProduct(3).onComplete{
    case Success(result) => println(result)
    case Failure(e) => println("An error has occurred: " + e.getMessage)
}

db.displayAll 

}
