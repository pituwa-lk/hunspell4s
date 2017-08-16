package lk.pituwa.hunspell

/**
  * Created by nayana on 8/14/17.
  */
case class Word(word: String, index: List[Int]) {
  lazy val words = {
    index.map(v => {
      AffixParser.sfx.get(v) match {
        case Some(x) => x.morph(word)
        case None => "..."
      }
    })
  }
}

object WordParser {

  def isAllDigits(x: String) = x forall Character.isDigit

  lazy val dic = {
    io.Source.fromResource("si_LK.dic").getLines().filter(!isAllDigits(_)).toList.map(l => {
      l.contains("/") match {
        case true => {
          val p = l.split("/")
          Word(p(0), p(1).split(",").toList.map(_.toInt))
        }
        case false => {
          Word(l, List.empty)
        }
      }
    })
  }
}
