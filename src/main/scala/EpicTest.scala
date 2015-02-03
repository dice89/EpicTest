/**
 * Created by mueller on 03/02/15.
 */
object EpicTest extends App{

  addPosTag(tokenize_low_whiteSpace)("I like to play Soccer.")


  def tokenize_low_whiteSpace(a: String): List[String] = {
    a.split(" ")toList
  }

  def addPosTag(tokenize_fct:String=>List[String])(a:String):String = {

    val tagger = epic.models.PosTagSelector.loadTagger("en").get // or another 2 letter code.

    val tags = tagger.bestSequence(tokenize_fct(a).toIndexedSeq)

    println(tags)

    a
  }



}
