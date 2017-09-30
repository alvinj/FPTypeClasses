package typeclasses.v3_order2string

object DriverV3 extends App {

    import ToStringInstances.{orderAsString, pizzaAsString}
    import ToStringSyntax._

    println("\nHere's the pizza")
    println("----------------")
    val p = Pizza(LargeCrustSize, ThinCrustType, Seq(Cheese, Pepperoni, Sausage))

    // OPTION 1
    println(ToString.asString(p))

    // OPTION 2
    println(p.asString)


    /**
      * now do the same thing for an Order
      */
    val address = Address(
        "1 Main Street",
        None,
        "Talkeetna",
        "AK",
        "99676"
    )

    val customer = Customer(
        "Alvin Alexander",
        "907-555-1212",
        address
    )

    val order = Order(
        Seq(p),
        customer
    )

    println("\nHere's the Order")
    println("----------------")
    println(order.asString)

}


