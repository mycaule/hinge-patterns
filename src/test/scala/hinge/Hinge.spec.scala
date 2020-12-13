package hinge

import org.scalatest._
import Hinge._
import Hinge.Direction._
import Hinge.Command._

class HingeSpec extends FlatSpec with Matchers {
  val shape = Shape(5, 5)
  val pos1 = Position(1, 2, North)
  val pos2 = Position(5, 1, East)

  it should "parse and serialize positions" in {
    pos1.toString shouldBe "1 2 N"
    pos2.toString shouldBe "5 1 E"

    Position.parse("1 2 N") shouldBe Some(pos1)
    Position.parse("5 1 E") shouldBe Some(pos2)
    Position.parse("? ? ?") shouldBe None
  }

  it should "parse instructions" in {
    Command.parse(Seq(0, 1, 2, 3, 4, 5)) shouldBe List(Nothing, Left, Right, Down, LeftDown, RightDown)
    Command.parse(Seq(0, 1, 0, 1)) shouldBe List(Nothing, Left, Nothing, Left)
    Command.parse(Seq()) shouldBe List()
  }

  it should "parse shapes" in {
    Shape.parse("5 5") shouldBe Some(Shape(5, 5))
    Shape.parse("? ?") shouldBe None
  }

  it should "translate objects" in {
    Hinge.fold(shape)(pos1, Down) shouldBe Position(1, 3, North)
    Hinge.fold(shape)(pos2, Down) shouldBe Position(5, 1, East)
  }

  it should "rotate objects" in {
    Hinge.fold(shape)(pos1, Left) shouldBe Position(1, 2, West)
    Hinge.fold(shape)(pos2, Right) shouldBe Position(5, 1, South)
  }

  it should "check if objects are inside the shape" in {
    shape.check(Position(5, -1, North)) shouldBe false
    shape.check(Position(10, 5, North)) shouldBe false
    shape.check(Position(5, 5, North)) shouldBe true
  }

  it should "solve simple examples" in {
    Command.parse(Seq(0, 1, 0, 1, 0, 2)).foldLeft(Position(1, 2, North))(Hinge.fold(shape)) shouldBe Position(1, 2, West)
    Command.parse(Seq(0, 1, 0, 1, 2, 3, 4)).foldLeft(Position(3, 3, East))(Hinge.fold(shape)) shouldBe Position(3, 5, North)
  }
}
