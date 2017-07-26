package quickpoll.controller

import javax.inject.Inject

import org.springframework.http.{HttpHeaders, HttpStatus, ResponseEntity}
import org.springframework.web.bind.annotation.{RequestBody, RequestMapping, RequestMethod, RestController}
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

} 