package quickpoll.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RequestParam, RestController}
import quickpoll.dto.{OptionCount, VoteResult}
import quickpoll.repository.VoteRepository

import collection.JavaConverters._

@RestController
class ComputeResultController {
  @Autowired
  val voteRepository: VoteRepository = null

  @RequestMapping(value=Array("/computeresult"), method=Array(RequestMethod.GET))
  def computeResult(@RequestParam pollId: Long):ResponseEntity[VoteResult] = {
    val allVotes = voteRepository.findByPoll(pollId).asScala
    val optionCountList = allVotes.groupBy(_.id).map(m => OptionCount(m._1, m._2.size)).toList
    val totalVotes = optionCountList.foldLeft(0)( (x,o) => x + o.count )
    val vr = VoteResult(totalVotes,optionCountList)
    new ResponseEntity[VoteResult](vr,HttpStatus.OK)
  }
}
