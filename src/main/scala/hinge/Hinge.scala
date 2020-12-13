package hinge

object Hinge {
  object Command extends Enumeration {
    type Command = Value
    val Nothing = Value("0")
    val Left = Value("1")
    val Right = Value("2")
    val Down = Value("3")
    val LeftDown = Value("4")
    val RightDown = Value("5")

    def parse(s: Seq[Integer]): Seq[Command] = scala.util.Try(s.map(_.toString).map(this.withName)).getOrElse(Nil)
  }

  implicit class StringImprovements(s: String) {
    private def encode(c: Char): Seq[Integer] = {
      c match {
        case 'A' => Seq(1, 0, 0, 0, 1, 0, 2, 0, 1, 0, 0, 3, 0, 0, 4, 0, 2)
        case 'B' => Seq(1, 0, 0, 0, 1, 0, 2, 0, 1, 0, 0, 3, 0, 1, 0, 2, 0, 0)
        case 'C' => Seq(0, 1, 0, 2, 0, 0, 0, 0, 1, 0, 2, 0)
        case 'D' => Seq(1, 0, 0, 0, 0, 4, 0, 1, 0, 0, 0, 2, 0, 0)
        case 'E' => Seq(0, 0, 2, 0, 1, 0, 0, 3, 0, 1, 0, 2, 0, 0)
        case 'F' => Seq(0, 0, 2, 0, 1, 0, 0, 3, 0, 1, 0, 2)
        case 'G' => Seq(0, 0, 2, 0, 0, 0, 1, 0, 2, 0)
        case 'H' => Seq(1, 0, 0, 0, 3, 0, 1, 0, 2, 0, 0, 3, 0, 0, 0, 0, 2)
        case 'I' => Seq(1, 0, 0, 0, 0)
        case 'J' => Seq(0, 1, 0, 2, 0, 0, 0, 0)
        case 'K' => Seq(1, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 0, 3, 1, 1, 0, 2, 2, 2)
        case 'L' => Seq(0, 0, 0, 0, 0, 4, 3, 0, 0)
        case 'M' => Seq(1, 0, 0, 0, 1, 2, 0, 2, 1, 0, 1, 2, 0, 0, 0, 2)
        case 'N' => Seq(1, 0, 0, 0, 0, 3, 1, 1, 1, 2, 0, 0, 3, 0, 0, 0, 1)
        case 'O' => Seq(0, 0, 0, 1, 0, 2, 0, 0, 0, 1, 0, 2)
        case 'P' => Seq(1, 0, 0, 0, 1, 0, 2, 0, 1, 0, 1)
        case 'Q' => Seq(1, 0, 2, 0, 0, 0, 1, 0, 2, 0, 0, 0, 1, 0, 1, 1)
        case 'R' => Seq(1, 0, 0, 0, 1, 0, 2, 0, 1, 0, 0, 3, 1, 1, 1, 1)
        case 'S' => Seq(0, 0, 1, 0, 2, 0, 2, 0, 1, 0, 0, 3, 0, 2, 0, 1, 0, 1, 0)
        case 'T' => Seq(1, 0, 0, 0, 2, 0, 3, 0, 0)
        case 'U' => Seq(0, 0, 0, 0, 1, 0, 2, 0, 0, 0, 0)
        case 'V' => Seq(0, 0, 0, 0, 1, 1, 4, 1, 0, 0, 0, 0)
        case 'W' => Seq(0, 0, 0, 0, 1, 2, 0, 2, 1, 0, 1, 2, 0, 0, 0, 0)
        case 'X' => Seq(1, 1, 1, 0, 2, 2, 0, 3, 1, 1, 1, 2, 2, 2, 0, 3, 1, 1, 0, 2, 2, 2)
        case 'Y' => Seq(1, 0, 2, 2, 0, 0, 3, 0, 1, 1, 4, 1, 0, 0)
        case 'Z' => Seq(0, 0, 0, 5, 2, 2, 2, 2, 0, 0, 4, 0, 0)
        case '0' => Seq(0, 0, 0, 1, 0, 2, 0, 0, 0, 1, 0, 2)
        case '1' => Seq(0, 5, 0, 0, 0, 0, 5, 2)
        case '2' => Seq(0, 0, 1, 0, 2, 0, 2, 0, 1, 0, 0)
        case '3' => Seq(0, 0, 2, 0, 1, 0, 0, 3, 0, 1, 0, 2, 0, 0)
        case '4' => Seq(1, 0, 2, 0, 2, 0, 0, 3, 0, 1, 0, 2, 0, 0, 3, 0, 0, 0, 2)
        case '5' => Seq(0, 0, 5, 0, 0, 3, 0, 2, 0, 1, 0, 1, 0, 0, 4, 3, 0, 0)
        case '6' => Seq(0, 0, 0, 0, 3, 0, 1, 0, 1, 0, 2, 0, 1, 5, 0)
        case '7' => Seq(1, 0, 0, 0, 2, 0, 0)
        case '8' => Seq(1, 5, 0, 1, 0, 1, 0, 2, 0, 1, 0, 2, 0, 2, 0, 1, 0)
        case '9' => Seq(1, 0, 2, 0, 2, 0, 1, 0, 2, 0, 0)
        case _   => Seq()
      }

      // TODO pad with zeros in 22 size list
    }

    def toStrip: Seq[Seq[Integer]] = s.toUpperCase.map(encode)

    def toASCII: Seq[Byte] = s.map(_.toByte)
  }

  object Direction extends Enumeration {
    type Direction = Value
    val North = Value("N")
    val South = Value("S")
    val East = Value("E")
    val West = Value("W")
  }

  case class Shape(x: Integer, y: Integer)

  case class Position(x: Integer, y: Integer, d: Direction.Direction) {
    override def toString = s"$x $y $d"
  }

  def fold(shape: Shape)(pos: Position, cmd: Command.Command) = {
    val newPos = cmd match {
      case Command.Nothing => pos.d match {
        case Direction.North => pos.copy(y = pos.y + 1)
        case Direction.South => pos.copy(y = pos.y - 1)
        case Direction.East  => pos.copy(x = pos.x + 1)
        case Direction.West  => pos.copy(x = pos.x - 1)
      }
      case Command.Left => pos.d match {
        case Direction.North => pos.copy(d = Direction.West, x = pos.x - 1)
        case Direction.South => pos.copy(d = Direction.East, x = pos.x + 1)
        case Direction.East  => pos.copy(d = Direction.North, y = pos.y + 1)
        case Direction.West  => pos.copy(d = Direction.South, y = pos.y - 1)
      }
      case Command.Right => pos.d match {
        case Direction.North => pos.copy(d = Direction.East, x = pos.x + 1)
        case Direction.South => pos.copy(d = Direction.West, x = pos.x - 1)
        case Direction.East  => pos.copy(d = Direction.South, y = pos.y - 1)
        case Direction.West  => pos.copy(d = Direction.North, y = pos.y + 1)
      }
      case Command.Down => pos.d match {
        case Direction.North => pos.copy(d = Direction.South, y = pos.y - 1)
        case Direction.South => pos.copy(d = Direction.North, y = pos.y + 1)
        case Direction.East  => pos.copy(d = Direction.West, x = pos.x - 1)
        case Direction.West  => pos.copy(d = Direction.East, x = pos.x + 1)
      }
      case Command.LeftDown => pos.d match {
        case Direction.North => pos.copy(d = Direction.East, x = pos.x + 1)
        case Direction.South => pos.copy(d = Direction.West, x = pos.x - 1)
        case Direction.East  => pos.copy(d = Direction.South, y = pos.y - 1)
        case Direction.West  => pos.copy(d = Direction.North, y = pos.y + 1)
      }
      case Command.RightDown => pos.d match {
        case Direction.North => pos.copy(d = Direction.West)
        case Direction.South => pos.copy(d = Direction.East)
        case Direction.East  => pos.copy(d = Direction.North)
        case Direction.West  => pos.copy(d = Direction.South)
      }
    }

    newPos
  }

  def main(args: Array[String]): Unit = {
    val filename = if (args.size > 0) args(0) else "examples/program.shap"
    val file = scala.io.Source.fromFile(filename).getLines

    file.foreach(line => {
      println(s"$line: ${line.toASCII}")
      println(s"   ${line.toStrip}")

      // TODO instructions on how to fold, shape of the figure
    })
  }
}
