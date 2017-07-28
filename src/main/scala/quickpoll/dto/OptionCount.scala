package quickpoll.dto

import scala.beans.BeanProperty

case class OptionCount(@BeanProperty optionId: Long, @BeanProperty count:Int) {
  def this() = {
    this(0, 0)
  }
}
