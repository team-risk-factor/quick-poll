package quickpoll.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.data.jpa.repository.Query
import quickpoll.domain.Vote

trait VoteRepository extends CrudRepository[Vote, java.lang.Long] {
  @Query(value="select v.* from Option o, Vote v where o.POLL_ID = ?1 and v.OPTION_ID = o.OPTION_ID", nativeQuery=true)
  def findByPoll(pollId: Long):java.lang.Iterable[Vote]
}