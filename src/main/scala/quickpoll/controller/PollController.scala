package quickpoll.controller

import javax.inject.Inject

import org.springframework.http.{HttpHeaders, HttpStatus, ResponseEntity}
import org.springframework.web.bind.annotation._
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import quickpoll.domain.Poll
import quickpoll.repository.PollRepository

@RestController
class PollController {
    @Inject
    val pollRepository: PollRepository = null

    @RequestMapping(value=Array("/polls"), method=Array(RequestMethod.GET))
    def getAllPolls: ResponseEntity[java.lang.Iterable[Poll]] = {
        val allPolls = pollRepository.findAll()
        new ResponseEntity(allPolls, HttpStatus.OK)
    }

    @RequestMapping(value=Array("/polls"), method=Array(RequestMethod.POST))
    def createPoll(@RequestBody poll: Poll): ResponseEntity[AnyRef] = {
        val newPoll = pollRepository.save(poll)
        val newPollURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newPoll.id).toUri
        val responseHeaders = new HttpHeaders()
        responseHeaders.setLocation(newPollURI)
        new ResponseEntity[AnyRef](null,responseHeaders,HttpStatus.CREATED)
    }

    @RequestMapping(value=Array("/polls/{pollId}"), method=Array(RequestMethod.GET))
    def getPoll(@PathVariable pollId: Long): ResponseEntity[Poll] = {
        val p = Option(pollRepository.findOne(pollId))
        if(p.isDefined)
            new ResponseEntity[Poll](p.get, HttpStatus.OK)
        else
            new ResponseEntity[Poll](null.asInstanceOf[Poll], HttpStatus.NOT_FOUND)
    }

    @RequestMapping(value=Array("/polls/{pollId}"), method=Array(RequestMethod.PUT))
    def updatePoll(@RequestBody poll: Poll, @PathVariable pollId: Long): ResponseEntity[AnyRef] = {
        pollRepository.save(poll)
        new ResponseEntity[AnyRef](HttpStatus.OK)
    }

    @RequestMapping(value=Array("/polls/{pollId}"), method=Array(RequestMethod.DELETE))
    def deletePoll(@PathVariable pollId: Long): ResponseEntity[AnyRef] = {
        pollRepository.delete(pollId)
        new ResponseEntity[AnyRef](HttpStatus.OK)
    }
} 