package lk.pituwa.hunspell

import java.io.PrintWriter

/**
  * Created by nayana on 8/14/17.
  */
object ListBuilder extends App {

  override def main(args: Array[String]): Unit = {
    println(s"Found Words ${WordParser.dic.size}" )
    val words = WordParser.dic.flatMap(w => {
      if (w.index.isEmpty) List(w.word)
      else {
        w.words
      }
    })
    val sql = words.map(word => s"""MERGE INTO WORD (WORD, COUNT) KEY (WORD) VALUES ('$word', 1);""")
    new PrintWriter("words.sql") { write(sql.mkString("\n")); close }

  }
}
