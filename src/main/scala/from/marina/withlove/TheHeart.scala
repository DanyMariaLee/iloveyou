package from.marina.withlove

import Lyrics._

object TheHeart extends App {

  while (true) {
    iLoveYous.foreach { line =>
      Thread.sleep(1500)
      val ls = line.split(",")
      ls.headOption.map {
        lang =>
          val language = Console.GREEN + lang + Console.RESET
          val words = ls.tail.mkString(space, ", ", space)
          println(language + words + heart)
      }
    }
  }

}