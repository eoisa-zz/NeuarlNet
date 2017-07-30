package examples

import helpers.TensorSugar
import org.tensorflow._

import scala.io.StdIn._

object ProofOfConcept_1 extends App with TensorSugar {
  override def main(args: Array[String]) = {

    //  Get Data
    println("List values for 'X' using the following paradigm:")
    val xUserInput = readLine("value_1, value_2, value_3, ... value_n => ")
    val xIn = extractUserInput(xUserInput)

    println("List values for 'Y' using the following paradigm:")
    val yUserInput = readLine("value_1, value_2, value_3, ... value_n => ")
    val yIn = extractUserInput(yUserInput)

    //  Build Graph
    val graph = new Graph()

    val x = newPlaceholder(graph, "x", DataType.INT64, None)
    val y = newPlaceholder(graph, "y", DataType.INT64, None)

    val add = add_Int64(graph, "z", List(x, y))

    //  Create Session
    val session = new Session(graph)

    //  Run Session
    for(i <- 0 to xIn.length){
      var xTensor = Tensor.create(xIn(i))
      var yTensor = Tensor.create(yIn(i))
      var output = session.runner().feed(x.output(0), xTensor).feed(y.output(0), yTensor).fetch(add.output(0)).run().get(0)
      println(s"${xIn(i)} + ${yIn(i)} = ${output.longValue()}")
    }
  }

  private def extractUserInput(input: String) = {
    val rawValues = input.split(',')
    rawValues.map{value => value.toLong}
  }
}