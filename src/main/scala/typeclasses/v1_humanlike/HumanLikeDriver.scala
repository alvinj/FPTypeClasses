package typeclasses.v1_humanlike

sealed trait Animal
final case class Dog(name: String) extends Animal
final case class Cat(name: String) extends Animal
final case class Bird(name: String) extends Animal

object HumanLikeDriver extends App {

    import BehavesLikeHumanInstances.dogBehavesLikeHuman

    val rover = Dog("Rover")

    // (3a) apply the functions to the Dog instance
    //import BehavesLikeHuman.{speak, eatHumanFood}  //can also import the functions
    BehavesLikeHuman.speak(rover)(dogBehavesLikeHuman)
    BehavesLikeHuman.eatHumanFood(rover)(dogBehavesLikeHuman)

    // (3b) import the function, and you can call it on the Dog instance
    import BehavesLikeHumanSyntax.BehavesLikeHumanOps
    rover.speak
    rover.eatHumanFood

    // the function isn't implemented for a Cat or Bird, so these won't work
    //speak(Cat("Garfield"))
    //speak(Bird("Polly"))

}



