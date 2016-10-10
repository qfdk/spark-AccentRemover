# Apache Spark AccentRemover

This project will help you to remove the letter accent in French. When you want to stemm the French word, they have some accent, you may want to change or remove it.

## How to use it ?

e.g.

Clone the projet, use the commande `sbt package`, 
put the *jar* in the root of project `lib` and `import org.apache.spark.ml.feature.StopWordsRemover`
then you can use it in pipeline stage.

```scala
    val stemmer = new Stemmer()
      .setInputCol("tokens")
      .setOutputCol("stemmed")
      .setLanguage("French")

    val stopWordsRemover2 = new StopWordsRemover()
      .setInputCol("stemmed")
      .setOutputCol("tokens2")
    stopWordsRemover2.setStopWords(stopWordsRemover2.getStopWords ++ stopWordText2)

    val accentRemover = new AccentRemover()
      .setInputCol("tokens2")
      .setOutputCol("mot")
```


- "ā|á|â|à|ä" --> "a"
- "é|è|ê|ë"--> "e"

etc..