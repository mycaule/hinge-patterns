package hinge

import org.scalatest._
import Hinge._
import Hinge.Direction._
import Hinge.Command._

class HingeSpec extends FlatSpec with Matchers {
  val shape = Shape(5, 5)
  val pos1 = Position(1, 2, North)
  val pos2 = Position(5, 1, East)

  it should "parse instructions" in {
    Command.parse(Seq(0, 1, 2, 3, 4, 5)) shouldBe List(Nothing, Left, Right, Down, LeftDown, RightDown)
    Command.parse(Seq(0, 1, 0, 1)) shouldBe List(Nothing, Left, Nothing, Left)
    Command.parse(Seq()) shouldBe List()
  }

  it should "translate objects" in {
    Hinge.fold(shape)(pos1, Down) shouldBe Position(1, 1, South)
    Hinge.fold(shape)(pos2, Down) shouldBe Position(4, 1, West)
  }

  it should "rotate objects" in {
    Hinge.fold(shape)(pos1, Left) shouldBe Position(0, 2, West)
    Hinge.fold(shape)(pos2, Right) shouldBe Position(5, 0, South)
  }

  it should "solve simple examples" in {
    Command.parse(Seq(0, 1, 0, 1, 0, 2)).foldLeft(Position(1, 2, North))(Hinge.fold(shape)) shouldBe Position(-2, 1, West)
    Command.parse(Seq(0, 1, 0, 1, 2, 3, 4)).foldLeft(Position(3, 3, East))(Hinge.fold(shape)) shouldBe Position(2, 5, West)
  }
}
