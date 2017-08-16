package lk.pituwa.hunspell

/**
  * Created by nayana on 8/14/17.
  */
abstract class Affix(prefix:String) //should be enough but who cares can change it
case class SfxAffix(index: Int, strip: String, replacement: String, condition: String) extends Affix("SFX") {

  def morph(base: String): String = {
    if (strip == "0") base + replacement
    else {
      if (base.endsWith(condition)) {
        base.dropRight(strip.length) + replacement
      } else {
        base
      }
    }
  }
}

object AffixParser {

  lazy val res: List[String] = io.Source.fromResource("si_LK.aff").getLines().toList

  lazy val _sfx: List[Array[String]] = {
    res.filter(_.startsWith("SFX")).filter(_.split(" ")(2) != "Y").map(_.split(" "))
  }

  lazy val sfx: Map[Int, SfxAffix] = {
    _sfx.map(__sfx => {
      __sfx(1).toInt -> SfxAffix(__sfx(1).toInt, __sfx(2), __sfx(3), __sfx(4))
    }).toMap
  }
}
