package lk.pituwa.hunspell

import org.scalatest.FlatSpec

/**
  * Created by nayana on 8/14/17.
  */
class AffixParserSpec extends FlatSpec
{
  "AffixParser" should "have a list of Words" in {
    assert(AffixParser.sfx.nonEmpty)
    assert(AffixParser.sfx.size == 5000)
  }

  "SfxAffix" should "perform morph logic correctly" in {
    val sfx = SfxAffix(1, "B", "C", "B")
    assert(sfx.morph("ABB") == "ABC")
  }
}
