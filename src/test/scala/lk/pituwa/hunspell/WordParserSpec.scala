package lk.pituwa.hunspell

import org.scalatest.FlatSpec

/**
  * Created by nayana on 8/14/17.
  */
class WordParserSpec extends FlatSpec
{
  "WordParser" should "have a list of Words" in {
    assert(WordParser.dic.nonEmpty)
  }

  "Word" should "have list of compounds" in {
    val testWord = WordParser.dic.filter(_.index.nonEmpty).head
    assert(testWord.words.nonEmpty)
  }
}
