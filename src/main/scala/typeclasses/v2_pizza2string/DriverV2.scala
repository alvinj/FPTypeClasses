package typeclasses.v2_pizza2string

object DriverV2 extends App {

    import ToStringInstances.pizzaAsString
    import ToStringSyntax._

    val p = Pizza(LargeCrustSize, ThinCrustType, Seq(Cheese, Pepperoni, Sausage))

    println("\nHere's the pizza")
    println("----------------")

    // OPTION 1
    println(ToString.asString(p))

    // OPTION 2
    println(p.asString)

}


