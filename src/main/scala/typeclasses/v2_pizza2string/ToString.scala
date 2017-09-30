package typeclasses.v2_pizza2string

// (1) the Type Class
trait ToString[A] {
    def toString(a: A): String
}


// (2) type class instances we want
// gory "to string" functions here
object ToStringInstances {
    implicit val pizzaAsString = new ToString[Pizza] {
        def toString(p: Pizza): String = {
            s"""|Pizza(${p.crustSize}, ${p.crustType}),
                |      toppings = ${p.toppings}""".stripMargin
        }
    }
}


// (3a)
object ToString {
    def asString[A](a: A)(implicit toStringInstance: ToString[A]): String = {
        toStringInstance.toString(a)
    }
}

// (3b)
object ToStringSyntax {
    implicit class ToStringOps[A](value: A) {
        def asString(implicit toStringInstance: ToString[A]): String = {
            toStringInstance.toString(value)
        }
    }
}
