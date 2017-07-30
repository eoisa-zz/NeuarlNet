package helpers

import org.tensorflow._

trait TensorSugar {

  def newPlaceholder(g: Graph, name: String, dataType: DataType, value: Option[Tensor]) = {
    if (value.isEmpty) {
      g.opBuilder("Placeholder", name).setAttr("dtype", dataType).build()
    } else {
      g.opBuilder("Placeholder", name).setAttr("dtype", dataType).setAttr("value", value.get).build()
    }
  }

  def add_Int64(g:Graph, name: String, values: List[Operation]) = {
    val operation = g.opBuilder("Add", name)
    values.foreach{value => operation.addInput(value.output(0))}
    operation.build()
  }



}
