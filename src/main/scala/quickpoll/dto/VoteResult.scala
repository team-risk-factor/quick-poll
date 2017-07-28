package quickpoll.dto

import scala.beans.BeanProperty

case class VoteResult(@BeanProperty totalVotes: Int, @BeanProperty results: List[OptionCount]) {
  def this() = {
    this(0, Nil)
  }
}
