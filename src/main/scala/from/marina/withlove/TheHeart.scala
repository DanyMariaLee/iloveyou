package from.marina.withlove

import java.util.Locale

import from.marina.withlove.Lyrics._
import javax.speech.Central
import javax.speech.synthesis.{Synthesizer, SynthesizerModeDesc}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Try

object TheHeart extends App {

  System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us" + ".cmu_us_kal.KevinVoiceDirectory")
  Central.registerEngineCentral("com.sun.speech.freetts" + ".jsapi.FreeTTSEngineCentral")

  val desc = new SynthesizerModeDesc(Locale.US)
  val synthesizer = Central.createSynthesizer(desc)
  synthesizer.allocate()
  synthesizer.resume()

  while (true) {

    iLoveYous.foreach { line =>
      Thread.sleep(2000)
      val ls = line.split(",")

      ls.headOption.map {
        lang =>
          val language = Console.GREEN + lang + Console.RESET
          val words = ls.tail.mkString(space, ", ", space)

          Future(synthesizer.speak(ls.tail.mkString(","), null))
            .onComplete(_ => Try(println(language + words + heart)))
      }
    }
  }

  synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY)
  synthesizer.deallocate()

}