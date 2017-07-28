package quickpoll.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{HttpHeaders, HttpStatus, ResponseEntity}
import org.springframework.web.bind.annotation._
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import quickpoll.domain.Vote
import quickpoll.repository.VoteRepository

@RestController
class VoteController {
    @Autowired
    val voteRepository: VoteRepository = null

    @RequestMapping(value=Array("/polls/{pollId}/votes"), method=Array(RequestMethod.POST))
    def createVote(@PathVariable pollId: Long, @RequestBody vote: Vote): ResponseEntity[AnyRef] = {
        val newVote = voteRepository.save(vote)
        val responseHeaders = new HttpHeaders()
        responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vote.id).toUri)
        new ResponseEntity[AnyRef](null,responseHeaders,HttpStatus.CREATED)
    }

    @RequestMapping(value=Array("/polls/{pollId}/votes"), method=Array(RequestMethod.GET))
    def getAllVotes(@PathVariable pollId: Long): java.lang.Iterable[Vote] = {
        voteRepository.findByPoll(pollId)
    }
}