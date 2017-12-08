package chapter1

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.linalg.Vectors

import scala.io.Source

object IrisKMeans {
  def main(args: Array[String]) {

    val appName = "IrisKMeans"
    val master = "local"
    val conf = new SparkConf().setAppName(appName).setMaster(master)
    val sc = new SparkContext(conf)

    println("Loading iris data from URL...")
    val url = "https://archive.ics.uci.edu/ml/machine-learning-databases/iris/iris.data"
    val src = Source.fromURL(url).getLines.filter(_.size > 0).toList
    val textData = sc.parallelize(src)
    val parsedData = textData
      .map(_.split(",").dropRight(1).map(_.toDouble))
      .map(Vectors.dense(_)).cache()

    val numClusters = 3
    val numIterations = 20
    val clusters = KMeans.train(parsedData, numClusters, numIterations)

    // Evaluate clustering by computing Within Set Sum of Squared Errors
    val WSSSE = clusters.computeCost(parsedData)
    println("Within Set Sum of Squared Errors = " + WSSSE)
  }
}