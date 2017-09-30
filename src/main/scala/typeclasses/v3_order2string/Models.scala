package typeclasses.v3_order2string

sealed trait Topping
case object Cheese extends Topping
case object Pepperoni extends Topping
case object Sausage extends Topping
case object Mushrooms extends Topping
case object Onions extends Topping

sealed trait CrustSize
case object SmallCrustSize extends CrustSize
case object MediumCrustSize extends CrustSize
case object LargeCrustSize extends CrustSize

sealed trait CrustType
case object RegularCrustType extends CrustType
case object ThinCrustType extends CrustType
case object ThickCrustType extends CrustType

// clean model here
case class Pizza (
    crustSize: CrustSize,
    crustType: CrustType,
    toppings: Seq[Topping]
)

case class Order (
    pizzas: Seq[Pizza],
    customer: Customer
)

case class Customer (
    name: String,
    phone: String,
    address: Address
)

case class Address (
    street1: String,
    street2: Option[String],
    city: String,
    state: String,
    zipCode: String
)


