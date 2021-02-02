import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure}

case class Product(var id:Int, var name:String, var qte:Double){
	override def toString = "Prod :"+name+" id : "+id+" Qte: "+qte
}

case object DataBase
{
     var products=List.empty[Product]

     def add(id:Int, name:String,qte:Double)={products = Product(id, name, qte)::products}

     def remove (id:Int)={products = products.filter(_.id  != id)}

     def getProduct(i:Int):Future[Product]={Thread.sleep(3000)
          Future{ (products.filter(x => x.id == i)) (0) }}

     def gets:Future[List[Product]]={
          Thread.sleep(3000)
          Future{products}}

     def displayAll:Unit={
          gets.onComplete{
               case Success(prods) => for (prods <- prods) println(prods) 
               case Failure(e) => println("An error has occurred: " + e.getMessage)
          }
     }
}
