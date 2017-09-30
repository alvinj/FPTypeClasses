package typeclasses.v3_order2string


// (1) the Type Class
trait ToString[A] {
    def asString(a: A): String
}


// (2) type class instances we want
// gory "to string" functions here
object ToStringInstances {

    implicit val pizzaAsString = new ToString[Pizza] {
        def asString(p: Pizza): String = pizzaAsAStringHelper(p)
    }

    implicit val orderAsString = new ToString[Order] {
        def asString(o: Order): String = {
            val orderString =s"""|Customer: (${o.customer})""".stripMargin

            val pizzaString = for {
                p <- o.pizzas
            } yield pizzaAsAStringHelper(p)

            orderString + "\n" + pizzaString
        }
    }

    // a little helper method that both instances can use to print a pizza
    private def pizzaAsAStringHelper(p: Pizza): String = {
        s"""|Pizza(${p.crustSize}, ${p.crustType}),
            |      toppings = ${p.toppings}""".stripMargin
    }

}

// (3a)
object ToString {
    def asString[A](a: A)(implicit toStringInstance: ToString[A]): String = {
        toStringInstance.asString(a)
    }
}

// (3b)
object ToStringSyntax {

    implicit class ToStringOps[A](value: A) {
        def asString(implicit toStringInstance: ToString[A]): String = {
            toStringInstance.asString(value)
        }
    }

}
