package quickpoll.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RequestParam}
import quickpoll.domain.Vote
import quickpoll.dto.VoteResult
import quickpoll.repository.VoteRepository

import collection.JavaConverters._

class ComputeResultController {
  @Autowired
  val voteRepository: VoteRepository = null

  @RequestMapping(value=Array("/computeresult"), method=Array(RequestMethod.GET))
  def computeResult(@RequestParam pollId: Long) = {
    val allVotes = voteRepository.findByPoll(pollId).asScala
    val m:Map[Long,Iterable[Vote]] = allVotes.groupBy(_.id)
    val vr = new VoteResult()
    new ResponseEntity[VoteResult](vr,HttpStatus.OK)
  }
}
